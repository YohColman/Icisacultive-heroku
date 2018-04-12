import icisacultive.devweb.projet.dao.UtilisateurDao;
import icisacultive.devweb.projet.dao.impl.UtilisateurDaoImpl;
import icisacultive.devweb.projet.entities.Utilisateur;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilisateurDaoTestCase {
    private UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();

    @Test
    public void shouldGetUtilisateurByMail(){
        Utilisateur utilisateur = utilisateurDao.getUtilisateur("yohann.colman@hei.yncrea.fr");

        assertThat(utilisateur).isNotNull();
        assertThat(utilisateur.getId()).isEqualTo(1);
        assertThat(utilisateur.getNom()).isEqualTo("Colman");
        assertThat(utilisateur.getPrenom()).isEqualTo("Yohann");
        assertThat(utilisateur.getMail()).isEqualTo("yohann.colman@hei.yncrea.fr");
        assertThat(utilisateur.getMotdepasse()).isEqualTo("yoyo");
        assertThat(utilisateur.getAdmin()).isEqualTo(1);
    }
}
