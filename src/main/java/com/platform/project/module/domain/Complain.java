package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 投诉对象 module_complain
 *
 */
public class Complain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 投诉id */
    private Long complainId;

    /** 运输id */
    @Excel(name = "运输id")
    private String shipId;

    /** 经销商 */
    private Long userId;

    /** 经销商 */
    @Excel(name = "经销商")
    private String userName;

    /** 投诉内容 */
    @Excel(name = "投诉内容")
    private String complainText;

    /** 投诉反馈 */
    @Excel(name = "投诉反馈")
    private String complainReply;

    /** 投诉状态 */
    @Excel(name = "投诉状态")
    private String complainStatus;

    public void setComplainId(Long complainId) 
    {
        this.complainId = complainId;
    }

    public Long getComplainId() 
    {
        return complainId;
    }
    public void setShipId(String shipId)
    {
        this.shipId = shipId;
    }

    public String getShipId()
    {
        return shipId;
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
    public void setComplainText(String complainText) 
    {
        this.complainText = complainText;
    }

    public String getComplainText() 
    {
        return complainText;
    }
    public void setComplainReply(String complainReply) 
    {
        this.complainReply = complainReply;
    }

    public String getComplainReply() 
    {
        return complainReply;
    }
    public void setComplainStatus(String complainStatus) 
    {
        this.complainStatus = complainStatus;
    }

    public String getComplainStatus() 
    {
        return complainStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("complainId", getComplainId())
            .append("shipId", getShipId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("complainText", getComplainText())
            .append("complainReply", getComplainReply())
            .append("complainStatus", getComplainStatus())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
