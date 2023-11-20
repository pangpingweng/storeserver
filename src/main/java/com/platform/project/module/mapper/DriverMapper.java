package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Driver;

/**
 * 司机Mapper接口
 * 
 */
public interface DriverMapper 
{
    /**
     * 查询司机
     * 
     * @param driverId 司机主键
     * @return 司机
     */
    public Driver selectDriverByDriverId(Long driverId);

    /**
     * 查询司机列表
     * 
     * @param driver 司机
     * @return 司机集合
     */
    public List<Driver> selectDriverList(Driver driver);

    /**
     * 新增司机
     * 
     * @param driver 司机
     * @return 结果
     */
    public int insertDriver(Driver driver);

    /**
     * 修改司机
     * 
     * @param driver 司机
     * @return 结果
     */
    public int updateDriver(Driver driver);

    /**
     * 删除司机
     * 
     * @param driverId 司机主键
     * @return 结果
     */
    public int deleteDriverByDriverId(Long driverId);

    /**
     * 批量删除司机
     * 
     * @param driverIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDriverByDriverIds(Long[] driverIds);
}
