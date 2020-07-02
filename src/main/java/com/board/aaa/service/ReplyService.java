package com.board.aaa.service;

import com.board.aaa.dto.*;
import com.board.aaa.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReplyService {

    @Autowired(required = false)
    ReplyMapper replyMapper;

    //댓글 조회
    public ArrayList<ReplyListDto> selectReply(String bno) throws Exception {
        return replyMapper.selectReply(bno);
    }

    //댓글 등록
    public void writeReply(ReplyWriteDto replyWriteDto) throws Exception{
        replyMapper.writeReply(replyWriteDto);
    }

    //댓글 수정
    public void updateReply(ReplyUpdateDto replyUpdateDto) throws Exception {
        replyMapper.updateReply(replyUpdateDto);
    }
    //댓글 삭제
    public void deleteReply(ReplyDeleteDto replyDeleteDto) throws Exception {
        replyMapper.deleteReply(replyDeleteDto);
    }
}
