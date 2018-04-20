package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.LigneDeCommande;
import icisacultive.devweb.projet.entities.Utilisateur;
import icisacultive.devweb.projet.managers.LigneDeCommandeLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listepanierseance")
public class ListePanierParSeanceServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
        if (utilisateur != null) {
            context.setVariable("utilisateur", utilisateur);
        } else {
            System.out.println("Aucun utilisateur enregistré dans la session");
        }

        String date = req.getParameter("date");
        System.out.println(date);

        List<LigneDeCommande> lstLDCparSeance = LigneDeCommandeLibrary.getInstance().listLigneDeCommandeByDate(date);

        context.setVariable("listPanierParSeance",lstLDCparSeance);
        context.setVariable("seance",date);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("listePaniersParSeance", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
