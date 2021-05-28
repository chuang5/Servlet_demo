import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import pojo.*;
import data.*;

@WebServlet("/addDepartment")
public class AddDepartment extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AddDepartment.class.getName());

    DepartmentList departmentList = DepartmentList.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("departments", DepartmentList.dList);
        req.getRequestDispatcher("/department/addDepartment.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        boolean exist = false;
        String name = req.getParameter("department");
        for (Department d : departmentList.getList()) {
            logger.info(d.getName());
            if (name.equals(d.getName())) {
                exist = true;
                break;
            }
        }
        
        if(name == ""){
            req.setAttribute("result", "Department cannot be empty");
        }else if (!exist) {
            StringBuilder sb = new StringBuilder(name.toLowerCase().replace("\s", "_"));
            String email = sb.append("@email.com").toString();
            Department department = new Department(departmentList.getList().size(), name, email,
                    new ArrayList<Employee>());
            departmentList.addDepartment(department);
        } else {
            req.setAttribute("result", "Department exist");
        }
        req.setAttribute("departments", DepartmentList.dList);
        req.getRequestDispatcher("/department/addDepartment.jsp").forward(req, res);
    }
}
