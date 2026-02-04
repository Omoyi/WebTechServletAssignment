package auca.ac.rw.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // HTML response structure
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Response</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    height: 100vh;");
        out.println("    margin: 0;");
        out.println("}");
        out.println(".message-container {");
        out.println("    background-color: white;");
        out.println("    padding: 40px;");
        out.println("    border-radius: 8px;");
        out.println("    box-shadow: 0 2px 10px rgba(0,0,0,0.1);");
        out.println("    text-align: center;");
        out.println("    max-width: 500px;");
        out.println("}");
        out.println(".weak {");
        out.println("    color: #d32f2f;");
        out.println("}");
        out.println(".strong {");
        out.println("    color: #388e3c;");
        out.println("}");
        out.println("a {");
        out.println("    display: inline-block;");
        out.println("    margin-top: 20px;");
        out.println("    color: #4CAF50;");
        out.println("    text-decoration: none;");
        out.println("}");
        out.println("a:hover {");
        out.println("    text-decoration: underline;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='message-container'>");
        
        // Check password length and display appropriate message
        if (password != null && password.length() < 8) {
            out.println("<h2 class='weak'>Password is Weak!</h2>");
            out.println("<p>Hello <strong>" + username + "</strong>, your password is weak. Try a strong one.</p>");
        } else {
            out.println("<h2 class='strong'>Login Successful!</h2>");
            out.println("<p>Welcome <strong>" + username + "</strong></p>");
        }
        
        out.println("<a href='login.jsp'>Back to Login</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}