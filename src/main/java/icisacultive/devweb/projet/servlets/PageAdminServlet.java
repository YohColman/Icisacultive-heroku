package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.Utilisateur;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gestionAdmin")
public class PageAdminServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");

        if (utilisateur!=null){
            if (utilisateur.isAdmin()){
                WebContext context = new WebContext(req, resp, req.getServletContext());

                TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
                templateEngine.process("page_admin", context, resp.getWriter());;
            }
        } else {
            resp.sendRedirect("accueil");
        };
    }
}
