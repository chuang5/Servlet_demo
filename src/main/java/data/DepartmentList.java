package data;

import java.util.*;
import java.util.logging.Logger;

import pojo.*;

public class DepartmentList {

    private static final Logger logger = Logger.getLogger(EmployeeList.class.getName());


    public static DepartmentList instance = null;

    public static List<Department> dList;

    private DepartmentList(){
        dList = new ArrayList<>();
        addDepartment(new Department(0, "HQ", "hq@email.com", new ArrayList<Employee>()));
        addDepartment(new Department(1, "Financial", "financial@email.com", new ArrayList<Employee>()));
    }

    public static DepartmentList getInstance(){
        if(instance == null){
            instance = new DepartmentList();
        }
        return instance;
    }
    
    public void addDepartment(Department department){
        dList.add(department);
        // logger.info(dList.toString());
    }

    public List<Department> getList(){
        return dList;
    }

    public Department findByName(String name){
        
        for(Department d : dList){
            // logger.info("findByName(): " + name + " " + d.getName());
            if(d.getName().equals(name)) return d;
        }
        return null;
    }
}
