package com.tequeno.common.constants;

public class HtCommonQuery {

    private Integer currentPage;

    private Integer pageSize;

    private String orderBy;

    public HtCommonQuery() {
        orderBy = HtCommonPageInfo.ORDER_BY;
        currentPage = HtCommonPageInfo.CURRENT_PAGE;
        pageSize = HtCommonPageInfo.PAGE_SIZE;
    }


    public HtCommonQuery(String orderBy) {
        this();
        this.orderBy = orderBy;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
