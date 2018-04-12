import icisacultive.devweb.projet.dao.PanierDao;
import icisacultive.devweb.projet.dao.impl.PanierDaoImpl;
import icisacultive.devweb.projet.entities.Panier;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class PanierDaoTestCase {
    private PanierDao panierDao = new PanierDaoImpl();

    @Test
    public void shouldListPersonnage(){
        //WHEN
        List<Panier> lstPanier = panierDao.listPanier();
        //THEN
        assertThat(lstPanier).hasSize(3);
        assertThat(lstPanier).extracting("id", "typepanier").containsOnly(
                tuple(1, "Petit format" ),
                tuple(2, "Moyen format" ),
                tuple(3, "Format familial" ));


    }
}
