package com.platform.project.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import com.platform.project.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

/**
 * 出入库对象 module_stock
 *
 */
public class Stock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出入库id */
    private Long stockId;

    /** 出入库编号 */
    @Excel(name = "货物名称")
    private String stockName;

    /** 经销商 */
    private Long userId;

    /** 经销商 */
    @Excel(name = "经销商")
    private String userName;

    /** 所属仓库 */
    private Long storeId;

    /** 所属仓库 */
    @Excel(name = "所属仓库")
    private String storeName;

    @Excel(name = "所属分区")
    private String areaname;

    @Excel(name = "货物类型")
    private String gtype;

    /** 出入库状态 */
    @Excel(name = "出入库状态")
    private String stockStatus;

    /** 出入库类型 */
    @Excel(name = "出入库类型")
    private String stockType;

    private String stockSupplier;

    private SysUser sysUser;

    private Supplier supplier;

    @TableField(exist = false)
    private Long manager_id;

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    private List<GoodsTem> goodsList;

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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
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
    public void setStockStatus(String stockStatus) 
    {
        this.stockStatus = stockStatus;
    }

    public String getStockStatus() 
    {
        return stockStatus;
    }
    public void setStockType(String stockType) 
    {
        this.stockType = stockType;
    }

    public String getStockType() 
    {
        return stockType;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public List<GoodsTem> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsTem> goodsList) {
        this.goodsList = goodsList;
    }

    public String getStockSupplier() {
        return stockSupplier;
    }

    public void setStockSupplier(String stockSupplier) {
        this.stockSupplier = stockSupplier;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockId", getStockId())
            .append("stockName", getStockName())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("stockStatus", getStockStatus())
            .append("stockType", getStockType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
