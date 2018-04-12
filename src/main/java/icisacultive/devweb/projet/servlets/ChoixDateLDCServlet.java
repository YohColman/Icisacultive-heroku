package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.SeanceDistribution;
import icisacultive.devweb.projet.entities.Utilisateur;
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

        Integer idLigneDeCommande = Integer.valueOf(req.getParameter("idlignedecommande"));

        List<SeanceDistribution> lstSeanceDistrib = SeanceDistributionLibrary.getInstance().listSeanceDistribution();
        context.setVariable("lstSeancesDistrib",lstSeanceDistrib);


        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("choixuniquedatelignedecommande", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
