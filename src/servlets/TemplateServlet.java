package servlets;

import database.HibernateUtil;
import database.PersonEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TemplateServlet", urlPatterns = {"/template"})
public class TemplateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addCookie(new Cookie("praveen", "sai"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Session session = HibernateUtil.getDatabaseSession();
        Transaction transaction = session.beginTransaction();
        List<PersonEntity> persons = session.createQuery("from PersonEntity ").list();

        request.setAttribute("personList", persons);
        RequestDispatcher rd = request.getRequestDispatcher("renderHtml.jsp");
        rd.forward(request, response);

        transaction.commit();
        session.close();
    }
}
