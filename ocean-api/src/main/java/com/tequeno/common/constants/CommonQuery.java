package com.tequeno.common.constants;

public class CommonQuery {

    protected Integer currentPage;

    protected Integer pageSize;

    protected Integer pageStartedIndexIncluded;

    protected Integer pageEndedIndexIncluded;

    protected String loadMethod;

    protected String orderBy;

    public CommonQuery() {
        loadMethod = "selectAllByCondition";
        orderBy = "create_time desc";
        if (null != currentPage && null != pageSize) {
            int i = (currentPage - 1) * pageSize;
            pageStartedIndexIncluded = i <= 0 ? 1 : i;
            pageEndedIndexIncluded = currentPage * pageSize;
        }
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

    public int getPageStartedIndexIncluded() {
        return pageStartedIndexIncluded;
    }

    public void setPageStartedIndexIncluded(Integer pageStartedIndexIncluded) {
        this.pageStartedIndexIncluded = pageStartedIndexIncluded;
    }

    public int getPageEndedIndexIncluded() {
        return pageEndedIndexIncluded;
    }

    public void setPageEndedIndexIncluded(Integer pageEndedIndexIncluded) {
        this.pageEndedIndexIncluded = pageEndedIndexIncluded;
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
