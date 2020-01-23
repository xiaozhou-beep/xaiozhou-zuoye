package com.fh.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName FlightInfo
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/15
 * @Version V1.0
 **/
public class FlightInfo {
    //t_flight(航班表)
    private Integer id;// 航班id
    private String name;// 航班名称
    private Integer typeId;// 机型id
    private Date startTime;// 起飞时间
    private Date  endTime;// 到大时间
    private Integer startTerminalId;// 出发机场航站楼id
    private Integer endTerminalId;// 到达机场航站楼id

    private String startTimes;// 起飞时间 string
    private String endTimes;// 到达时间 string

    private String pName;

    private Integer type;//机型大小，大型？小型？

    private Integer aType;  //type 比如1代表城市 2代表机场 3代表航站楼

    private String aName;  //地区名称

    private Integer counts;//票的数量

    private BigDecimal minPrice; //最小值

    public Integer getId() {
        return id;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getEndTimes() {
        return endTimes;
    }

    public void setEndTimes(String endTimes) {
        this.endTimes = endTimes;
    }

    public String getaName() {
        return aName;
    }

    public String getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(String startTimes) {
        this.startTimes = startTimes;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getaType() {
        return aType;
    }

    public void setaType(Integer aType) {
        this.aType = aType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStartTerminalId() {
        return startTerminalId;
    }

    public void setStartTerminalId(Integer startTerminalId) {
        this.startTerminalId = startTerminalId;
    }

    public Integer getEndTerminalId() {
        return endTerminalId;
    }

    public void setEndTerminalId(Integer endTerminalId) {
        this.endTerminalId = endTerminalId;
    }
}
