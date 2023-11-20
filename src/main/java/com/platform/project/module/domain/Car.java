package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 车辆对象 module_car
 *
 */
public class Car extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆id */
    private Long carId;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String carName;

    /** 检查时间 */
    @Excel(name = "检查时间")
    private String buyYear;

    /** 检查时间 */
//    @Excel(name = "检查时间")
//    private String createTime;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carPlate;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String car_type;

    /** 车辆重量 */
    @Excel(name = "车辆重量")
    private String car_weight;

    /** 车辆状态 */
    @Excel(name = "车辆状态")
    private String car_status;

    public void setCarId(Long carId)
    {
        this.carId = carId;
    }

    public Long getCarId() 
    {
        return carId;
    }
    public void setCarName(String carName) 
    {
        this.carName = carName;
    }

    public String getCarName() 
    {
        return carName;
    }
    public void setBuyYear(String buyYear) 
    {
        this.buyYear = buyYear;
    }

    public String getBuyYear() 
    {
        return buyYear;
    }
    public void setCarPlate(String carPlate) 
    {
        this.carPlate = carPlate;
    }

    public String getCarPlate() 
    {
        return carPlate;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_weight() {
        return car_weight;
    }

    public void setCar_weight(String car_weight) {
        this.car_weight = car_weight;
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("carId", getCarId())
            .append("carName", getCarName())
            .append("buyYear", getBuyYear())
            .append("carPlate", getCarPlate())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("car_type",getCar_type())
            .append("car_weight",getCar_weight())
            .append("car_status",getCar_status())
            .toString();
    }
}
