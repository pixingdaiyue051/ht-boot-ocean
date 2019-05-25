package com.tequeno.common.constants;

public class CommonQuery {

    private Integer currentPage;

    private Integer pageSize;

    private String loadMethod;

    private String orderBy;

    public CommonQuery() {
        loadMethod = "selectAllByCondition";
        orderBy = "create_time desc";
        currentPage = 1;
        pageSize = 10;
    }

    public CommonQuery(String loadMethod) {
        this();
        this.loadMethod = loadMethod;
    }

    public CommonQuery(String loadMethod, String orderBy) {
        this();
        this.loadMethod = loadMethod;
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

    public String getLoadMethod() {
        return loadMethod;
    }

    public void setLoadMethod(String loadMethod) {
        this.loadMethod = loadMethod;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
