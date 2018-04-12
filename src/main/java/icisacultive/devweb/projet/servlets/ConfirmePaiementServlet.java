package icisacultive.devweb.projet.servlets;



import icisacultive.devweb.projet.managers.CommandeLibrary;
import icisacultive.devweb.projet.managers.LigneDeCommandeLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/confirmePaiement")
public class ConfirmePaiementServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());


        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("confirmePaiement", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idCommande = Integer.valueOf(req.getParameter("idcommande"));
        CommandeLibrary.getInstance().paymentDone(idCommande);
        Integer nbrePaniers = LigneDeCommandeLibrary.getInstance().getNombreDePaniersCommande(idCommande);
        for (int i = 0; i<nbrePaniers; i++){
            LigneDeCommandeLibrary.getInstance().ajouterLigneDeCommande(idCommande);
        }
        resp.sendRedirect("listesCommandes");
    }
}
