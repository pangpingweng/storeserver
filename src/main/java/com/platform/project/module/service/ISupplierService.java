package com.platform.project.module.service;

import java.util.List;
import com.platform.project.module.domain.Supplier;

/**
 * 供货商Service接口
 * 
 */
public interface ISupplierService 
{
    /**
     * 查询供货商
     * 
     * @param supplierId 供货商主键
     * @return 供货商
     */
    public Supplier selectSupplierBySupplierId(Long supplierId);

    /**
     * 查询供货商列表
     * 
     * @param supplier 供货商
     * @return 供货商集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供货商
     * 
     * @param supplier 供货商
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改供货商
     * 
     * @param supplier 供货商
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 批量删除供货商
     * 
     * @param supplierIds 需要删除的供货商主键集合
     * @return 结果
     */
    public int deleteSupplierBySupplierIds(Long[] supplierIds);

    /**
     * 删除供货商信息
     * 
     * @param supplierId 供货商主键
     * @return 结果
     */
    public int deleteSupplierBySupplierId(Long supplierId);
}
