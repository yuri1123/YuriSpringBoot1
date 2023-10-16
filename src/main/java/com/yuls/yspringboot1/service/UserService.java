package com.yuls.yspringboot1.service;


import com.yuls.yspringboot1.dao.BoardDao;
import com.yuls.yspringboot1.dao.UserDao;
import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int createuser(UserDto userDto){
        return userDao.createuser(userDto);
    }

    public int updateuser(UserDto userDto){
        return userDao.updateuser(userDto);
    }

    public List<UserDto> selectuser(){
        return userDao.selectuser();
    }

    public UserDto login(UserDto userDto){
        return userDao.login(userDto);
    }

    public int deleteuser(Long id){
        return userDao.deleteuser(id);
    }


}
