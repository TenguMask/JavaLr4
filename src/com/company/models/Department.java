package com.company.models;

import java.util.List;
import java.util.Objects;

public class Department implements Comparable<Department> {
    private int id;
    private String dpName;
    private String dpFaculty;
    private int numEmployees;

    public Department(String dpName, String dpFaculty, int numEmployees) {
        this.dpName = dpName;
        this.dpFaculty = dpFaculty;
        this.numEmployees = numEmployees;
    }

    public Department(int id, String dpName, String dpFaculty, int numEmployees) {
        this.id = id;
        this.dpName = dpName;
        this.dpFaculty = dpFaculty;
        this.numEmployees = numEmployees;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    public String getDpFaculty() {
        return dpFaculty;
    }

    public void setDpFaculty(String dpFaculty) {
        this.dpFaculty = dpFaculty;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                numEmployees == that.numEmployees &&
                Objects.equals(dpName, that.dpName) &&
                Objects.equals(dpFaculty, that.dpFaculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dpName, dpFaculty, numEmployees);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dpName='" + dpName + '\'' +
                ", dpFaculty='" + dpFaculty + '\'' +
                ", numEmployees=" + numEmployees +
                '}';
    }

    @Override
    public int compareTo(Department dp) {
        return this.id - dp.getId();
    }
}
