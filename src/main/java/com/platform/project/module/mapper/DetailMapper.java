package com.platform.project.module.mapper;

import java.util.List;
import com.platform.project.module.domain.Detail;

/**
 * 出入库明细Mapper接口
 * 
 */
public interface DetailMapper 
{
    /**
     * 查询出入库明细
     * 
     * @param detailId 出入库明细主键
     * @return 出入库明细
     */
    public Detail selectDetailByDetailId(Long detailId);

    /**
     * 查询出入库明细列表
     * 
     * @param detail 出入库明细
     * @return 出入库明细集合
     */
    public List<Detail> selectDetailList(Detail detail);
    public List<Detail> selectByDay(Detail detail);
    public List<Detail> selectByWeek(Detail detail);
    public List<Detail> selectByMonth(Detail detail);
    /**
     * 新增出入库明细
     * 
     * @param detail 出入库明细
     * @return 结果
     */
    public int insertDetail(Detail detail);

    /**
     * 修改出入库明细
     * 
     * @param detail 出入库明细
     * @return 结果
     */
    public int updateDetail(Detail detail);

    /**
     * 删除出入库明细
     * 
     * @param detailId 出入库明细主键
     * @return 结果
     */
    public int deleteDetailByDetailId(Long detailId);

    /**
     * 批量删除出入库明细
     * 
     * @param detailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetailByDetailIds(Long[] detailIds);
}
