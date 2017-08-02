package com.tangjing.wind.webapi.controller;

import com.tangjing.wind.model.system.SysUser;
import com.tangjing.wind.service.ISysUserService;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Describe:
 * User:tangjing
 * Date:2017/7/31
 * Time:下午2:15
 */
@RestController
@RequestMapping("/rs/swagger/")
@Api("查询用户")
public class SysUserController{
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Autowired
    private ISysUserService service;

    @RequestMapping(value="name/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获", httpMethod = "GET",consumes="application/json", response = SysUser.class, notes = "根据用户名获取用户对象")
    public List<SysUser> getUserByName(@PathVariable  String name) {
        List<SysUser> results = null;
        try {
            results= service.getUser(name);
        } catch (Exception e) {
            logger.error(e.getMessage().toString());
        }
        logger.info("查询成功");
        return results;
    }


    @RequestMapping(value="name/select/{userId}",method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获", httpMethod = "GET",consumes="application/json", response = SysUser.class, notes = "根据用户名获取用户对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键ID", required = true, paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "userName", value = "姓名", required = true, paramType = "query",dataType = "String")
    })
    public SysUser expend( @PathVariable  int userId , @RequestParam String userName) {
        SysUser u=null;
        try {
            u= service.expendUser(userId,userName);
        } catch (Exception e) {
            logger.error(e.getMessage().toString());
        }
        logger.info("查询成功");
        return u;
    }

}
