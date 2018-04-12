import icisacultive.devweb.projet.dao.LotPanierDao;
import icisacultive.devweb.projet.dao.impl.LotPanierDaoImpl;
import icisacultive.devweb.projet.entities.LotPanier;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class LotPanierDaoTestCase {
    private LotPanierDao lotPanierDao = new LotPanierDaoImpl();

    @Test
    public void shouldListLotPanierByIdPanier(){
        //WHEN
        List<LotPanier> lstLotPanier = lotPanierDao.listLotPanierByIdPanier(1);
        //THEN
        assertThat(lstLotPanier).hasSize(2);
        assertThat(lstLotPanier).extracting("idLot", "prix","nombrePanier", "idPanier").containsOnly(
                tuple(1, 24, 3, 1 ),
                tuple(2, 48, 6, 1 ));


    }
}
