package com.fh.controller;

import com.fh.model.FlightInfo;
import com.fh.model.PlaneTypeInfo;
import com.fh.model.ServerResponse;
import com.fh.service.FiltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName FlightController
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/15
 * @Version V1.0
 **/
@RestController
@RequestMapping("Filt")
public class FlightController {
    @Autowired
    private FiltService filtService;

    @RequestMapping("queryFilteList")
    public Map queryFilteList(){
        Long count=filtService.querycount();
        List<FlightInfo> flightInfoList=filtService.queryFilteList();
        Map map=new HashMap();
        //给容器一个随机id
        map.put("draw", UUID.randomUUID().toString());
        map.put("recordsTotal",count); // 设置总条数
        map.put("recordsFiltered",count); // 设置过滤后的总条数
        map.put("data",flightInfoList);
        return map;

    }

    @RequestMapping("queryPlaneList")
    public ServerResponse queryPlaneList(){
        try {
            List<PlaneTypeInfo> flightInfoList=filtService.queryPlaneList();
            return ServerResponse.success(flightInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }


    }


}
