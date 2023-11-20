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
import com.platform.project.module.domain.Store;
import com.platform.project.module.service.IStoreService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 仓库Controller
 * 
 */
@RestController
@RequestMapping("/module/store")
public class StoreController extends BaseController
{
    @Autowired
    private IStoreService storeService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Store store)
    {
        List<Store> list = storeService.selectStoreList(store);
        return AjaxResult.success(list);
    }


    /**
     * 查询仓库列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Store store)
    {
        startPage();
        List<Store> list = storeService.selectStoreList(store);
        return getDataTable(list);
    }

    /**
     * 导出仓库列表
     */
    @Log(title = "仓库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Store store)
    {
        List<Store> list = storeService.selectStoreList(store);
        ExcelUtil<Store> util = new ExcelUtil<Store>(Store.class);
        util.exportExcel(response, list, "仓库数据");
    }

    /**
     * 获取仓库详细信息
     */
    @GetMapping(value = "/{storeId}")
    public AjaxResult getInfo(@PathVariable("storeId") Long storeId)
    {
        return AjaxResult.success(storeService.selectStoreByStoreId(storeId));
    }

    /**
     * 新增仓库
     */
    @Log(title = "仓库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Store store)
    {
        return toAjax(storeService.insertStore(store));
    }

    /**
     * 修改仓库
     */
    @Log(title = "仓库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Store store)
    {
        return toAjax(storeService.updateStore(store));
    }

    /**
     * 删除仓库
     */
    @Log(title = "仓库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storeIds}")
    public AjaxResult remove(@PathVariable Long[] storeIds)
    {
        return toAjax(storeService.deleteStoreByStoreIds(storeIds));
    }
}
