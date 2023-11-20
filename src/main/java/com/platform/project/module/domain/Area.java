package com.platform.project.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 分区对象 module_area
 *
 */
public class Area extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分区id */
    private Long areaId;

    /** 仓库id */
    private Long storeId;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String storeName;

    /** 分区名称 */
    @Excel(name = "分区名称")
    private String areaName;

    /** 分区面积 */
    @Excel(name = "分区面积")
    private String areaSize;

    /** 分区温度 */
    @Excel(name = "分区温度")
    private String areaTemp;

    /** 分区湿度 */
    @Excel(name = "分区湿度")
    private String areaHumidity;

    /** 预警温度 */
    @Excel(name = "预警温度")
    private String warnTemp;

    /** 预警湿度 */
    @Excel(name = "预警湿度")
    private String warnHumidity;

    /** 预警湿度 */
    @Excel(name = "预警湿度")
    private String store_status;

    /** 预警湿度 */
    @Excel(name = "预警湿度")
    private String store_address;

    /** 预警湿度 */
    @Excel(name = "预警湿度")
    private String area_downtemp;

    /** 预警湿度 */
    @Excel(name = "预警湿度")
    private String area_downhumidity;

    @TableField(exist = false)
    private Long manager_id;

    public String getArea_downtemp() {
        return area_downtemp;
    }

    public void setArea_downtemp(String area_downtemp) {
        this.area_downtemp = area_downtemp;
    }

    public String getArea_downhumidity() {
        return area_downhumidity;
    }

    public void setArea_downhumidity(String area_downhumidity) {
        this.area_downhumidity = area_downhumidity;
    }

    public String getStore_status() {
        return store_status;
    }

    public void setStore_status(String store_status) {
        this.store_status = store_status;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public void setAreaId(Long areaId)
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setStoreId(Long storeId) 
    {
        this.storeId = storeId;
    }

    public Long getStoreId() 
    {
        return storeId;
    }
    public void setStoreName(String storeName) 
    {
        this.storeName = storeName;
    }

    public String getStoreName() 
    {
        return storeName;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setAreaSize(String areaSize) 
    {
        this.areaSize = areaSize;
    }

    public String getAreaSize() 
    {
        return areaSize;
    }
    public void setAreaTemp(String areaTemp) 
    {
        this.areaTemp = areaTemp;
    }

    public String getAreaTemp() 
    {
        return areaTemp;
    }
    public void setAreaHumidity(String areaHumidity) 
    {
        this.areaHumidity = areaHumidity;
    }

    public String getAreaHumidity() 
    {
        return areaHumidity;
    }
    public void setWarnTemp(String warnTemp) 
    {
        this.warnTemp = warnTemp;
    }

    public String getWarnTemp() 
    {
        return warnTemp;
    }
    public void setWarnHumidity(String warnHumidity) 
    {
        this.warnHumidity = warnHumidity;
    }

    public String getWarnHumidity() 
    {
        return warnHumidity;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areaId", getAreaId())
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("areaName", getAreaName())
            .append("areaSize", getAreaSize())
            .append("areaTemp", getAreaTemp())
            .append("areaHumidity", getAreaHumidity())
            .append("warnTemp", getWarnTemp())
            .append("warnHumidity", getWarnHumidity())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .append("store_status",getStore_status())
            .append("store_address",getStore_address())
            .append("area_downtemp",getArea_downtemp())
            .append("area_downhumidity",getArea_downhumidity())
            .toString();
    }
}
