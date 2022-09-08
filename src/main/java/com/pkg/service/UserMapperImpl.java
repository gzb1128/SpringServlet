package com.pkg.service;

import com.pkg.dao.UserMapper;
import com.pkg.pojo.User;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bytedance
 */
@Component
@Data
public class UserMapperImpl implements UserMapper {
    SqlSessionTemplate sqlSession;
    @Autowired
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    public User getUserById(int id) {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getUserById(id);
    }

    public List<User> getUsers() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getUsers();
    }
}
