package servlets;

import database.HibernateUtil;
import database.PersonEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DatabaseServlet", urlPatterns = {"/person"})
public class DatabaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addCookie(new Cookie("praveen", "sai"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Session session = HibernateUtil.getDatabaseSession();
        Transaction transaction = session.beginTransaction();
        List<PersonEntity> persons = session.createQuery("from PersonEntity ").list();

        out.println("<table border=1px>");
        for(PersonEntity person : persons) {
            out.println("<tr>");
            out.println("<td> " + person.getId() + "</td>");
            out.println("<td> " + person.getName() + "</td>");
            out.println("<td> " + person.getAddress() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        transaction.commit();
        session.close();
    }
}
