package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.SeanceDistribution;
import icisacultive.devweb.projet.entities.Utilisateur;
import icisacultive.devweb.projet.managers.LigneDeCommandeLibrary;
import icisacultive.devweb.projet.managers.SeanceDistributionLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/choixDate")
public class ChoixDateLDCServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
        if (utilisateur != null) {
            context.setVariable("utilisateur", utilisateur);
        } else {
            System.out.println("Aucun utilisateur enregistré dans la session");
        }

        Integer idLigneDeCommande = Integer.valueOf(req.getParameter("idlignedecommande"));

        List<SeanceDistribution> lstSeanceDistrib = SeanceDistributionLibrary.getInstance().listSeanceDistribution();
        context.setVariable("lstSeancesDistrib",lstSeanceDistrib);


        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("choixuniquedatelignedecommande", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        System.out.println(date);
        Integer idLigneDeCommande = Integer.valueOf(req.getParameter("idlignedecommande"));
        System.out.println(idLigneDeCommande);
        LigneDeCommandeLibrary.getInstance().choixDateLigneDeCommande(idLigneDeCommande, date);
        resp.sendRedirect("monprofil");
    }
}
