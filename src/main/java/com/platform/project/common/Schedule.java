package com.platform.project.common;

import com.platform.common.utils.StringUtils;
import com.platform.project.module.domain.Detail;
import com.platform.project.module.domain.Warn;
import com.platform.project.module.service.IAreaService;
import com.platform.project.module.service.IDetailService;
import com.platform.project.module.service.IStoreService;
import com.platform.project.module.service.impl.WarnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Schedule {
    @Autowired
    private WarnServiceImpl warnService;
    @Autowired
    private IDetailService detailService;
    @Autowired
    private IAreaService areaService;
    @Autowired
    private IStoreService storeService;

    // 每分钟执行一次
    @Scheduled(cron = "0 0/1 * * * ?")
    public void scheduled() {
        Detail detail = new Detail();
        detail.setGoods_status("审核通过");
        detail.setGoods_stocktype("入库");
        detail.setWarn_status("0");
        List<Detail> detailList = detailService.selectDetailList(detail);
        detailList.forEach(data -> {
            if(!StringUtils.isEmpty(data.getGoods_storetime())){
                String startDate = data.getGoods_storetime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    Date storeDate = simpleDateFormat.parse(startDate);
                    if(storeDate.before(new Date())){
                        String storeName = storeService.selectStoreByStoreId(Long.valueOf(data.getGoods_storeid())).getStoreName();
                        String areaName = areaService.selectAreaByAreaId(Long.valueOf(data.getGoods_areaid())).getAreaName();
                        // 时间预警
                        Warn warn = new Warn();
                        warn.setType("2");
                        warn.setAreaName(storeName+"-"+areaName);
                        warn.setAreaId(Long.valueOf(data.getGoods_areaid()));
                        warn.setWarnName("订单编号"+data.getStockId()+"-"+storeName+"-"+areaName+"中"+data.getGoodsName()+"超过最大保存时间");
                        warn.setWarnReason(data.getGoodsName()+"超过最大保存时间");
                        warn.setWarnDesc(data.getGoodsName()+"超过最大保存时间");
                        warnService.insertWarn(warn);

                        data.setWarn_status("1");
                        detailService.updateDetail(data);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }

}
