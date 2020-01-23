package com.fh.mapper;

import com.fh.model.FlightInfo;
import com.fh.model.PlaneTypeInfo;

import java.math.BigDecimal;
import java.util.List;

public interface FiltMapper {
    List<FlightInfo> queryFiltAndPlane();

    List<FlightInfo> queryFiltAndArea(Integer id);

    List<FlightInfo> queryFiltAndAreaEnd(Integer id);

    Integer queryPiao(Integer id);

    BigDecimal queryMixPrice(Integer id);

    Long querycount();

    List<PlaneTypeInfo> queryPlaneList();
}
