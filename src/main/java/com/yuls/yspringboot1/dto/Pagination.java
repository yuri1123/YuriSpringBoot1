package com.yuls.yspringboot1.dto;

public class Pagination {

    private int totalRecordCount; //전체 데이터 수
    private int totalPageCount; //전체 페이지 수
    private int startPage; //첫 페이지 번호
    private int endPage; //끝 페이지 번호
    private int limitStart; //limit 시작 위치
    private boolean existPrevPage; //이전 페이지 존재 여부
    private boolean existNextPage; //다음 페이지 존재 여부


    public Pagination(int totalRecordCount, SearchDto params){
        if(totalRecordCount >0){
            this.totalRecordCount = totalRecordCount;
            calculation(params);
        }
    }

    private void calculation(SearchDto params){

        //전체 페이지 수 계산 (22개 데이터라면 21/1페이지당10개 = 2) +1 => 3페이지
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize())+1;

        //현재 페이지 번호가 전체 페이지 수보다 큰 경우, 현재 페이지 번호에 전체 페이지 수 저장
        //(현재 페이지가 4쪽>전체 페이지 3페이지
        if(params.getPage() > totalPageCount){
            params.setPage(totalPageCount);
        }

        //첫 페이지 번호 계산(현재페이지가 35쪽-1 = 34/10개페이지보임 * 10페이지 +1 = 처음 31)
        startPage = ((params.getPage()-1)/params.getPageSize()
                            * params.getPageSize() + 1);

        //끝 페이지 번호 계산(시작 31 + 하단 10개 - 1 = 끝 40쪽)
        endPage = startPage+ params.getPageSize() - 1;

        //끝 페이지가 전체 페이지 수보다 큰 경우, 끝 페이지 수 저장
        if(endPage > totalPageCount){
            endPage = totalPageCount;
        }

        //limit 시작 위치 계산(현재 32페이지 - 1 = 31 * 한페이지당10개데이터; = 310번째 게시물부터)
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        //이전 페이지 존재 여부 확인(하단 보여지는 페이지수 단위로 해서 1일때만 이전 없음)
        existPrevPage = startPage != 1;

        //다음 페이지 존재 여부 확인(10페이지가 끝이면 * 한페이지당 10개 = 100 < 총 데이터 110개면 다음 있음)
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;


    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public boolean isExistPrevPage() {
        return existPrevPage;
    }

    public boolean isExistNextPage() {
        return existNextPage;
    }


}
