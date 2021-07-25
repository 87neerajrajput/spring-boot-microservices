package com.jpmchase.tpm.userservice.service;

import com.jpmchase.tpm.userservice.entity.User;

public interface UserService {
    User getUser(Long userId);
}
