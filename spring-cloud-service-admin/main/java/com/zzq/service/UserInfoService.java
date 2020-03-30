package com.zzq.service;

import com.zzq.po.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserInfoService {

    public int insert(UserInfo userInfo);

    UserInfo getById(String id);

    public int updateById(UserInfo userInfo);

    public int deleteById(String uid);

    public List<UserInfo> getAll();

    public List<UserInfo> selectByUserName(String username);

}
