package com.jk.mapper.djh;

import com.jk.model.djh.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User2Mapper {

    @Select("select count(*) from user")
    long queryUserCount(User user);

    @Select("select * from user limit #{st},#{rows}")
    List<User> queryUserList(@Param("st") int start, @Param("rows")Integer rows, @Param("user")User user);

    @Delete("delete from user where uid = #{id} ")
    void deleteUser(Integer id);

    @Insert("insert into user(username,password,name,email,phone,addr,state) values(#{username},#{password},#{name},#{email},#{phone},#{addr},#{state})")
    int addUser(User user);

    @Select("select * from user where uid = #{id}")
    User queryUserById(Integer id);

    @Update(" update user u set u.username = #{username},u.password = #{password},u.name = #{name},u.email = #{email},u.phone = #{phone},u.addr = #{addr} \n" +
            "  where u.uid =#{uid}")
    int updateUser(User user);
}
