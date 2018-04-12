package icisacultive.devweb.projet.servlets;

import icisacultive.devweb.projet.entities.Commande;
import icisacultive.devweb.projet.managers.CommandeLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listesCommandes")
public class   ListeCommandesServlet extends GenericServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<Commande> listCommandes = CommandeLibrary.getInstance().listCommandes();
        context.setVariable("listCommandes", listCommandes);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("listeCommandes", context, resp.getWriter());
    }
}
