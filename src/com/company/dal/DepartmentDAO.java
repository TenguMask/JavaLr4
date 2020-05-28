package com.company.dal;

import com.company.models.Department;

import java.util.List;

public interface DepartmentDAO {

    void save(Department dpObj);

    Department getById(int id);
    List<Department> getAll();

    void update(Department dpObj);

    void delete(int id);
}
