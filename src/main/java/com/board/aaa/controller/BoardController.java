package com.board.aaa.controller;

import com.board.aaa.service.BoardService;
import com.board.aaa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    ReplyService replyService;

    //인덱스
    @GetMapping("/")
    public String getList(Model model) throws Exception{
        model.addAttribute("boardList",boardService.getList());
        return "/index";
    }
    //게시글 등록
    @GetMapping("/write")
    public String write() throws Exception {
        return "/write";
    }
    //상세페이지 조회 & 조회수 증가
    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable String bno, Model model) throws Exception {
        model.addAttribute("boardList", boardService.getBoard(bno));
        boardService.count(bno);
        model.addAttribute("replyList", replyService.selectReply(bno));
        return "detail";
    }
    //게시글 수정 페이지
    @GetMapping("/update/{bno}")
    public String update(@PathVariable String bno, Model model) throws Exception {
        model.addAttribute("boardList", boardService.getBoard(bno));
        return "update";
    }

}
