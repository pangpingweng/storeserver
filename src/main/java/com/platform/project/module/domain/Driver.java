package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 司机对象 module_driver
 *
 */
public class Driver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 司机id */
    private Long driverId;

    /** 司机姓名 */
    @Excel(name = "司机姓名")
    private String driverName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String address;

    /** 驾龄 */
    @Excel(name = "驾龄")
    private String driverExp;

    /** 驾照类型 */
    @Excel(name = "驾照类型")
    private String license_type;

    /** 工作状态 */
    @Excel(name = "工作状态")
    private String work_type;

    /** 司机编号 */
    @Excel(name = "司机编号")
    private String driver_ids;

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getDriver_ids() {
        return driver_ids;
    }

    public void setDriver_ids(String driver_ids) {
        this.driver_ids = driver_ids;
    }

    public void setDriverId(Long driverId)
    {
        this.driverId = driverId;
    }

    public Long getDriverId() 
    {
        return driverId;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setDriverExp(String driverExp) 
    {
        this.driverExp = driverExp;
    }

    public String getDriverExp() 
    {
        return driverExp;
    }

    public String getLicense_type() {
        return license_type;
    }

    public void setLicense_type(String license_type) {
        this.license_type = license_type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("driverId", getDriverId())
            .append("driverName", getDriverName())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("driverExp", getDriverExp())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("license_type",getLicense_type())
            .append("work_type",getWork_type())
            .append("driver_ids",getDriver_ids())
            .toString();
    }
}
