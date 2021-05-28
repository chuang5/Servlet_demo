import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
// import java.util.logging.Logger;

import java.io.*;
import java.util.*;

@WebServlet("/login")
public class Login extends HttpServlet {
    // private static final Logger logger = Logger.getLogger(Login.class.getName());
    Map<String, String> map = new HashMap<>();

    public void init() {
        map.put("admin", "admin");
        map.put("user1", "user1");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String fail = res.getHeader("fail");
        String username = req.getParameter("username");
        String psw = req.getParameter("password");

        boolean result = validate(username, psw);
        if (fail == null && result == true) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24);
            res.addCookie(cookie);
            res.sendRedirect("./home");
        } else {
            req.setAttribute("result", "Username/password invalid");
            req.getRequestDispatcher("./").forward(req, res);
        }
    }

    private boolean validate(String username, String psw) {
        if (map.containsKey(username) && psw.equals(map.get(username)))
            return true;
        return false;
    }
}
