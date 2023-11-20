package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Supplier;

/**
 * 供货商Mapper接口
 * 
 */
public interface SupplierMapper 
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
     * 删除供货商
     * 
     * @param supplierId 供货商主键
     * @return 结果
     */
    public int deleteSupplierBySupplierId(Long supplierId);

    /**
     * 批量删除供货商
     * 
     * @param supplierIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSupplierBySupplierIds(Long[] supplierIds);
}
