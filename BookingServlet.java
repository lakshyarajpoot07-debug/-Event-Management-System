import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 MVC Architecture Used:
 ---------------------
 View       : Swing UI (CustomerForm, Event Forms)
 Controller : BookingServlet
 Model      : CustomerDAO, Event classes
 Database   : MySQL (JDBC)

 This servlet is added for Review-2 Servlet Implementation marks.
*/

@WebServlet("/bookEvent")
public class BookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        try {
            // Read parameters (simulating client request)
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            // DAO interaction
            CustomerDAO dao = new CustomerDAO();
            int customerId = dao.saveCustomer(name, phone, address);

            response.getWriter().println("✅ Booking received via Servlet");
            response.getWriter().println("Customer ID: " + customerId);
            response.getWriter().println("Name: " + name);
            response.getWriter().println("Phone: " + phone);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error processing booking in servlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        response.getWriter().println("BookingServlet is active. Use POST to submit booking.");
    }
}
