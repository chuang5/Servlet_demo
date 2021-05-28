import java.io.*;

import data.DepartmentList;
import data.EmployeeList;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
// import java.util.logging.Logger;

@WebServlet("/home")
public class Home extends HttpServlet {
    // private static final Logger logger = Logger.getLogger(Home.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        //initiate data
        DepartmentList.getInstance();
        EmployeeList.getInstance();

        String username = null;
        for(Cookie c : req.getCookies()){
            if(c.getName().equals("username")) username = c.getValue();
        }
        if(username == null){
            res.sendRedirect("./");
        }else{
            req.setAttribute("username", username);
            req.getRequestDispatcher("/home.jsp").forward(req, res);
        }
    }
}
