package com.yuls.yspringboot1.dto;

import java.util.ArrayList;
import java.util.List;

public class PagingResponse<T> {

    private List<T> list = new ArrayList<>();
    private Pagination pagination;

    public PagingResponse(List<T> list, Pagination pagination){
        this.list.addAll(list);
        this.pagination = pagination;
    }

    public List<T> getList() {
        return list;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
