package com.platform.project.module.service;

import java.util.List;
import com.platform.project.module.domain.Car;

/**
 * 车辆Service接口
 * 
 */
public interface ICarService 
{
    /**
     * 查询车辆
     * 
     * @param carId 车辆主键
     * @return 车辆
     */
    public Car selectCarByCarId(Long carId);

    /**
     * 查询车辆列表
     * 
     * @param car 车辆
     * @return 车辆集合
     */
    public List<Car> selectCarList(Car car);

    /**
     * 新增车辆
     * 
     * @param car 车辆
     * @return 结果
     */
    public int insertCar(Car car);

    /**
     * 修改车辆
     * 
     * @param car 车辆
     * @return 结果
     */
    public int updateCar(Car car);

    /**
     * 批量删除车辆
     * 
     * @param carIds 需要删除的车辆主键集合
     * @return 结果
     */
    public int deleteCarByCarIds(Long[] carIds);

    /**
     * 删除车辆信息
     * 
     * @param carId 车辆主键
     * @return 结果
     */
    public int deleteCarByCarId(Long carId);
}
