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
import com.platform.project.module.domain.Car;
import com.platform.project.module.service.ICarService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 车辆Controller
 * 
 */
@RestController
@RequestMapping("/module/car")
public class CarController extends BaseController
{
    @Autowired
    private ICarService carService;

    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Car car)
    {
        List<Car> list = carService.selectCarList(car);
        return AjaxResult.success(list);
    }


    /**
     * 查询车辆列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Car car)
    {
        startPage();
        List<Car> list = carService.selectCarList(car);
        return getDataTable(list);
    }

    /**
     * 导出车辆列表
     */
    @Log(title = "车辆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Car car)
    {
        List<Car> list = carService.selectCarList(car);
        ExcelUtil<Car> util = new ExcelUtil<Car>(Car.class);
        util.exportExcel(response, list, "车辆数据");
    }

    /**
     * 获取车辆详细信息
     */
    @GetMapping(value = "/{carId}")
    public AjaxResult getInfo(@PathVariable("carId") Long carId)
    {
        return AjaxResult.success(carService.selectCarByCarId(carId));
    }

    /**
     * 新增车辆
     */
    @Log(title = "车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Car car)
    {
        return toAjax(carService.insertCar(car));
    }

    /**
     * 修改车辆
     */
    @Log(title = "车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Car car)
    {
        return toAjax(carService.updateCar(car));
    }

    /**
     * 删除车辆
     */
    @Log(title = "车辆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carIds}")
    public AjaxResult remove(@PathVariable Long[] carIds)
    {
        return toAjax(carService.deleteCarByCarIds(carIds));
    }
}
