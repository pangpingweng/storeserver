package com.platform.project.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 货物对象 module_goods
 *
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 货物id */
    private Long goodsId;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goodsName;

    /** 经销商 */
    private Long userId;

    /** 经销商 */
    @Excel(name = "经销商")
    private String userName;

    /** 存放仓库 */
    private Long storeId;

    /** 存放仓库 */
    @Excel(name = "存放仓库")
    private String storeName;

    /** 货物类型 */
    @Excel(name = "货物类型")
    private String goodsType;

    public void setGoodsType(String goodsType)
    {
        this.goodsType = goodsType;
    }

    public String getGoodsType()
    {
        return goodsType;
    }

    /** 存放仓库 */
    @Excel(name = "类型id")
    private int goods_typeid;

    /** 存放仓库 */
    @Excel(name = "存放分区")
    private String goods_area;

    /** 货物数量 */
    @Excel(name = "货物数量")
    private Long goodsNum;

    private String supplierName;
    private String picture;
    private String price;
    private String producer;
    /** 货物数量 */
    @Excel(name = "分区id")
    private int goods_areaid;

    @TableField(exist = false)
    private Long manager_id;

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public int getGoods_typeid() {
        return goods_typeid;
    }

    public void setGoods_typeid(int goods_typeid) {
        this.goods_typeid = goods_typeid;
    }



    public int getGoods_areaid() {
        return goods_areaid;
    }

    public void setGoods_areaid(int goods_areaid) {
        this.goods_areaid = goods_areaid;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getGoods_area() {
        return goods_area;
    }

    public void setGoods_area(String goods_area) {
        this.goods_area = goods_area;
    }

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
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
    public void setGoodsNum(Long goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public Long getGoodsNum()
    {
        return goodsNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("storeId", getStoreId())
            .append("storeName", getStoreName())
            .append("goodsNum", getGoodsNum())
            .append("goodsType", getGoodsType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
                .append("supplierName",getSupplierName())
                .append("goods_areaid",getGoods_areaid())
                .append("goods_area",getGoods_area())
                .append("goods_typeid",goods_typeid)
            .toString();
    }
}
