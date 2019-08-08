package org.QGStudio.dao;


import org.QGStudio.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {


    @Select("select * from userList where user_id = #{userId}")
    User testUser(int userId);
}
