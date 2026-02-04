package auca.ac.rw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get parameters from the request
        String username = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        
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
        out.println("   background: linear-gradient(135deg, #f33da4 0%, #eb5527 100%);\n" + //
                        "");
        out.println("    padding: 100px;");
        out.println("    border-radius: 8px;");
        out.println("    box-shadow: 0 2px 10px rgba(128, 127, 127, 0.1);");
        out.println("    text-align: center;");
        out.println("    max-width: 500px;");
        out.println("}");
        out.println(".weak {");
        out.println("    color: #d35d2f;");
        out.println("}");
        out.println(".strong {");
        out.println("    color: #ffffff;");
        out.println("}");
        out.println("a {");
        out.println("    display: inline-block;");
        out.println("    margin-top: 20px;");
        out.println("    color: #ffffff;");
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
        
        out.println("<a href='search.html'> Go to Search ← </a>");
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