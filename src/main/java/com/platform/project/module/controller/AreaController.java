package com.platform.project.module.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.platform.project.module.domain.Warn;
import com.platform.project.module.service.IWarnService;
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
import com.platform.project.module.domain.Area;
import com.platform.project.module.service.IAreaService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 分区Controller
 * 
 */
@RestController
@RequestMapping("/module/area")
public class AreaController extends BaseController
{
    @Autowired
    private IAreaService areaService;
    @Autowired
    private IWarnService warnService;
    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Area area)
    {
        List<Area> list = areaService.selectAreaList(area);
        return AjaxResult.success(list);
    }


    /**
     * 查询分区列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Area area)
    {
        startPage();
        List<Area> list = areaService.selectAreaList(area);
        return getDataTable(list);
    }

    /**
     * 导出分区列表
     */
    @Log(title = "分区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Area area)
    {
        List<Area> list = areaService.selectAreaList(area);
        ExcelUtil<Area> util = new ExcelUtil<Area>(Area.class);
        util.exportExcel(response, list, "分区数据");
    }

    /**
     * 获取分区详细信息
     */
    @GetMapping(value = "/{areaId}")
    public AjaxResult getInfo(@PathVariable("areaId") Long areaId)
    {
        return AjaxResult.success(areaService.selectAreaByAreaId(areaId));
    }

    /**
     * 新增分区
     */
    @Log(title = "分区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Area area)
    {
        return toAjax(areaService.insertArea(area));
    }

    /**
     * 修改分区
     */
    @Log(title = "分区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Area area)
    {
        if(Double.valueOf(area.getAreaTemp()) > Double.valueOf(area.getWarnTemp())){
            // 温度预警
            Warn warn = new Warn();
            warn.setAreaName(area.getStoreName()+"-"+area.getAreaName());
            warn.setAreaId(area.getAreaId());
            warn.setWarnName(area.getStoreName()+"-"+area.getAreaName()+"温度过高");
            warn.setWarnReason("温度超过"+area.getWarnTemp()+"℃");
            warn.setWarnDesc("当前温度"+area.getAreaTemp()+"℃");
            warnService.insertWarn(warn);
        }else if(Double.valueOf(area.getAreaTemp()) < Double.valueOf(area.getArea_downtemp())){
            // 温度预警
            Warn warn = new Warn();
            warn.setAreaName(area.getStoreName()+"-"+area.getAreaName());
            warn.setAreaId(area.getAreaId());
            warn.setWarnName(area.getStoreName()+"-"+area.getAreaName()+"温度过低");
            warn.setWarnReason("温度低于"+area.getWarnTemp()+"℃");
            warn.setWarnDesc("当前温度"+area.getAreaTemp()+"℃");
            warnService.insertWarn(warn);
        }

        if(Double.valueOf(area.getAreaHumidity()) > Double.valueOf(area.getWarnHumidity())){
            // 温度预警
            Warn warn = new Warn();
            warn.setAreaName(area.getStoreName()+"-"+area.getAreaName());
            warn.setAreaId(area.getAreaId());
            warn.setWarnName(area.getStoreName()+"-"+area.getAreaName()+"湿度过高");
            warn.setWarnReason("湿度超过"+area.getWarnTemp()+"%");
            warn.setWarnDesc("当前湿度"+area.getAreaTemp()+"%");
            warnService.insertWarn(warn);
        }else if(Double.valueOf(area.getAreaHumidity()) < Double.valueOf(area.getArea_downhumidity())){
            // 温度预警
            Warn warn = new Warn();
            warn.setAreaName(area.getStoreName()+"-"+area.getAreaName());
            warn.setAreaId(area.getAreaId());
            warn.setWarnName(area.getStoreName()+"-"+area.getAreaName()+"湿度过低");
            warn.setWarnReason("湿度低于"+area.getWarnTemp()+"%");
            warn.setWarnDesc("当前湿度"+area.getAreaTemp()+"%");
            warnService.insertWarn(warn);
        }
        return toAjax(areaService.updateArea(area));
    }

    /**
     * 删除分区
     */
    @Log(title = "分区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{areaIds}")
    public AjaxResult remove(@PathVariable Long[] areaIds)
    {
        return toAjax(areaService.deleteAreaByAreaIds(areaIds));
    }
}
