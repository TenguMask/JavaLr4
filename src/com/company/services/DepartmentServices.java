package com.company.services;

import com.company.models.Department;

import java.util.List;

public interface DepartmentServices {

    void save(Department dpObj);

    Department getById(int id);
    List<Department> getAll();

    void update(Department dpObj);

    void delete(int id);

    List<Department> getAllSorted();

    List<Department> getQuantityDepts(int num);

    List<Department> getListWhereEmpMoreThan(int num);

    List<String> getFacWhereEmpMoreOrEqualThan(int num);

}
