package com.board.aaa.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyWriteDto {
    private String rno;
    private String bno;
    private String rcontent;
    private String rwriter;
    private Date r_regdate;

}
