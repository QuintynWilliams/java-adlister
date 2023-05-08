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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//  HttpServletRequest getting what is sent saved as data-type String
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Welcome, " + username + "!</h2>");

    }

}
