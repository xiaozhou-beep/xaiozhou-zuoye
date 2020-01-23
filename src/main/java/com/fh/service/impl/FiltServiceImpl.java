package com.fh.service.impl;

import com.fh.mapper.FiltMapper;
import com.fh.model.FlightInfo;
import com.fh.model.PlaneTypeInfo;
import com.fh.service.FiltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FiltServiceImpl
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/15
 * @Version V1.0
 **/
@Service
public class FiltServiceImpl implements FiltService {
    @Autowired
    private FiltMapper filtMapper;
    @Override
    public List<FlightInfo> queryFilteList() {
        List<FlightInfo> list=new ArrayList<>();
        //查询航班姓名
        List<FlightInfo> flightInfoList=filtMapper.queryFiltAndPlane();


        for (FlightInfo flightInfo : flightInfoList) {
            String str="";
            if(flightInfo.getType()==1){
                str+="大型";
            }
            if(flightInfo.getType()==2){
                str+="中型";
            }
            if(flightInfo.getType()==3){
                str+="小型";
            }
            //航班姓名
            flightInfo.setName(flightInfo.getName()+flightInfo.getpName()+"("+str+")");
            list.add(flightInfo);
        }


        for (FlightInfo flightInfo1 : list) {
        //地区与航班的起飞地点
        List<FlightInfo> flightInfoList1=filtMapper.queryFiltAndArea(flightInfo1.getStartTerminalId());
        for (FlightInfo flightInfo : flightInfoList1) {  //7200000
            String str1="";
            //时间描述
            String substring = flightInfo.getStartTime().toString().substring(flightInfo.getStartTime().toString().length() - 6, flightInfo.getStartTime().toString().length() - 1);
                 /*if(flightInfo.getaType()==1){
                     str1+=flightInfo.getaName();
                 }*/
            if(flightInfo.getaType()==2){
                str1+=flightInfo.getaName();
            }
            if(flightInfo.getaType()==3){
                str1+=flightInfo.getaName();
            }
            if(flightInfo.getStartTime().getTime()- (new Date().getTime())>7200000){
                //设置二段
                flightInfo1.setStartTimes(substring+str1);
            }else{
                flightInfo1.setStartTimes(substring+",临近起飞,"+str1);
            }
        }

        }
        for (FlightInfo flightInfo1 : list) {
        //地区与航班的起飞地点
        List<FlightInfo> flightInfoList2=filtMapper.queryFiltAndAreaEnd(flightInfo1.getEndTerminalId());
        for (FlightInfo flightInfo : flightInfoList2) {  //7200000
            String str1="";
            //时间描述
            String substring = flightInfo.getStartTime().toString().substring(flightInfo.getStartTime().toString().length() - 5, flightInfo.getStartTime().toString().length() - 1);
            if(flightInfo.getaType()==1){
                str1+=flightInfo.getaName();
            }
            if(flightInfo.getaType()==2){
                str1+=flightInfo.getaName();
            }
            if(flightInfo.getaType()==3){
                str1+=flightInfo.getaName();
            }
            flightInfo1.setEndTimes(substring+","+str1);
        }
        }


        for (FlightInfo flightInfo1 : list) {
            Integer count =filtMapper.queryPiao(flightInfo1.getId());
            flightInfo1.setCounts(count);
         }
        for (FlightInfo flightInfo1 : list) {
            BigDecimal price=filtMapper.queryMixPrice(flightInfo1.getId());
            flightInfo1.setMinPrice(price);
        }

        return list;
    }

    @Override
    public Long querycount() {
        return filtMapper.querycount();
    }

    @Override
    public List<PlaneTypeInfo> queryPlaneList() {
        return filtMapper.queryPlaneList();
    }
}
