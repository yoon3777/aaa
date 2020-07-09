package com.board.aaa.service;

import com.board.aaa.dto.ReDto;
import com.board.aaa.dto.UserListDto;
import com.board.aaa.dto.UserLoginDto;
import com.board.aaa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    //회원 정보 리스트
    public ArrayList<UserListDto> userList() throws Exception{
        return userMapper.userList();
    }
    //로그인
    public UserLoginDto userLogin(UserLoginDto userLoginDto) throws Exception{
        return userMapper.userLogin(userLoginDto);
    }

    //dd
    public ReDto type(ReDto reDto) throws Exception {
        return userMapper.type(reDto);
    }
}
