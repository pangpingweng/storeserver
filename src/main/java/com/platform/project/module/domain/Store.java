package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 仓库对象 module_store
 *
 */
public class Store extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库id */
    private Long storeId;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String storeName;

    /** 仓库大小 */
    @Excel(name = "仓库大小")
    private String storeSize;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String storeAddress;

    /** 仓库管理员 */
    @Excel(name = "仓库地址")
    private String store_manager;

    /** 最后检查时间 */
    @Excel(name = "仓库地址")
    private String store_check;

    /** 仓管员id */
    private Long manager_id;


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
    public void setStoreSize(String storeSize) 
    {
        this.storeSize = storeSize;
    }

    public String getStoreSize() 
    {
        return storeSize;
    }
    public void setStoreAddress(String storeAddress) 
    {
        this.storeAddress = storeAddress;
    }

    public String getStoreAddress() 
    {
        return storeAddress;
    }

    public String getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(String store_manager) {
        this.store_manager = store_manager;
    }

    public String getStore_check() {
        return store_check;
    }

    public void setStore_check(String store_check) {
        this.store_check = store_check;
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
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("storeSize", getStoreSize())
            .append("storeAddress", getStoreAddress())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
                .append("store_check",getStore_check())
                .append("store_manager",getStore_manager())
            .toString();
    }
}
