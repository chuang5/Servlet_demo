import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import data.*;
import pojo.*;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
    EmployeeList employeeList = EmployeeList.getInstance();
    DepartmentList departmentList = DepartmentList.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("employees", EmployeeList.eList);
        req.setAttribute("options", departmentList.getList());
        req.getRequestDispatcher("/employee/addEmployee.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        boolean exist = false;
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        Integer age = req.getParameter("age").equals("") ? null : Integer.valueOf(req.getParameter("age"));
        String department = req.getParameter("department").replaceAll("`", "");
        for (Employee e : employeeList.getList()) {
            // logger.info(e.getFirstName());
            if (firstname.equals(e.getFirstName()) && lastname.equals(e.getLastName()) && age == e.getAge()
                    && department.equals(e.getDepartment())) {
                exist = true;
                break;
            }
        }

        if (firstname == null || lastname == null || age == null || department == null) {
            req.setAttribute("result", "Any field cannot be empty");
        }else if (!exist) {
            Employee employee = new Employee(employeeList.getList().size(), firstname, lastname, age, department);
            employeeList.addEmployee(employee);
        } else {
            req.setAttribute("result", "Employee exist");
        }
        req.setAttribute("options", departmentList.getList());
        req.setAttribute("employees", EmployeeList.eList);
        req.getRequestDispatcher("/employee/addEmployee.jsp").forward(req, res);
    }
}
