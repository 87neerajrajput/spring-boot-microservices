package com.jpmchase.tpm.userservice.entity;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String name;
    private int age;
    private Department department;
}
