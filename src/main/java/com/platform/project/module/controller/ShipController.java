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
import com.platform.project.module.domain.Ship;
import com.platform.project.module.service.IShipService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 运输Controller
 * 
 */
@RestController
@RequestMapping("/module/ship")
public class ShipController extends BaseController
{
    @Autowired
    private IShipService shipService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Ship ship)
    {
        List<Ship> list = shipService.selectShipList(ship);
        return AjaxResult.success(list);
    }


    /**
     * 查询运输列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Ship ship)
    {
        startPage();
        List<Ship> list = shipService.selectShipList(ship);
        return getDataTable(list);
    }

    /**
     * 查询运输列表
     */
    @GetMapping("/listWuliu")
    public TableDataInfo listWuliu(Ship ship)
    {
        startPage();
        List<Ship> list = shipService.selectWuliuList(ship);
        return getDataTable(list);
    }

    /**
     * 导出运输列表
     */
    @Log(title = "运输", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Ship ship)
    {
        List<Ship> list = shipService.selectShipList(ship);
        ExcelUtil<Ship> util = new ExcelUtil<Ship>(Ship.class);
        util.exportExcel(response, list, "运输数据");
    }

    /**
     * 获取运输详细信息
     */
    @GetMapping(value = "/{shipId}")
    public AjaxResult getInfo(@PathVariable("shipId") Long shipId)
    {
        return AjaxResult.success(shipService.selectShipByShipId(shipId));
    }

    /**
     * 新增运输
     */
    @Log(title = "运输", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Ship ship)
    {
        return toAjax(shipService.insertShip(ship));
    }

    /**
     * 修改运输
     */
    @Log(title = "运输", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Ship ship)
    {
        return toAjax(shipService.updateShip(ship));
    }

    /**
     * 删除运输
     */
    @Log(title = "运输", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shipIds}")
    public AjaxResult remove(@PathVariable Long[] shipIds)
    {
        return toAjax(shipService.deleteShipByShipIds(shipIds));
    }
}
