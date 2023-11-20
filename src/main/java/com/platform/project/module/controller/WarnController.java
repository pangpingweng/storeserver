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
import com.platform.project.module.domain.Warn;
import com.platform.project.module.service.IWarnService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 报警Controller
 * 
 */
@RestController
@RequestMapping("/module/warn")
public class WarnController extends BaseController
{
    @Autowired
    private IWarnService warnService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Warn warn)
    {
        List<Warn> list = warnService.selectWarnList(warn);
        return AjaxResult.success(list);
    }


    /**
     * 查询报警列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Warn warn)
    {
        startPage();
        List<Warn> list = warnService.selectWarnList(warn);
        return getDataTable(list);
    }

    /**
     * 导出报警列表
     */
    @Log(title = "报警", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Warn warn)
    {
        List<Warn> list = warnService.selectWarnList(warn);
        ExcelUtil<Warn> util = new ExcelUtil<Warn>(Warn.class);
        util.exportExcel(response, list, "报警数据");
    }

    /**
     * 获取报警详细信息
     */
    @GetMapping(value = "/{warnId}")
    public AjaxResult getInfo(@PathVariable("warnId") Long warnId)
    {
        return AjaxResult.success(warnService.selectWarnByWarnId(warnId));
    }

    /**
     * 新增报警
     */
    @Log(title = "报警", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Warn warn)
    {
        return toAjax(warnService.insertWarn(warn));
    }

    /**
     * 修改报警
     */
    @Log(title = "报警", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Warn warn)
    {
        return toAjax(warnService.updateWarn(warn));
    }

    /**
     * 删除报警
     */
    @Log(title = "报警", businessType = BusinessType.DELETE)
	@DeleteMapping("/{warnIds}")
    public AjaxResult remove(@PathVariable Long[] warnIds)
    {
        return toAjax(warnService.deleteWarnByWarnIds(warnIds));
    }
}
