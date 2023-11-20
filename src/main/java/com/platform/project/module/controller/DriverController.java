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
import com.platform.project.module.domain.Driver;
import com.platform.project.module.service.IDriverService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 司机Controller
 * 
 */
@RestController
@RequestMapping("/module/driver")
public class DriverController extends BaseController
{
    @Autowired
    private IDriverService driverService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Driver driver)
    {
        List<Driver> list = driverService.selectDriverList(driver);
        System.out.println(list);
        return AjaxResult.success(list);
    }


    /**
     * 查询司机列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Driver driver)
    {
        startPage();
        List<Driver> list = driverService.selectDriverList(driver);
        return getDataTable(list);
    }

    /**
     * 导出司机列表
     */
    @Log(title = "司机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Driver driver)
    {
        List<Driver> list = driverService.selectDriverList(driver);
        ExcelUtil<Driver> util = new ExcelUtil<Driver>(Driver.class);
        util.exportExcel(response, list, "司机数据");
    }

    /**
     * 获取司机详细信息
     */
    @GetMapping(value = "/{driverId}")
    public AjaxResult getInfo(@PathVariable("driverId") Long driverId)
    {
        return AjaxResult.success(driverService.selectDriverByDriverId(driverId));
    }

    /**
     * 新增司机
     */
    @Log(title = "司机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Driver driver)
    {
        return toAjax(driverService.insertDriver(driver));
    }

    /**
     * 修改司机
     */
    @Log(title = "司机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Driver driver)
    {
        return toAjax(driverService.updateDriver(driver));
    }

    /**
     * 删除司机
     */
    @Log(title = "司机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{driverIds}")
    public AjaxResult remove(@PathVariable Long[] driverIds)
    {
        return toAjax(driverService.deleteDriverByDriverIds(driverIds));
    }
}
