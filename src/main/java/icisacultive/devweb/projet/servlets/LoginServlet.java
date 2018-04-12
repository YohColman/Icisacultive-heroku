package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.MessageErreur;
import icisacultive.devweb.projet.managers.UtilisateurLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends GenericServlet{
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
        templateEngine.process("login", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identifiant = request.getParameter("inputEmail1");
        String motDePasse = request.getParameter("inputPassword1");

        try{
            if (UtilisateurLibrary.getInstance().validerMotDePasse(identifiant, motDePasse)) {
                System.out.println("Entrée dans le IF de LOGINSERVLET");
                request.getSession().setAttribute("utilisateur", UtilisateurLibrary.getInstance().getUtilisateur(identifiant));
                MessageErreur messageErreur = new MessageErreur("");
                request.getSession().setAttribute("messageErreur", messageErreur);
                response.sendRedirect("accueil");
                System.out.println("Utilisateur mis en session");
            }
            System.out.println("Sortie du IF de LOGINSERVLET");
        }
        catch (IllegalArgumentException e) {
            System.out.println("TRY raté de LOGINSERVLET");
            MessageErreur messageErreur = new MessageErreur("Les informations que vous avez entrées ne sont pas correctes");
            request.getSession().setAttribute("messageErreur", messageErreur);
            response.sendRedirect("login");
        }
    }
}

