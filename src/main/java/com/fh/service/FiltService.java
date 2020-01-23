package com.fh.service;

import com.fh.model.FlightInfo;
import com.fh.model.PlaneTypeInfo;

import java.util.List;

public interface FiltService {
    List<FlightInfo> queryFilteList();

    Long querycount();

    List<PlaneTypeInfo> queryPlaneList();
}
