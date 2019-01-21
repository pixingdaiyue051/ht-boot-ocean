package com.tequeno.bootssm.controller;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("book")
public class BookController {
    private static final String INDEX = "book";
    private static final String TYPE = "novel";

    @Autowired
    private TransportClient client;

    @GetMapping("/novel/{id}")
    public ResponseEntity get(@PathVariable String id) {
        ResponseEntity responseEntity = null;
        try {
            GetResponse result = this.client.prepareGet(INDEX, TYPE, id).get();
            if (result.isExists()) {
                responseEntity = new ResponseEntity(result.getSource(), HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity(result.getSource(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/novel/add")
    public ResponseEntity add(@RequestParam(name = "title") String title,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "auth") String auth,
                              @RequestParam(name = "price") Double price,
                              @RequestParam(name = "releaceDate") String releaceDate) {
        ResponseEntity responseEntity = null;
        try {
            XContentBuilder content = XContentFactory.jsonBuilder().startObject()
                    .field("title", title)
                    .field("name", name)
                    .field("auth", auth)
                    .field("price", price)
                    .field("releaceDate", releaceDate)
                    .endObject();
            IndexResponse response = this.client.prepareIndex(INDEX, TYPE).setSource(content).get();
            responseEntity = new ResponseEntity(response.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/novel/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        ResponseEntity responseEntity = null;
        try {
            DeleteResponse response = this.client.prepareDelete(INDEX, TYPE, id).get();
            responseEntity = new ResponseEntity(response.getResult(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/novel/update")
    public ResponseEntity update(@RequestParam(name = "id") String id,
                                 @RequestParam(name = "title", required = false) String title,
                                 @RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "auth", required = false) String auth,
                                 @RequestParam(name = "price", required = false) Double price,
                                 @RequestParam(name = "releaceDate", required = false) String releaceDate) {
        ResponseEntity responseEntity = null;
        try {
            UpdateRequest request = new UpdateRequest(INDEX, TYPE, id);
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            if (StringUtils.isNotBlank(title)) {
                builder.field("title", title);
            }
            if (StringUtils.isNotBlank(name)) {
                builder.field("name", name);
            }
            if (StringUtils.isNotBlank(auth)) {
                builder.field("auth", auth);
            }
            if (null != price) {
                builder.field("price", price);
            }
            if (null != releaceDate) {
                builder.field("releaceDate", releaceDate);
            }
            builder.endObject();
            request.doc(builder);
            UpdateResponse response = this.client.update(request).get();
            responseEntity = new ResponseEntity(response.getResult(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/novel/query")
    public ResponseEntity query(@RequestParam(name = "title", required = false) String title,
                                @RequestParam(name = "name", required = false) String name,
                                @RequestParam(name = "auth", required = false) String auth,
                                @RequestParam(name = "price", required = false) Double price,
                                @RequestParam(name = "releaceDate", required = false) String releaceDate) {
        ResponseEntity responseEntity = null;
        try {
            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
            boolQuery.must(QueryBuilders.matchQuery("title", title));

            SearchRequestBuilder builder = this.client.prepareSearch(INDEX)
                    .setTypes(TYPE)
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setQuery(boolQuery);
//            System.out.println(builder);
            SearchResponse response = builder.get();
            System.out.println(response);
            List<Map<String, Object>> mapList = new ArrayList<>();
            for (SearchHit hint : response.getHits()) {
                mapList.add(hint.getSource());
            }
            responseEntity = new ResponseEntity(mapList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
