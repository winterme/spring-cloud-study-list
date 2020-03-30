package com.zzq.mapper;

import com.zzq.po.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper  extends JpaRepository<UserInfo , String>{

    @Query("select a from user_info a where a.username = ?1 ")
    List<UserInfo> getUserByUserName(String username);

}
