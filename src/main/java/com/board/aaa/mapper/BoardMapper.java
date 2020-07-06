package com.board.aaa.mapper;

import com.board.aaa.dto.*;

import java.util.ArrayList;

public interface BoardMapper {

    //글 조회
    public ArrayList<ListDto> getList() throws Exception;
    //글 작성
    public void write(WriteDto writeDto) throws Exception;
    //상세글 조회
    public ArrayList<DetailDto> getBoard(String bno) throws Exception;
    //조회수
    public void count(String bno) throws Exception;
    //글 수정
    public void update(UpdateDto updateDto) throws Exception;
    //글 삭제
    public void delete(DeleteDto deleteDto) throws Exception;
    //제목 중복 체크
    public int check(CheckDto checkDto) throws Exception;
    //추천하기 - 일반
    public void ucount(ReDto reDto) throws Exception;
    //추천하기 - 전문가
    public void acount(ReDto reDto) throws Exception;

//    //추천하기 - 일반
//    public void ucount(String bno) throws Exception;
//    //추천하기 - 전문가
//    public void acount(String bno) throws Exception;
}
