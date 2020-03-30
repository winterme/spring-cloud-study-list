package com.zzq.service.impl;

import com.zzq.mapper.UserInfoMapper;
import com.zzq.po.UserInfo;
import com.zzq.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insert(UserInfo userInfo) {
        userInfo.setUid(UUID.randomUUID().toString());
        return (this.userInfoMapper.save( userInfo )!=null ? 1 : 0) ;
    }

    @Override
    public int updateById(UserInfo userInfo) {
        return this.userInfoMapper.saveAndFlush( userInfo ) != null ? 1 : 0 ;
    }

    @Override
    public UserInfo getById(String id) {
        return this.userInfoMapper.getOne(id);
    }

    @Override
    public int deleteById(String uid) {
        this.userInfoMapper.deleteById(uid);
        return  1;
    }

    @Override
    public List<UserInfo> getAll() {
        return this.userInfoMapper.findAll();
    }

    @Override
    public List<UserInfo> selectByUserName(String username) {

        return this.userInfoMapper.getUserByUserName(username);
    }
}
