package com.company.services;

import com.company.dal.DepartmentDAO;
import com.company.dal.DepartmentDAOImpl;
import com.company.models.Department;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServicesImpl implements DepartmentServices {

    private DepartmentDAO dao = new DepartmentDAOImpl();

    @Override
    public void save(Department dpObj) {
        dao.save(dpObj);
    }

    @Override
    public Department getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public void update(Department dpObj) {
        dao.update(dpObj);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Department> getAllSorted() {
        List<Department> departments = dao.getAll();
        return departments.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public List<Department> getQuantityDepts(int num) {
        List<Department> departments = dao.getAll();
        return departments.stream().limit(num).collect(Collectors.toList());
    }

    @Override
    public List<Department> getListWhereEmpMoreThan(int num) {
        List<Department> departments = dao.getAll();
        //return departments.stream().count(  departments);
        return departments.stream().filter(el -> el.getNumEmployees() >= num).collect(Collectors.toList());
    }

    @Override
    public List<String> getFacWhereEmpMoreOrEqualThan(int num) {
        List<Department> departments = dao.getAll();
        Map<String, Integer> faculties = new HashMap<>();
        for (int i = 0; i < departments.size(); i++) {
            if (!faculties.containsKey(departments.get(i))){
                faculties.put(departments.get(i).getDpFaculty(),0);
            }
        }
        faculties.keySet().forEach(e -> faculties.put(e, departments.stream().filter(el -> el.getDpFaculty().equals(e))
                .map(Department::getNumEmployees).reduce(0, (accum, r) -> accum += r)));
        return faculties.keySet().stream().filter(e -> faculties.get(e) >= num).collect(Collectors.toList());
    }
}