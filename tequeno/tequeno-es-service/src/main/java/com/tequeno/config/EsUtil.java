package com.tequeno.config;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MatchQueryParser;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @Desription:
 * @Author: hexk
 */
@Component
public class EsUtil {

    private final static String HOST = "192.168.3.64";

    public static void main(String[] args) {
        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(HOST, 9200, "http"),
                        new HttpHost(HOST, 9201, "http"),
                        new HttpHost(HOST, 9202, "http")
                )
        )) {
            SearchRequest searchRequest = new SearchRequest("ht-movie");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            // 查询
            sourceBuilder.query(QueryBuilders.matchQuery("title","A Space").operator(Operator.AND));
            // 分页
            sourceBuilder.from(0);
            sourceBuilder.size(20);
            // 排序
            sourceBuilder.sort("year", SortOrder.DESC);
            // 高亮
            sourceBuilder.highlighter(new HighlightBuilder().field("title").field("year"));
            // 超时时间
            sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(searchResponse);
            SearchHit[] hits = searchResponse.getHits().getHits();
            Stream.of(hits).forEach(hit -> {
                System.out.println("================================");
                Map<String, Object> asMap = hit.getSourceAsMap();
                asMap.forEach((k, v) -> System.out.printf("k:%s/v:%s%n", k, v));
                Map<String, HighlightField> highlightFieldMap = hit.getHighlightFields();
                highlightFieldMap.forEach((k, v) -> System.out.printf("k:%s/v:%s%n", k, v.getFragments()[0]));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}