package com.platform.project.module.domain;

import com.platform.framework.web.domain.BaseEntity;
import com.platform.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 供货商对象 module_supplier
 *
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供货商id */
    private Long supplierId;

    /** 供货商名称 */
    @Excel(name = "供货商名称")
    private String supplierName;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 联系人 */
    @Excel(name = "联系人")
    private String person;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String address;

    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPerson(String person) 
    {
        this.person = person;
    }

    public String getPerson() 
    {
        return person;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("supplierName", getSupplierName())
            .append("phone", getPhone())
            .append("person", getPerson())
            .append("address", getAddress())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
