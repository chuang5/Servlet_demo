package data;


import java.util.*;
import java.util.logging.Logger;

import pojo.*;

public class EmployeeList {

    private static final Logger logger = Logger.getLogger(EmployeeList.class.getName());

    public static EmployeeList instance = null;

    public static List<Employee> eList;

    private EmployeeList() {
        eList = new ArrayList<>();
        while(DepartmentList.getInstance() == null){
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        addEmployee(new Employee(0, "Adam", "Aston", 21, "HQ"));
        addEmployee(new Employee(1, "Betty", "Balmon", 32, "HQ"));
    }

    public static EmployeeList getInstance() {
        if (instance == null) {
            instance = new EmployeeList();
        }
        return instance;
    }

    public void addEmployee(Employee employee) {
        eList.add(employee);
        DepartmentList
            .getInstance()
            .findByName(employee.getDepartment())
            .getEList()
            .add(employee);
        // logger.info(eList.toString());
    }

    public List<Employee> getList() {
        return eList;
    }
}
