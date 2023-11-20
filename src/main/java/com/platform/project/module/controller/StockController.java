package com.platform.project.module.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.platform.project.module.domain.*;
import com.platform.project.module.service.*;
import com.platform.project.system.domain.SysUser;
import com.platform.project.system.service.ISysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.platform.framework.web.controller.BaseController;
import com.platform.framework.web.domain.AjaxResult;
import com.platform.common.utils.poi.ExcelUtil;
import com.platform.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 出入库Controller
 * 
 */
@RestController
@RequestMapping("/module/stock")
public class StockController extends BaseController
{
    @Autowired
    private IStockService stockService;
    @Autowired
    private IShipService shipService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IDetailService detailService;
    @Autowired
    private ISysUserService sysUserService;
    /**
     * 查询所有数据列表
     */
    @GetMapping("/allList")
    public AjaxResult allList(Stock stock)
    {
        List<Stock> list = stockService.selectStockList(stock);
        return AjaxResult.success(list);
    }


    /**
     * 查询出入库列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Stock stock)
    {
        startPage();
        List<Stock> list = stockService.selectStockList(stock);
        return getDataTable(list);
    }

    /**
     * 导出出入库列表
     */
    @Log(title = "出入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Stock stock)
    {
        List<Stock> list = stockService.selectStockList(stock);
        ExcelUtil<Stock> util = new ExcelUtil<Stock>(Stock.class);
        util.exportExcel(response, list, "出入库数据");
    }

    /**
     * 获取出入库详细信息
     */
    @GetMapping(value = "/{stockId}")
    public AjaxResult getInfo(@PathVariable("stockId") Long stockId)
    {
        return AjaxResult.success(stockService.selectStockByStockId(stockId));
    }

    /**
     * 新增出入库
     */
    @Log(title = "出入库", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional
    public AjaxResult add(@RequestBody Stock stock) throws Exception {

        //boolean flag = false;
        if(CollectionUtils.isEmpty(stock.getGoodsList())){
            return error("货物清单不能为空");
        }

        if(stock.getStockType().equals("入库")){
            stock.setStockName("RK"+System.currentTimeMillis());
        }else if(stock.getStockType().equals("出库")){
            stock.setStockName("CK"+System.currentTimeMillis());
        }

//        if(stock.getStockStatus().equals("审核通过"))
//            flag=true;

        //这个for循环目的是修改detail和goods的代码
        for(int i=0;i<stock.getGoodsList().size();i++){
            //这里在循环、遍历，遍历这个订单下所有的货物列表
            GoodsTem detail = stock.getGoodsList().get(i);
            //判断本次输入的货物，是否是已存在的名字、类别、ID
            //如果不存在该种货物，并且StockType的值为“出库”
//            if(CollectionUtils.isEmpty(currList) && stock.getStockType().equals("出库")){
//                return error("该货物库存不足");
//                //如果不存在该种货物（名、类型、经销商/供货商相同）并且StockType的值为“入库”，那么执行入库操作
//                //对入库表进行修改
//            }else if(CollectionUtils.isEmpty(currList) && stock.getStockType().equals("入库")){
//                //将该detail的值放在good对象里面，然后执行insert到库存表里面
//                //这里是存放新货物（也就是存放在不同仓库、不同）
//                Goods goods = new Goods();
//                goods.setGoodsType(detail.getGoodsType());
//                goods.setGoodsName(detail.getGoodsName());
//                goods.setGoodsNum(detail.getGoodsNum());
//                goods.setUserId(stock.getUserId());
//                goods.setUserName(stock.getUserName());
//                goods.setStoreId(stock.getStoreId());
//                goods.setStoreName(stock.getStoreName());
//                goodsService.insertGoods(goods);
//            //如果库存里面已经存在了该种货物，并且StockType为出库时
//            }else if(!CollectionUtils.isEmpty(currList) && stock.getStockType().equals("出库")){
//                //创建一个goods对象，这个对象=搜索到的库存goods对象
//                Goods goods = currList.get(0);
//                //如果goods的库存小于detail的库存
//                if(goods.getGoodsNum() < detail.getGoodsNum()){
//                    return error("该货物库存不足");
//                }else{
//            //否则，执行出库操作（这里需要进行修改，修改为，stock_status=审核通过时，执行该操作，当修改时，也应该进行这个流程）
//            //该goods对象的num属性，执行减法操作
//                    goods.setGoodsNum(goods.getGoodsNum()-detail.getGoodsNum());
//                    goodsService.updateGoods(goods);
//                }
//            }
//            //如果库存里面已经存在了该种货物，并且StockType为入库时
//            else if(!CollectionUtils.isEmpty(currList) && stock.getStockType().equals("入库")){
//                //创建一个goods对象，这个对象=搜索到的库存goods对象
//                Goods goods = currList.get(0);
//                //如果库存里面已经存在了该种货物，并且StockType为出库时，执行入库操作，，执行加法
//                goods.setGoodsNum(goods.getGoodsNum()+detail.getGoodsNum());
//                //！！！！！！这里似乎有些问题，当执行加法操作后，会对该货物执行修改基本信息操作
//                //例如评论、类型等的操作，我认为这个操作应该放在库存盘点里面，如果库存盘点页面和货物信息页面要分开的话，
//                //那么应该放在货物信息页面里
//                goodsService.updateGoods(goods);
//            }

            //！！！！！！！！！以下代码执行增加detail信息，这里还需要进行修改，主要修改的是多set几个信息
            Detail saveData = new Detail();
            saveData.setGoodsNum(detail.getGoodsNum());
            saveData.setGoodsType(detail.getGoodsType());
            saveData.setGoodsName(detail.getGoodsName());
            saveData.setGoods_stocktype(stock.getStockType());
            saveData.setCreateTime(stock.getCreateTime());
            int storeid = Integer.parseInt(stock.getStoreId().toString());;
            saveData.setGoods_storeid(storeid);
            int userId = Integer.parseInt(stock.getUserId().toString());;
            saveData.setGoods_userid(userId);
            saveData.setGoods_username(stock.getUserName());
            saveData.setGoods_supplier(stock.getUserName());
            saveData.setGoods_status("待审核");
            saveData.setStockId(stock.getStockName());
            saveData.setRemark(stock.getStockType());
            detailService.insertDetail(saveData);
        }


        //以下代码时执行增加stock信息的，这里应该不需要进行修改
        stockService.insertStock(stock);
//        if(stock.getStockType().equals("出库") &&  stock.getStockStatus()!=null && stock.getStockStatus().equals("审核通过")){
//            SysUser sysUser = sysUserService.selectUserById(stock.getUserId());
//            // 新增运输订单
//            Ship ship = new Ship();
//            ship.setStockId(stock.getStockId());
//            ship.setStockName(stock.getStockName());
//            ship.setRemark(stock.getGtype()+","+stock.getRemark());
//            ship.setDealer(sysUser.getNickName());
//            ship.setDealeraddr(sysUser.getAdditional4());
//            ship.setDealerphone(sysUser.getPhonenumber());
//            shipService.insertShip(ship);
//        }
        return toAjax(1);
    }

    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<GoodsTem> util = new ExcelUtil<GoodsTem>(GoodsTem.class);
        List<GoodsTem> goodsList = util.importExcel(file.getInputStream());
        return AjaxResult.success(goodsList);
    }

    /**
     * 修改出入库
     */
    @Log(title = "出入库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stock stock)
    {
        //new一个Stock对象，该对象包含的信息是原有的Stock信息
        Stock oldStock = stockService.selectStockByStockId(stock.getStockId());
        boolean flag =false;


        // 获取改订单详情列表
        Detail queryDetail = new Detail();
        queryDetail.setStockId(stock.getStockName());
        List<Detail> detailList = detailService.selectDetailList(queryDetail);
        if(stock.getStockStatus().equals("审核通过")) {

            //这个for循环目的是修改detail和goods的代码
            for (int i = 0; i < detailList.size(); i++) {
                //这里在循环、遍历，遍历这个订单下所有的货物列表
                Detail detail = detailList.get(i);
                //先取出第X个细节
                // 判断是否存在该货物，创造一个goods对象，为其赋予属性
                Goods searchGoods = new Goods();
                //赋予了货物名、类型、经销商/供货商
                searchGoods.setGoodsName(detail.getGoodsName());
                searchGoods.setGoodsType(detail.getGoodsType());
                //判断本次输入的货物，是否是已存在的名字、类别、ID
                List<Goods> currList = goodsService.selectGoodsList(searchGoods);
                //如果不存在该种货物，并且StockType的值为“出库”
                if (CollectionUtils.isEmpty(currList) && stock.getStockType().equals("出库")) {
                    return error("该货物库存不足");
                    //如果不存在该种货物（名、类型、经销商/供货商相同）并且StockType的值为“入库”，那么执行入库操作
                    //对入库表进行修改
                } else if (CollectionUtils.isEmpty(currList) && stock.getStockType().equals("入库")) {
                    //将该detail的值放在good对象里面，然后执行insert到库存表里面
                    //这里是存放新货物（也就是存放在不同仓库、不同）
                    Goods goods = new Goods();
                    goods.setGoodsType(detail.getGoodsType());
                    goods.setGoodsName(detail.getGoodsName());
                    goods.setGoodsNum(detail.getGoodsNum());
                    goods.setUserId(stock.getUserId());
                    goods.setUserName(stock.getUserName());
                    goods.setStoreId(stock.getStoreId());
                    goods.setStoreName(stock.getStoreName());
                    goods.setGoods_areaid(detail.getGoods_areaid());
                    goods.setGoods_typeid(detail.getGoods_typeid());
                    goodsService.insertGoods(goods);
                    //如果库存里面已经存在了该种货物，并且StockType为出库时
                } else if (!CollectionUtils.isEmpty(currList) && stock.getStockType().equals("出库")) {
                    //创建一个goods对象，这个对象=搜索到的库存goods对象
                    Goods goods = currList.get(0);
                    //如果goods的库存小于detail的库存
                    if (goods.getGoodsNum() < detail.getGoodsNum()) {
                        return error("该货物库存不足");
                    } else {
                        //否则，执行出库操作（这里需要进行修改，修改为，stock_status=审核通过时，执行该操作，当修改时，也应该进行这个流程）
                        //该goods对象的num属性，执行减法操作
                        goods.setGoodsNum(goods.getGoodsNum() - detail.getGoodsNum());
                        goodsService.updateGoods(goods);
                    }
                }
                //如果库存里面已经存在了该种货物，并且StockType为入库时
                else if (!CollectionUtils.isEmpty(currList) && stock.getStockType().equals("入库")) {
                    //创建一个goods对象，这个对象=搜索到的库存goods对象
                    Goods goods = currList.get(0);
                    //如果库存里面已经存在了该种货物，并且StockType为出库时，执行入库操作，，执行加法
                    goods.setGoodsNum(goods.getGoodsNum() + detail.getGoodsNum());
                    //！！！！！！这里似乎有些问题，当执行加法操作后，会对该货物执行修改基本信息操作
                    //例如评论、类型等的操作，我认为这个操作应该放在库存盘点里面，如果库存盘点页面和货物信息页面要分开的话，
                    //那么应该放在货物信息页面里
                    goodsService.updateGoods(goods);
                }

            }
        }
        //如果Stock操作时出库，stock_status值为审核通过，并且原有的stock_status值为待审核
        if(stock.getStockType().equals("出库") && stock.getStockStatus().equals("审核通过")
                && oldStock.getStockStatus().equals("待审核")){
            SysUser sysUser = sysUserService.selectUserById(stock.getUserId());
            // 修改运输订单，执行insert操作，如果出库从待审核=>审核通过，那么就会insert一个新的stock
            Ship ship = new Ship();
            ship.setStockId(stock.getStockId());
            ship.setStockName(stock.getStockName());
            ship.setRemark(stock.getGtype()+","+stock.getRemark());
            ship.setDealerid(sysUser.getUserId());
            ship.setDealer(sysUser.getNickName());
            ship.setDealeraddr(sysUser.getAdditional4());
            ship.setDealerphone(sysUser.getPhonenumber());
            shipService.insertShip(ship);
        }

        detailList.forEach(detail -> {
            detail.setGoods_status(stock.getStockStatus());
            detailService.updateDetail(detail);
        });

        return toAjax(stockService.updateStock(stock));
    }

    /**
     * 删除出入库
     */
    @Log(title = "出入库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stockIds}")
    public AjaxResult remove(@PathVariable Long[] stockIds)
    {
        //！！！！！执行删除时，只会删除该条记录，需要进行更改的是，当执行删除时，会把detail相关的记录也给删除
        return toAjax(stockService.deleteStockByStockIds(stockIds));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<GoodsTem> util = new ExcelUtil<GoodsTem>(GoodsTem.class);
        util.importTemplateExcel(response, "货物清单");
    }
}
