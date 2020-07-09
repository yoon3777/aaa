package com.board.aaa.mapper;

import com.board.aaa.dto.ReDto;
import com.board.aaa.dto.UserListDto;
import com.board.aaa.dto.UserLoginDto;

import java.util.ArrayList;

public interface UserMapper {
    //회원정보리스트
    public ArrayList<UserListDto> userList() throws Exception;
    //로그인
    public UserLoginDto userLogin(UserLoginDto userLoginDto) throws Exception;
    //dd
    public ReDto type(ReDto reDto) throws Exception;
}
