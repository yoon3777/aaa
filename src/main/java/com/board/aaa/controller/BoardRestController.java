package com.board.aaa.controller;

import com.board.aaa.dto.*;
import com.board.aaa.service.BoardService;
import com.board.aaa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {

    @Autowired
    BoardService boardService;
    @Autowired
    ReplyService replyService;

    //게시글 작성
    @PostMapping("/rest/write")
    public void write(WriteDto writeDto) throws Exception {
        boardService.write(writeDto);
    }

    //게시글 수정
    @PostMapping("/rest/update")
    public void update(UpdateDto updateDto) throws Exception {
        System.out.println("rest 업데이트 : " + updateDto.toString());
        boardService.update(updateDto);
    }

    //게시글 삭제
    @PostMapping("/rest/delete")
    public void delete(DeleteDto deleteDto) throws Exception {
        System.out.println("rest 딜리트 : " + deleteDto.toString());
        boardService.delete(deleteDto);
    }

    //댓글 작성
    @PostMapping("/rest/reply/write")
    public void writeReply(ReplyWriteDto replyWriteDto) throws Exception {
        System.out.println("reply 작성 : " + replyWriteDto.toString());
        replyService.writeReply(replyWriteDto);
    }

    //댓글 수정
    @PostMapping("/rest/reply/update")
    public void updateReply(ReplyUpdateDto replyUpdateDto) throws Exception {
        System.out.println("reply 수정 : " + replyUpdateDto.toString());
        replyService.updateReply(replyUpdateDto);
    }

    //댓글 삭제
    @PostMapping("/rest/reply/delete")
    public void deleteReply(ReplyDeleteDto replyDeleteDto) throws Exception {
        System.out.println("reply 딜리트 : " + replyDeleteDto.toString());
        replyService.deleteReply(replyDeleteDto);
    }
}
