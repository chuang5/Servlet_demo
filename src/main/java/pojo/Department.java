package pojo;

import java.util.*;

public class Department {
    Integer id;
    String name;
    String email;
    List<Employee> eList;

    public Department(int id, String name, String email, ArrayList<Employee> arrayList){
        this.id = id;
        this.name = name;
        this.email = email;
        this.eList = arrayList;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Employee> getEList() {
        return this.eList;
    }

    public void setEList(List<Employee> eList) {
        this.eList = eList;
    }
    
}
