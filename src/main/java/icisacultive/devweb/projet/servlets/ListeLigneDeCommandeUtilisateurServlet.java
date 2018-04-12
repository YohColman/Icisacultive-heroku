package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.LigneDeCommande;
import icisacultive.devweb.projet.managers.LigneDeCommandeLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/monProfilDates")
public class ListeLigneDeCommandeUtilisateurServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        Integer idCommande = Integer.valueOf(req.getParameter("idcommande"));
        List<LigneDeCommande> lstLigneDeCommandeByUserByCommande = LigneDeCommandeLibrary.getInstance().listLigneDeCommandeByCommandeByUser(idCommande);
        context.setVariable("lstLigneDeCommande",lstLigneDeCommandeByUserByCommande);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("choixdatelignedecommande", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
