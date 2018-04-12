package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.Commande;
import icisacultive.devweb.projet.entities.Utilisateur;
import icisacultive.devweb.projet.managers.CommandeLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/monprofil")
public class MonProfilServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
        if (utilisateur!=null){
            WebContext context = new WebContext(req, resp, req.getServletContext());

            Integer id = utilisateur.getId();

            List<Commande> listCommandesByUser = CommandeLibrary.getInstance().listCommandeByUser(id);
            context.setVariable("listCommandesParUtilisateur", listCommandesByUser);

            TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
            templateEngine.process("monprofil", context, resp.getWriter());
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
