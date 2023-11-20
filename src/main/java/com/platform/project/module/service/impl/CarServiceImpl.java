package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.CarMapper;
import com.platform.project.module.domain.Car;
import com.platform.project.module.service.ICarService;

/**
 * 车辆Service业务层处理
 * 
 */
@Service
public class CarServiceImpl implements ICarService 
{
    @Autowired
    private CarMapper carMapper;

    /**
     * 查询车辆
     * 
     * @param carId 车辆主键
     * @return 车辆
     */
    @Override
    public Car selectCarByCarId(Long carId)
    {
        return carMapper.selectCarByCarId(carId);
    }

    /**
     * 查询车辆列表
     * 
     * @param car 车辆
     * @return 车辆
     */
    @Override
    public List<Car> selectCarList(Car car)
    {
        return carMapper.selectCarList(car);
    }

    /**
     * 新增车辆
     * 
     * @param car 车辆
     * @return 结果
     */
    @Override
    public int insertCar(Car car)
    {
        //car.setCreateTime(DateUtils.getNowDate());
        return carMapper.insertCar(car);
    }

    /**
     * 修改车辆
     * 
     * @param car 车辆
     * @return 结果
     */
    @Override
    public int updateCar(Car car)
    {
        return carMapper.updateCar(car);
    }

    /**
     * 批量删除车辆
     * 
     * @param carIds 需要删除的车辆主键
     * @return 结果
     */
    @Override
    public int deleteCarByCarIds(Long[] carIds)
    {
        return carMapper.deleteCarByCarIds(carIds);
    }

    /**
     * 删除车辆信息
     * 
     * @param carId 车辆主键
     * @return 结果
     */
    @Override
    public int deleteCarByCarId(Long carId)
    {
        return carMapper.deleteCarByCarId(carId);
    }
}
