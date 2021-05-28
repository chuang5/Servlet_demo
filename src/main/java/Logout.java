import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
// import pojo.User;

import java.io.*;

@WebServlet("/logout")
public class Logout extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();
        
        for(int i = 0; i < cookies.length; i++){
            cookies[i].setMaxAge(0);
            res.addCookie(cookies[i]);
        }
        res.sendRedirect("./");
    }
}
