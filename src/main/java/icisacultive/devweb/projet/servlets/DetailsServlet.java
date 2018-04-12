/**
 * Servlet gérant les détails des différents lots par format de panier
 */

package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.LotPanier;
import icisacultive.devweb.projet.entities.Panier;
import icisacultive.devweb.projet.entities.Utilisateur;
import icisacultive.devweb.projet.managers.LotPanierLibrary;
import icisacultive.devweb.projet.managers.PanierLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/details")
public class DetailsServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
        if (utilisateur != null) {
            context.setVariable("utilisateur", utilisateur);
        } else {
            System.out.println("Aucun utilisateur enregistré dans la session");
        }

        Integer idPanierEnQuestion = Integer.valueOf(req.getParameter("idPanier"));
        List<LotPanier> lstLotPanier = LotPanierLibrary.getInstance().listLotPanierByIdPanier(idPanierEnQuestion);
        context.setVariable("lstLotPanier", lstLotPanier);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("details", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
