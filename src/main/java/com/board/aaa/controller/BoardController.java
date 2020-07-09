package com.board.aaa.controller;

import com.board.aaa.dto.ReDto;
import com.board.aaa.dto.UserLoginDto;
import com.board.aaa.service.BoardService;
import com.board.aaa.service.ReplyService;
import com.board.aaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sun.text.resources.FormatData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    ReplyService replyService;
    @Autowired
    UserService userService;


    //로그인
    @GetMapping("/")
    public String login() throws Exception {
        return "/login";
    }

    //회원목록
    @GetMapping("/user/list")
    public String userList(Model model, HttpSession httpSession) throws Exception{
        model.addAttribute("userList", userService.userList());
        model.addAttribute("userInfo",httpSession.getAttribute("userInfo"));
        return "/userlist";
    }

    //게시글 목록
    @GetMapping("/list")
    public String getList(UserLoginDto userLoginDto, Model model, HttpSession httpSession) throws Exception{
        model.addAttribute("userInfo",httpSession.getAttribute("userInfo"));
        model.addAttribute("boardList",boardService.getList());

        return "/list";
    }

    //게시글 등록
    @GetMapping("/write")
    public String write(Model model, HttpSession httpSession) throws Exception {
        model.addAttribute("userInfo",httpSession.getAttribute("userInfo"));
        return "/write";
    }
    //상세페이지 조회 & 추천수 증가
    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable String bno, Model model, HttpSession httpSession) throws Exception {
//        ReDto reDto = httpSession.getAttribute("userInfo");
        String a = httpSession.getAttribute("userInfo").toString();
        System.out.println("제발좀 : " +  a.substring(61, 65) );
//        userService.type(reDto);
        model.addAttribute("userInfo",httpSession.getAttribute("userInfo"));
//        System.out.println("타입이름 : " + reDto.getTypeName());
        if(a.substring(61,65).equals("True")){
            model.addAttribute("boardList", boardService.getBoard(bno));
            boardService.acount(bno);
        }else{
            model.addAttribute("boardList", boardService.getBoard(bno));
            boardService.ucount(bno);
        }
////        model.addAttribute("replyList", replyService.selectReply(bno));
        System.out.println("게시글정보 : " + boardService.getBoard(bno).toString());
        System.out.println("유저정보 :" + httpSession.getAttribute("userInfo").toString());

        return "/detail";
    }
    //게시글 수정 페이지
    @GetMapping("/update/{bno}")
    public String update(@PathVariable String bno, HttpServletRequest request, HttpServletResponse response,
                         Model model, HttpSession httpSession) throws Exception {
        model.addAttribute("boardList", boardService.getBoard(bno));
        model.addAttribute("userInfo",httpSession.getAttribute("userInfo"));
        return "/update";
    }

}
