package com.board.aaa.service;

import com.board.aaa.dto.*;
import com.board.aaa.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class BoardService {

    @Autowired(required = false)
    BoardMapper boardMapper;

    //게시글 조회
    public ArrayList<ListDto> getList() throws Exception {
        return boardMapper.getList();
    }

    //게시글 등록
    public void write(WriteDto writeDto) throws Exception{
        boardMapper.write(writeDto);
    }

    //게시글 상세페이지 조회
    public ArrayList<DetailDto> getBoard(String bno) throws Exception{
        return boardMapper.getBoard(bno);
    }

    //조회수
    public void count(String bno) throws Exception {
        boardMapper.count(bno);
    }

    //게시글 수정
    public void update(UpdateDto updateDto) throws Exception {
        boardMapper.update(updateDto);
    }
    //게시글 삭제
    public void delete(DeleteDto deleteDto) throws Exception {
        boardMapper.delete(deleteDto);
    }
}
