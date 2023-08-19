package com.springlearning.Springboot.tutorial.service;

import com.springlearning.Springboot.tutorial.entity.Department;
import com.springlearning.Springboot.tutorial.error.DepartmentNotFoundException;
import com.springlearning.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
//        return departmentRepository.findById(departmentId).get(); //departmentRepository.findById(departmentId) returns an Optional
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        boolean valueUpdated = false;
        Department depDB = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName()) &&
                !department.getDepartmentName().equalsIgnoreCase(depDB.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
            valueUpdated = true;
        }
        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()) &&
                !department.getDepartmentCode().equalsIgnoreCase(depDB.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
            valueUpdated = true;
        }
        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress()) &&
                !department.getDepartmentAddress().equalsIgnoreCase(depDB.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
            valueUpdated = true;
        }
        if(valueUpdated) {
            return departmentRepository.save(depDB); // This is committing the depDB object in Department table
        } else {
            return depDB;
        }
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
//        return departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
