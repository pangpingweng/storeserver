package com.platform.project.module.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.platform.project.module.domain.Goods;
import com.platform.project.module.domain.Stock;
import com.platform.project.module.service.IGoodsService;
import com.platform.project.module.service.IStockService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.platform.framework.aspectj.lang.annotation.Log;
import com.platform.framework.aspectj.lang.enums.BusinessType;
import com.platform.project.module.domain.Detail;
import com.platform.project.module.service.IDetailService;
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;

/**
 * 出入库明细Controller
 * 
 */
@RestController
@RequestMapping("/module/detail")
public class DetailController extends BaseController
{
    @Autowired
    private IDetailService detailService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IStockService stockService;
    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Detail detail)
    {
        List<Detail> list = detailService.selectDetailList(detail);
        return AjaxResult.success(list);
    }

    @GetMapping("/dayList")
    public AjaxResult dayList(Detail detail)
    {
        List<Detail> list = detailService.selectByDay(detail);
        return AjaxResult.success(list);
    }

    @GetMapping("/weekList")
    public AjaxResult weekList(Detail detail)
    {
        List<Detail> list = detailService.selectByWeek(detail);
        return AjaxResult.success(list);
    }

    @GetMapping("/monthList")
    public AjaxResult monthList(Detail detail)
    {
        List<Detail> list = detailService.selectByMonth(detail);
        System.out.println(list);
        return AjaxResult.success(list);
    }

    /**
     * 查询出入库明细列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Detail detail)
    {
        startPage();

        List<Detail> list = detailService.selectDetailList(detail);
        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 导出出入库明细列表
     */
    @Log(title = "出入库明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Detail detail)
    {
        List<Detail> list = detailService.selectDetailList(detail);
        ExcelUtil<Detail> util = new ExcelUtil<Detail>(Detail.class);
        util.exportExcel(response, list, "出入库明细数据");
    }

    /**
     * 获取出入库明细详细信息
     */
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return AjaxResult.success(detailService.selectDetailByDetailId(detailId));
    }

    /**
     * 新增出入库明细
     */
    @Log(title = "出入库明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Detail detail)
    {
        // 当前出入库信息

        Stock quertStock = new Stock();
        quertStock.setStockName(detail.getStockId());
        Stock stock = stockService.selectStockList(quertStock).get(0);
        // 判断是否存在改货物

        Goods searchGoods = new Goods();
        searchGoods.setGoodsName(detail.getGoodsName());
        searchGoods.setGoodsType(detail.getGoodsType());
        searchGoods.setStoreId((long) detail.getGoods_storeid());
        searchGoods.setGoods_areaid(detail.getGoods_areaid());

        List<Goods> currList = goodsService.selectGoodsList(searchGoods);

//        //如果是新的货物
//        if(CollectionUtils.isEmpty(currList) && stock.getStockType().equals("出库") && detail.getGoods_status().equals("审核通过")){
//            return error("该货物库存不足");
//        }else if(CollectionUtils.isEmpty(currList) && stock.getStockType().equals("入库") ){
//            Goods goods = new Goods();
//            goods.setGoodsType(detail.getGoodsType());
//            goods.setGoodsName(detail.getGoodsName());
//            goods.setGoodsNum(detail.getGoodsNum());
//            goods.setUserId(stock.getUserId());
//            goods.setUserName(stock.getUserName());
//            goods.setStoreId(stock.getStoreId());
//            goods.setStoreName(stock.getStoreName());
//            goodsService.insertGoods(goods);
//        }else if(!CollectionUtils.isEmpty(currList) && stock.getStockType().equals("出库") && detail.getGoods_status().equals("审核通过")){
//            Goods goods = currList.get(0);
//            if(goods.getGoodsNum() < detail.getGoodsNum()){
//                return error("该货物库存不足");
//            }else{
//                goods.setGoodsNum(goods.getGoodsNum()-detail.getGoodsNum());
//              goodsService.updateGoods(goods);
//            }
//        }else if(!CollectionUtils.isEmpty(currList) && stock.getStockType().equals("入库") && detail.getGoods_status().equals("审核通过")){
//            Goods goods = currList.get(0);
//            goods.setGoodsNum(goods.getGoodsNum()+detail.getGoodsNum());
//            goodsService.updateGoods(goods);
//        }
        return toAjax(detailService.insertDetail(detail));
    }

    /**
     * 修改出入库明细
     */
    @Log(title = "出入库明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Detail detail)
    {


        System.out.println(detail);
        return toAjax(detailService.updateDetail(detail));
    }

    /**
     * 删除出入库明细
     */
    @Log(title = "出入库明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(detailService.deleteDetailByDetailIds(detailIds));

    }
}
