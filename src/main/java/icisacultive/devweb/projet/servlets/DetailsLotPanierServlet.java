/**
 * Servlet gérant la page de détails d'un lot seul
 */

package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.LotPanier;
import icisacultive.devweb.projet.entities.MessageErreur;
import icisacultive.devweb.projet.entities.Utilisateur;
import icisacultive.devweb.projet.managers.CommandeLibrary;
import icisacultive.devweb.projet.managers.LigneDeCommandeLibrary;
import icisacultive.devweb.projet.managers.LotPanierLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

//Commentaire juste pour commit
@WebServlet("/detailslot")
public class DetailsLotPanierServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        Integer idLotPanier = Integer.valueOf(req.getParameter("idLot"));
        LotPanier lotPanierEnQuestion = LotPanierLibrary.getInstance().getLotPanierById(idLotPanier);
        context.setVariable("lotPanier", lotPanierEnQuestion);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("product_details", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");
        Integer idLot = Integer.valueOf(req.getParameter("idLot"));
        Integer montant = LotPanierLibrary.getInstance().getMontantLotById(idLot);

        if(utilisateur != null){
            CommandeLibrary.getInstance().ajouterCommande(montant, utilisateur.getId(), idLot);
            resp.sendRedirect("accueil");
        }
        else {
            MessageErreur messageErreur = new MessageErreur("Vous devez être connecté pour pouvoir passer commande.");
            req.getSession().setAttribute("messageErreur", messageErreur);
            resp.sendRedirect("login");
        }
    }
}
