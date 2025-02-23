import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DisplayTodo")
public class DisplayTodo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        ArrayList<String> tasks = (ArrayList<String>) session.getAttribute("tasks");

        out.println("<h2>To-Do List</h2>");
        if (tasks == null || tasks.isEmpty()) {
            out.println("<p>No tasks found.</p>");
        } else {
            out.println("<p>Number of tasks: " + tasks.size() + "</p>");
            out.println("<ul>");
            for (int i = 0; i < tasks.size(); i++) {
                out.println("<li>" + tasks.get(i) + " <a href='DeleteTodo?index=" + i + "'>Delete</a></li>");
            }
            out.println("</ul>");
        }
        out.println("<a href='index.html'>Back to Home</a>");
    }
}
