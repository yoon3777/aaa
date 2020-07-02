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
}