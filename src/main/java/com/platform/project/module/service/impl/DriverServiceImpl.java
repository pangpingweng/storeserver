package com.platform.project.module.service.impl;

import java.util.List;
import com.platform.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.platform.project.module.mapper.DriverMapper;
import com.platform.project.module.domain.Driver;
import com.platform.project.module.service.IDriverService;

/**
 * 司机Service业务层处理
 * 
 */
@Service
public class DriverServiceImpl implements IDriverService 
{
    @Autowired
    private DriverMapper driverMapper;

    /**
     * 查询司机
     * 
     * @param driverId 司机主键
     * @return 司机
     */
    @Override
    public Driver selectDriverByDriverId(Long driverId)
    {
        return driverMapper.selectDriverByDriverId(driverId);
    }

    /**
     * 查询司机列表
     * 
     * @param driver 司机
     * @return 司机
     */
    @Override
    public List<Driver> selectDriverList(Driver driver)
    {
        return driverMapper.selectDriverList(driver);
    }

    /**
     * 新增司机
     * 
     * @param driver 司机
     * @return 结果
     */
    @Override
    public int insertDriver(Driver driver)
    {
        driver.setCreateTime(DateUtils.getNowDate());
        return driverMapper.insertDriver(driver);
    }

    /**
     * 修改司机
     * 
     * @param driver 司机
     * @return 结果
     */
    @Override
    public int updateDriver(Driver driver)
    {
        return driverMapper.updateDriver(driver);
    }

    /**
     * 批量删除司机
     * 
     * @param driverIds 需要删除的司机主键
     * @return 结果
     */
    @Override
    public int deleteDriverByDriverIds(Long[] driverIds)
    {
        return driverMapper.deleteDriverByDriverIds(driverIds);
    }

    /**
     * 删除司机信息
     * 
     * @param driverId 司机主键
     * @return 结果
     */
    @Override
    public int deleteDriverByDriverId(Long driverId)
    {
        return driverMapper.deleteDriverByDriverId(driverId);
    }
}
