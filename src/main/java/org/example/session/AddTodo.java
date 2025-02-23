import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddTodo")
public class AddTodo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String task = request.getParameter("task");
        HttpSession session = request.getSession();
        ArrayList<String> tasks = (ArrayList<String>) session.getAttribute("tasks");

        if (tasks == null) {
            tasks = new ArrayList<>();
            session.setAttribute("tasks", tasks);
        }

        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task);
        }

        out.println("<p>The task has been added to the list.</p>");
        out.println("<a href='index.html'>Back to Home</a>");
    }
}
