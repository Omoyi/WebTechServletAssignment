import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get the search query parameter
        String query = request.getParameter("query");
        
        // Check if query is not null or empty
        if (query != null && !query.trim().isEmpty()) {
            // Encode the query to handle special characters
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            
            // Construct the Google search URL
            String googleSearchUrl = "https://www.google.com/search?q=" + encodedQuery;
            
            // Use sendRedirect to redirect the user to Google
            response.sendRedirect(googleSearchUrl);
        } else {
            // If query is empty, redirect back to the search page
            response.sendRedirect("search.jsp");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}