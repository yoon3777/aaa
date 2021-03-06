package com.board.aaa.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class DetailDto {
    private String bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private String image;
}
