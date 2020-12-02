package com.tequeno.common.constants;

public class HtCommonQuery {

    private Integer currentPage;

    private Integer pageSize;

    private String orderClause;

    public HtCommonQuery() {
        orderClause = HtCommonPageInfo.ORDER_CLAUSE;
        currentPage = HtCommonPageInfo.CURRENT_PAGE;
        pageSize = HtCommonPageInfo.PAGE_SIZE;
    }


    public HtCommonQuery(String orderClause) {
        this();
        this.orderClause = orderClause;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderClause() {
        return orderClause;
    }

    public void setOrderClause(String orderClause) {
        this.orderClause = orderClause;
    }
}
