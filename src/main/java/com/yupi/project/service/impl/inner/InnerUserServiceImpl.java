package com.yupi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserMapper;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author 黄昊
 * @version 1.0
 **/
@DubboService
public class InnerUserServiceImpl implements InnerUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getInvokeUser(String accessKey) {
        if ((StringUtils.isAnyBlank(accessKey))){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("accessKey",accessKey);
        User user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user);
        return user;
    }
}
