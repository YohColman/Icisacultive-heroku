package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.MessageErreur;
import icisacultive.devweb.projet.entities.Utilisateur;
import icisacultive.devweb.projet.managers.UtilisateurLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/enregistrement")
public class EnregistrementServlet extends GenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        MessageErreur messageErreur = (MessageErreur) req.getSession().getAttribute("messageErreur");
        if (messageErreur != null) {
            context.setVariable("messageErreur", messageErreur);
        } else {
            System.out.println("Aucun message d'erreur enregistré dans la session");
        }

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("register", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entrée du DOPOST");
        String prenom = req.getParameter("prenom");
        String nom = req.getParameter("nom");
        String mail = req.getParameter("mail");
        String motDePasse = req.getParameter("mdp");
        String confirmationMotDePasse = req.getParameter("confmdp");

        System.out.println("DOPOST ENREGISTREMENTSERVLET : prenom= "+prenom+" - nom= "+prenom+" - mail= "+mail+" - telephone=  - mot de passe = "+motDePasse+" - confirmation mdp = "+confirmationMotDePasse);
        if (UtilisateurLibrary.getInstance().validationChampsFormulaireAjout(nom, prenom , mail , motDePasse, confirmationMotDePasse)) {
            System.out.println("Entrée dans le IF de ENREGISTREMENTSERVLET");
            UtilisateurLibrary.getInstance().ajouterUtilisateur(nom, prenom, 0000000000, mail, motDePasse );
            MessageErreur messageErreur = new MessageErreur("");
            req.getSession().setAttribute("messageErreur", messageErreur);
            req.getSession().setAttribute("utilisateur", UtilisateurLibrary.getInstance().getUtilisateur(mail));
            resp.sendRedirect("accueil");
        } else {
            System.out.println("TRY raté de ENREGISTREMENTSERVLET");
            MessageErreur messageErreur = new MessageErreur("Les informations que vous avez entrées ne sont pas correctes");
            req.getSession().setAttribute("messageErreur", messageErreur);
            resp.sendRedirect("enregistrement");
        }
    }
}
