package com.platform.project.system.controller;

import com.platform.project.system.domain.SysRole;
import com.platform.project.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.platform.common.utils.StringUtils;
import com.platform.framework.security.RegisterBody;
import com.platform.framework.security.service.SysRegisterService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;

import java.util.List;

/**
 * 注册验证
 * 
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;
    @Autowired
    private ISysRoleService roleService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
//        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
//        {
//            return error("当前系统没有开启注册功能！");
//        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }

    @GetMapping("/allRole")
    public AjaxResult allRole(SysRole role)
    {
        List<SysRole> list = roleService.selectRoleAll();
        return AjaxResult.success(list);
    }
}
