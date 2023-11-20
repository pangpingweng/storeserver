package com.platform.project.module.domain;

import com.platform.framework.aspectj.lang.annotation.Excel;
import com.platform.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 货物对象 模板
 *
 */
public class GoodsTem
{
    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goodsName;
    /** 货物类型 */
    @Excel(name = "货物类型")
    private String goodsType;
    /** 货物数量 */
    @Excel(name = "货物数量")
    private Long goodsNum;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }
}
