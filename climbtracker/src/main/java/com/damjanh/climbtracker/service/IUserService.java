package com.damjanh.climbtracker.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {

    UserDetails loadUserByUsername(String username);
}
