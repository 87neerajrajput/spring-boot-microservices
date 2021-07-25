package com.jpmchase.tpm.departmentservice.departmentservice.controller;

import com.jpmchase.tpm.departmentservice.departmentservice.entity.Department;
import com.jpmchase.tpm.departmentservice.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{Id}")
    public Department findDepartmentById(@PathVariable("Id") Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }
}
