package com.springlearning.Springboot.tutorial.controller;

import com.springlearning.Springboot.tutorial.entity.Department;
import com.springlearning.Springboot.tutorial.error.DepartmentNotFoundException;
import com.springlearning.Springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    // Property based Dependency Injection (other two are setter based and constructor based)
    @Autowired
    private DepartmentService departmentService;

    // SL4J comes automatically with Spring Boot
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("") // --> /departments
    public Department saveDepartment(@Valid @RequestBody Department department) {
        //With the @Valid annotation, the RequestBody received will be validated against the validation annotations (e.g. @NotBlank)
        //defined in the Department entity
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("") // --> /departments
    public ResponseEntity<List<Department>> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return ResponseEntity.ok(departmentService.fetchDepartmentList());
    }

    @GetMapping("/{id}") // --> /departments/{id}
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/{id}") // --> /departments/{id}
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Department Successfully";
    }

    @PutMapping("/{id}") // --> /departments/{id}
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/name/{name}") // --> /departments/name/{name}
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
