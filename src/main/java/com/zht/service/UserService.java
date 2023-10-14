package com.zht.service;

import com.zht.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User login(User user);
}
