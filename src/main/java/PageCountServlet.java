import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Objects;

// just passing a string means name && url pattern is the same
@WebServlet("/count")
//          Makes this class a servlet v
public class PageCountServlet extends HttpServlet {

    private int count;

    public void init () {
        count = 0;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reset = req.getParameter("reset");

        resp.setContentType("text/html");

        count++;

        PrintWriter out = resp.getWriter();

        if (Objects.equals(reset, "Y")) {
            init();
        } else {
            out.println("<h3>Page has been viewed: &nbsp<h3>" + count);
        }

    }
}