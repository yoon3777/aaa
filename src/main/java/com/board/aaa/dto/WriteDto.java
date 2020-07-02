package com.board.aaa.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class WriteDto {
    private String title;
    private String content;
    private String writer;
    private Date regdate;
}
