package com.company.view;

import com.company.dal.DepartmentDAO;
import com.company.dal.DepartmentDAOImpl;
import com.company.models.Department;
import com.company.services.DepartmentServices;
import com.company.services.DepartmentServicesImpl;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class DeptView{

    int id = 1;
    private DepartmentServices dpS = new DepartmentServicesImpl();
    private Scanner scan = new Scanner(System.in);

    private static final String[] MENU = new String[]{
            "* * *",
            "1)Create new record",
            "2)Update record by ID",
            "3)Delete record by ID",
            "4)Get all",
            "5)Insert Samples",
            "6)Get specified number of records",
            "7)Get Dept where Employess more than",
            "8)Get Faculties where Employess more than or equal",
            "9)Get record by ID",
            "0)End",
            "* * *"};

    private String validation(String pattern, String shownText, String shownTextIfWrong){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print(shownText);
            if(!scanner.hasNext(pattern)){
                scanner.next();
                System.out.println(shownTextIfWrong);
                continue;
            }
            return scanner.next();
        }while (true);
    }

    public void menu() {
        boolean isExit = false;
        do {
            System.out.println();
            for (String option : MENU) {
                System.out.println(option);
            }
            System.out.println("Choose a menu number");
            int choice = scan.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("Creating new record: \n");
                    System.out.print("Department = ");String dpName = scan.next();
                    System.out.print("Faculty    = ");String dpFaculty = scan.next();
                    //System.out.print("Employees  = ");
                    int numEmp = Integer.parseInt(validation("\\d+", "Employees  = ", "not a number :/ " ));
                    Department dpObj = new Department( id, dpName, dpFaculty, numEmp);
                    id++;
                    dpS.save(dpObj);
                    System.out.println("saved");
                    break;

                case 2:
                    List<Department> getAl = dpS.getAll();
                    for(Department el : getAl){
                        System.out.println(el);
                    }
                    System.out.print("Update record where : \n");
                    id = Integer.parseInt(validation("\\d+", "id = ", "not a number :/ " ));
                    // System.out.print("id = ");id = scan.nextInt();
                    System.out.print("Department = ");dpName = scan.next();
                    System.out.print("Faculty    = ");dpFaculty = scan.next();
                 //   System.out.print("Employees  = ");
                    numEmp = Integer.parseInt(validation("\\d+", "Employees  = ", "not a number :/ " ));
                    dpS.update(new Department( id, dpName, dpFaculty, numEmp));
                    break;

                case 3:
                    System.out.print("Delete record where ");
                    id = Integer.parseInt(validation("\\d+", "id = ", "not a number :/ " ));
                    dpS.delete(id);
                    break;

                case 4:
                    System.out.print("All records \n");
                    List<Department> getAll = dpS.getAll();
                    for(Department el : getAll){
                        System.out.println(el);
                    }
                    break;

                case 5:
                    //insert

                    dpObj = new Department( id, "Economic Theory", "Management", 10);
                    id++;dpS.save(dpObj);
                    dpObj = new Department( id, "Foreign Languages", "Management", 15);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "dpManagent", "Management", 8);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "Economic and Cybernetic", "Finance-Economy", 20);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "Marketing", "Finance-Economy", 13);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "Information Security", "Information Technology", 13);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "Information Systems", "Information Technology", 13);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "SoftWare Developing", "Information Technology", 13);
                    id++; dpS.save(dpObj);
                    dpObj = new Department( id, "System Analyze", "Information Technology", 13);
                    id++; dpS.save(dpObj);

                    System.out.print("Records have been added \n");
                    break;

                case 6:
                    System.out.print("Get specified amount of records");
                    int i = Integer.parseInt(validation("\\d+", "Limit = ", "not a number :/ " ));;
                    List<Department> gqd = dpS.getQuantityDepts(i) ;
                    for(Department el : gqd) {
                        System.out.println(el);
                    }
                    break;

                case 7:
                    System.out.print("Get Depts where num of employees more ");
                    numEmp = Integer.parseInt(validation("\\d+", "num = ", "not a number :/ " ));
                    List<Department> getDept = dpS.getListWhereEmpMoreThan(numEmp);
                    for(Department el : getDept){
                        System.out.println(el);
                    };
                    break;

                case 8:
                    System.out.print("Get Faculties where num of Employees More or Equal to ");
                    int num =Integer.parseInt(validation("\\d+", "num = ", "not a number :/ " ));
                  //  dpS.getFacWhereEmpMoreOrEqualThan(num);
                    List<String> getFac = dpS.getFacWhereEmpMoreOrEqualThan(num);
                    for(String el : getFac){
                        System.out.println(el);
                    };
                    break;

                case 9:
                    System.out.print("Get record where ");
                    int idf = Integer.parseInt(validation("\\d+", "id = ", "not a number :/ " ));
                    System.out.println(dpS.getById(idf));
                    break;

                default:
                    System.out.println("This Menu Item Doesn't Exist");
                    break;
            }
        } while (!isExit);
    }
}
