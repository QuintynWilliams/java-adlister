import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// just passing a string means name && url pattern is the same
@WebServlet("/welcome")
//          Makes this class a servlet v
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String car = req.getParameter("car");
        resp.setContentType("text/html");
        PrintWriter out =resp.getWriter();

        if (car != null) {
            out.println("<h3>Your&nbsp" + car + " is awesome!<h3>");
        } else {
            out.print("<h3>Tell me about your car!<h3>");
        }

//  TEST: TYPE http://localhost:8080/welcome?car=[something] in the URL path
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//  HttpServletRequest getting what is sent saved as data-type String
        String username = req.getParameter("username");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Welcome,&nbsp" + username + "!</h2>");

    }

}