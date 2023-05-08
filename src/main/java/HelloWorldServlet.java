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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

//      Sets the type of output browser receives
        res.setContentType("text/html");

//      Generates an output in response
        PrintWriter out = res.getWriter();

//      Message to be sent out to the browser
        out.println("<h1> Hello, World!<!h1>");

    }
}

