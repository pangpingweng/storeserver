package com.platform.project.module.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 出入库明细对象 module_detail
 *
 */
public class Detail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出入库明细id */
    private Long detailId;

    /** 出入库 */
    private String stockId;

    /** 货物名称 */
    private Long goodsId;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goodsName;

    /** 货物数量 */
    @Excel(name = "货物数量")
    private Long goodsNum;

    /** 货物类型 */
    @Excel(name = "货物类型")
    private String goodsType;

    @Excel(name = "货物类型")
    private String remark;

    private int goods_typeid;

    private String goods_area;

    private int goods_userid;

    private int goods_areaid;

    private String goods_username;

    private String goods_stocktype;

    private int goods_storeid;

    private String goods_storename;

    private String goods_storetime;

    private String goods_status;

    private String goods_supplier;
    private String warn_status;
    @TableField(exist = false)
    private Long manager_id;

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String goods_status) {
        this.goods_status = goods_status;
    }

    public String getGoods_storetime() {
        return goods_storetime;
    }

    public void setGoods_storetime(String goods_storetime) {
        this.goods_storetime = goods_storetime;
    }

    public int getGoods_storeid() {
        return goods_storeid;
    }

    public void setGoods_storeid(int goods_storeid) {
        this.goods_storeid = goods_storeid;
    }

    public String getGoods_storename() {
        return goods_storename;
    }

    public void setGoods_storename(String goods_storename)
    {
        this.goods_storename = goods_storename;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGoods_stocktype() {
        return goods_stocktype;
    }

    public void setGoods_stocktype(String goods_stocktype) {
        this.goods_stocktype = goods_stocktype;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public int getGoods_typeid() {
        return goods_typeid;
    }

    public void setGoods_typeid(int goods_typeid) {
        this.goods_typeid = goods_typeid;
    }

    public String getGoods_area() {
        return goods_area;
    }

    public void setGoods_area(String goods_area) {
        this.goods_area = goods_area;
    }

    public int getGoods_userid() {
        return goods_userid;
    }

    public void setGoods_userid(int goods_userid) {
        this.goods_userid = goods_userid;
    }

    public int getGoods_areaid() {
        return goods_areaid;
    }

    public void setGoods_areaid(int goods_areaid) {
        this.goods_areaid = goods_areaid;
    }

    public String getGoods_username() {
        return goods_username;
    }

    public void setGoods_username(String goods_username) {
        this.goods_username = goods_username;
    }

    public String getGoods_supplier() {
        return goods_supplier;
    }

    public void setGoods_supplier(String goods_supplier) {
        this.goods_supplier = goods_supplier;
    }

    public String getWarn_status() {
        return warn_status;
    }

    public void setWarn_status(String warn_status) {
        this.warn_status = warn_status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailId", getDetailId())
            .append("stockId", getStockId())
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("goodsNum", getGoodsNum())
            .append("goodsType", getGoodsType())
            .append("remark", getRemark())
            .append("goods_area",getGoods_area())
                .append("goods_typeid",getGoods_typeid())
                .append("goods_userid",getGoods_userid())
                .append("goods_usename",getGoods_username())
                .append("goods_areaid",getGoods_areaid())
                .append("remark",getRemark())
                .append("goods_stocktype",getGoods_stocktype())
                .append("goods_storeid",getGoods_storeid())
                .append("goods_storename",getGoods_storename())
                .append("goods_storetime",getGoods_storetime())
                .append("goods_status",getGoods_status())
                .toString();
    }
}
