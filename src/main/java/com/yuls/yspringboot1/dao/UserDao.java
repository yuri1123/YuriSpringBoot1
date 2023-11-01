package com.yuls.yspringboot1.dao;

import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired(required = true)
    private SqlSession sqlSession;
    private static final String namespace = "com.yuls.yspringboot1.userMapper";

    public int createuser(UserDto userDto){
        return sqlSession.insert(namespace +".createuser",userDto);
    };
    public int updateuser(UserDto userDto){
        return sqlSession.update(namespace+".updateuser",userDto);
    }

    public List<UserDto> selectuser(){
        return sqlSession.selectList(namespace+".selectuser");
    }
    public UserDto selectbyuserid(String userid){return sqlSession.selectOne(namespace+".selectbyid",userid);}

    public UserDto login(UserDto userDto){
        return sqlSession.selectOne(namespace+".login",userDto);
    }

    public int deleteuser(Long id){
        return sqlSession.delete(namespace+".deleteuser",id);
    }



}
