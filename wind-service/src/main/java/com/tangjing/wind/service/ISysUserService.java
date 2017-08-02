package com.tangjing.wind.service;

import com.tangjing.wind.model.system.SysUser;

import java.util.List;

public interface ISysUserService {

    List<SysUser> getUser(String userName) throws Exception;

    SysUser expendUser(int userId,String userName) throws Exception;
}
