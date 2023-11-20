package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 货物类型对象 module_gtype
 *
 */
public class Gtype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 货物类型id */
    private Long gtypeId;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String gtypeName;

    public void setGtypeId(Long gtypeId) 
    {
        this.gtypeId = gtypeId;
    }

    public Long getGtypeId() 
    {
        return gtypeId;
    }
    public void setGtypeName(String gtypeName) 
    {
        this.gtypeName = gtypeName;
    }

    public String getGtypeName() 
    {
        return gtypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gtypeId", getGtypeId())
            .append("gtypeName", getGtypeName())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
