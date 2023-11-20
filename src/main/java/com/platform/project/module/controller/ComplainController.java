package com.platform.project.module.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.platform.framework.aspectj.lang.annotation.Log;
import com.platform.framework.aspectj.lang.enums.BusinessType;
import com.platform.project.module.domain.Complain;
import com.platform.project.module.service.IComplainService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 投诉Controller
 * 
 */
@RestController
@RequestMapping("/module/complain")
public class ComplainController extends BaseController
{
    @Autowired
    private IComplainService complainService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Complain complain)
    {
        List<Complain> list = complainService.selectComplainList(complain);
        return AjaxResult.success(list);
    }


    /**
     * 查询投诉列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Complain complain)
    {
        startPage();
        List<Complain> list = complainService.selectComplainList(complain);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @Log(title = "投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Complain complain)
    {
        List<Complain> list = complainService.selectComplainList(complain);
        ExcelUtil<Complain> util = new ExcelUtil<Complain>(Complain.class);
        util.exportExcel(response, list, "投诉数据");
    }

    /**
     * 获取投诉详细信息
     */
    @GetMapping(value = "/{complainId}")
    public AjaxResult getInfo(@PathVariable("complainId") Long complainId)
    {
        return AjaxResult.success(complainService.selectComplainByComplainId(complainId));
    }

    /**
     * 新增投诉
     */
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Complain complain)
    {
        return toAjax(complainService.insertComplain(complain));
    }

    /**
     * 修改投诉
     */
    @Log(title = "投诉", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Complain complain)
    {
        return toAjax(complainService.updateComplain(complain));
    }

    /**
     * 删除投诉
     */
    @Log(title = "投诉", businessType = BusinessType.DELETE)
	@DeleteMapping("/{complainIds}")
    public AjaxResult remove(@PathVariable Long[] complainIds)
    {
        return toAjax(complainService.deleteComplainByComplainIds(complainIds));
    }
}
