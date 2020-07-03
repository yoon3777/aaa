package com.board.aaa.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ListDto {
    private String bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int ucount;
    private int acount;
    private int count;
    private String image;
}
