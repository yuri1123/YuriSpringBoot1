package com.yuls.yspringboot1.dto;

public class SearchDto {

    private int page; //현재 페이지 번호
    private int recordSize; //페이지당 출력할 데이터 개수
    private int pageSize; //화면 하단에 출력할 페이지 사이즈
    private String keyword; //검색키워드
    private String searchType; //검색 유형
    private Pagination pagination; //페이지네이션 타입 멤버를 가짐

    //초기 생성
    public SearchDto(){
        this.page = 1; //처음 페이지 1,
        this.recordSize = 10; //페이지당 출력 데이터 10
        this.pageSize = 10; //하단 출력 페이지 수 10
    }

    //이전 페이지 체크하고 시작되는 값의 위치
    public int getOffset(){
        return (page - 1) * recordSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
