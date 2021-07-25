package com.jpmchase.tpm.userservice.service;

import com.jpmchase.tpm.userservice.entity.Department;
import com.jpmchase.tpm.userservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    List<User> userList = List.of(
            new User(1L, "Michael", 1, null),
            new User(2L, "Jordan", 35, null),
            new User(3L, "Schmid", 33, null),
            new User(4L, "Ted", 35, null)
    );

    @Override
    public User getUser(Long userId) {
        log.info("Inside Service getUser method.");
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + userId,
                Department.class);
        User filterByDepartment = userList.stream().filter(user -> user.getUserId().equals(userId)).findAny()
                .orElse(null);
        filterByDepartment.setDepartment(department);
        return filterByDepartment;
    }
}
