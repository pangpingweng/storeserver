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
import com.platform.project.module.domain.Gtype;
import com.platform.project.module.service.IGtypeService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 货物类型Controller
 * 
 */
@RestController
@RequestMapping("/module/gtype")
public class GtypeController extends BaseController
{
    @Autowired
    private IGtypeService gtypeService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Gtype gtype)
    {
        List<Gtype> list = gtypeService.selectGtypeList(gtype);
        return AjaxResult.success(list);
    }


    /**
     * 查询货物类型列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Gtype gtype)
    {
        startPage();
        List<Gtype> list = gtypeService.selectGtypeList(gtype);
        return getDataTable(list);
    }

    /**
     * 导出货物类型列表
     */
    @Log(title = "货物类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Gtype gtype)
    {
        List<Gtype> list = gtypeService.selectGtypeList(gtype);
        ExcelUtil<Gtype> util = new ExcelUtil<Gtype>(Gtype.class);
        util.exportExcel(response, list, "货物类型数据");
    }

    /**
     * 获取货物类型详细信息
     */
    @GetMapping(value = "/{gtypeId}")
    public AjaxResult getInfo(@PathVariable("gtypeId") Long gtypeId)
    {
        return AjaxResult.success(gtypeService.selectGtypeByGtypeId(gtypeId));
    }

    /**
     * 新增货物类型
     */
    @Log(title = "货物类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Gtype gtype)
    {
        return toAjax(gtypeService.insertGtype(gtype));
    }

    /**
     * 修改货物类型
     */
    @Log(title = "货物类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Gtype gtype)
    {
        return toAjax(gtypeService.updateGtype(gtype));
    }

    /**
     * 删除货物类型
     */
    @Log(title = "货物类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gtypeIds}")
    public AjaxResult remove(@PathVariable Long[] gtypeIds)
    {
        return toAjax(gtypeService.deleteGtypeByGtypeIds(gtypeIds));
    }
}
