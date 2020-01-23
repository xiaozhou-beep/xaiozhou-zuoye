package com.fh.service;

import com.fh.model.ServerResponse;

public interface UserService {
    ServerResponse login(String userName, String password);
}
