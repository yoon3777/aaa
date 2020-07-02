package com.board.aaa.mapper;

import com.board.aaa.dto.ReplyDeleteDto;
import com.board.aaa.dto.ReplyListDto;
import com.board.aaa.dto.ReplyUpdateDto;
import com.board.aaa.dto.ReplyWriteDto;

import java.util.ArrayList;

public interface ReplyMapper {

    //댓글 조회
    public ArrayList<ReplyListDto> selectReply(String bno) throws Exception;
    //댓글 작성
    public void writeReply(ReplyWriteDto replyWriteDto) throws Exception;
    //댓글 수정
    public void updateReply(ReplyUpdateDto replyUpdateDto) throws Exception;
    //댓글 삭제
    public void deleteReply(ReplyDeleteDto replyDeleteDto) throws Exception;
}
