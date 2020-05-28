package com.company.dal;

import com.company.exceptions.EntityAlreadyExistsException;
import com.company.models.Department;

import java.util.*;

public class DepartmentDAOImpl implements DepartmentDAO {
 //   private Set<Department> dpStorage = new HashSet<>();
    private static Map<Integer,Department> dpMap = new HashMap<>();

    @Override
    public void save(Department dpObj) {
       // dpStorage.add(dpObj);
        if (dpMap.containsKey(dpObj.getId())) {
            throw new EntityAlreadyExistsException("Record with this Id Already Exists");
        }
        dpMap.put(dpObj.getId(), dpObj);
    }

    @Override
    public Department getById(int id) {
      //  return dpStorage.stream().filter(el -> el.getId() == id).findFirst().orElse(null);
        return  dpMap.get(id);
    }

    @Override
    public List<Department> getAll() {
        //return new ArrayList<>(dpStorage);
        return new ArrayList<>(dpMap.values());
    }

    @Override
    public void update(Department dpObj) {
     /*   Department upd =  dpStorage.stream().filter(el -> el.getId() == dpObj.getId()).findFirst().orElseThrow();
        dpStorage.remove(upd);
        dpStorage.add(dpObj);
      */
        if (!dpMap.containsKey(dpObj.getId())) {
          throw new NoSuchElementException("AAAA");
        }

        dpMap.put(dpObj.getId(), dpObj);
    }

    @Override
    public void delete(int id) {
        dpMap.remove(id);
       // dpStorage.removeIf(el -> el.getId() == id);
    }





}
