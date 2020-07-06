package com.board.aaa.controller;

import com.board.aaa.dto.*;
import com.board.aaa.service.BoardService;
import com.board.aaa.service.ReplyService;
import com.board.aaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class BoardRestController {

    @Autowired
    BoardService boardService;
    @Autowired
    ReplyService replyService;
    @Autowired
    UserService userService;

//    public static String uploadpath = "C:\\upload";

    //로그인확인
    @PostMapping("/rest/login")
    public void login(UserLoginDto userLoginDto, Model model, HttpSession httpSession) throws Exception {
        UserLoginDto userInfo = userService.userLogin(userLoginDto);
        System.out.println("유저정보 :" + userInfo.toString());
        httpSession.setAttribute("userInfo",userInfo);

    }

    //게시글 작성
    @PostMapping("/rest/write")
    public void write(WriteDto writeDto) throws Exception {//, MultipartFile file
//        ArrayList<ListDto> list = boardService.getList();
//        int n = 0;
//        for(ListDto a : list){
//            if (a.getTitle().equals(writeDto.getTitle())) {
//                System.out.println("제목 중복 O");
//                n=1;
//                return n;
//            }
//        }
//        System.out.println("제목 중복X");
//        try{
//            file.transferTo(new File(uploadpath, file.getOriginalFilename()));
//            writeDto.setImage(file.getOriginalFilename());//uploadpath +
//
//        } catch (IllegalStateException | IOException e){
//            e.printStackTrace();
//        }
        boardService.write(writeDto);
        System.out.println("작성 Dto : " + writeDto.toString());
//        return n;
    }


    //추천하기-일반
    @PutMapping("/rest/r")
    public void ucount(ReDto reDto) throws Exception {
        System.out.println("일반 추천 : " + reDto.toString());
        if(reDto.getTypeName().equals("일반")){
            boardService.ucount(reDto);
        }else{
            boardService.acount(reDto);
        }
    }

//    //추천하기-전문가
//    @PutMapping("/rest/ru")
//    public void ucount(@PathVariable String bno) throws Exception {
//        System.out.println("일반 추천 : " + bno);
//        boardService.acount(bno);
//    }
//
//    //추천하기-전문가
//    @PutMapping("/rest/ra")
//    public void acount(@PathVariable String bno) throws Exception {
//        System.out.println("전문가 추천 : " + bno);
//        boardService.acount(bno);
//    }

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
