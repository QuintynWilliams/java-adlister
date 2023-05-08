import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//SERVLET Java class that accepts http requests
//  Any class that extends HttpServlet = Servlet
//  PORT:     Port 3036
//  Hibachi:  Port 80
//  TOMCAT:   Port 8080 (converts http request into java object passing into a servlet)

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (name != null && !name.equals("")) {
            out.println("<h3>Hello,&nbsp" + name);
        } else {
            out.print("<h3>Hello, World<h3>");
        }

//  TEST: TYPE http://localhost:8080/welcome?car=[something] in the URL path
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

//      Sets the type of output browser receives
        res.setContentType("text/html");

//      Generates an output in response
        PrintWriter out = res.getWriter();

//      Message to be sent out to the browser
        out.println("<h1> Hello, World!<!h1>");

    }

}