package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 运输对象 module_ship
 *
 */
public class Ship extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运输id */
    private Long shipId;

    /** 司机名称 */
    private Long driverId;

    /** 司机名称 */
    @Excel(name = "司机名称")
    private String driverName;

    /** 车辆名称 */
    private Long carId;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String carName;

    /** 出库id */
    private Long stockId;

    /** 出库编号 */
    @Excel(name = "出库编号")
    private String stockName;

    /** 预期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueTime;

    /** 运输状态 */
    @Excel(name = "运输状态")
    private String shipStatus;

    private String dealer;
    private String dealeraddr;
    private String dealerphone;
    private String driverphone;
    private Long dealerid;
    public void setShipId(Long shipId) 
    {
        this.shipId = shipId;
    }

    public Long getShipId() 
    {
        return shipId;
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
    public void setStockId(Long stockId) 
    {
        this.stockId = stockId;
    }

    public Long getStockId() 
    {
        return stockId;
    }
    public void setStockName(String stockName) 
    {
        this.stockName = stockName;
    }

    public String getStockName() 
    {
        return stockName;
    }
    public void setDueTime(Date dueTime) 
    {
        this.dueTime = dueTime;
    }

    public Date getDueTime() 
    {
        return dueTime;
    }
    public void setShipStatus(String shipStatus) 
    {
        this.shipStatus = shipStatus;
    }

    public String getShipStatus() 
    {
        return shipStatus;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getDealeraddr() {
        return dealeraddr;
    }

    public void setDealeraddr(String dealeraddr) {
        this.dealeraddr = dealeraddr;
    }

    public String getDealerphone() {
        return dealerphone;
    }

    public void setDealerphone(String dealerphone) {
        this.dealerphone = dealerphone;
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    public Long getDealerid() {
        return dealerid;
    }

    public void setDealerid(Long dealerid) {
        this.dealerid = dealerid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shipId", getShipId())
            .append("driverId", getDriverId())
            .append("driverName", getDriverName())
            .append("carId", getCarId())
            .append("carName", getCarName())
            .append("stockId", getStockId())
            .append("stockName", getStockName())
            .append("dueTime", getDueTime())
            .append("shipStatus", getShipStatus())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
