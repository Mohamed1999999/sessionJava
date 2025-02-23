import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteTodo")
public class DeleteTodo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<String> tasks = (ArrayList<String>) session.getAttribute("tasks");

        String indexStr = request.getParameter("index");
        if (tasks != null && indexStr != null) {
            try {
                int index = Integer.parseInt(indexStr);
                if (index >= 0 && index < tasks.size()) {
                    tasks.remove(index);
                }
            } catch (NumberFormatException ignored) {}
        }

        response.sendRedirect("DisplayTodo");
    }
}
