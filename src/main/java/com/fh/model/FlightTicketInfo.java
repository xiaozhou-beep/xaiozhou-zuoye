package com.fh.model;

import java.math.BigDecimal;

/**
 * @ClassName FlightTicketInfo
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/15
 * @Version V1.0
 **/
//t_flight_ticket(航班机票表)
public class FlightTicketInfo {
    private Integer id;// 机票id
    private Integer flightId;// 航班id
    private Integer type;// 机票类型 1代表经济舱，2代表头等舱
    private Integer totalCount;// 票数
    private BigDecimal price;// 票价


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
