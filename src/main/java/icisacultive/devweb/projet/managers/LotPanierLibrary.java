package icisacultive.devweb.projet.managers;

import icisacultive.devweb.projet.dao.LotPanierDao;
import icisacultive.devweb.projet.dao.PanierDao;
import icisacultive.devweb.projet.dao.impl.LotPanierDaoImpl;
import icisacultive.devweb.projet.dao.impl.PanierDaoImpl;
import icisacultive.devweb.projet.entities.LotPanier;
import icisacultive.devweb.projet.entities.Panier;

import java.util.List;

public class LotPanierLibrary {

    private static class LotPanierLibraryHolder {
        private final static LotPanierLibrary instance = new LotPanierLibrary();
    }

    public static LotPanierLibrary getInstance(){return LotPanierLibraryHolder.instance;}

    private LotPanierDao lotPanierDao = new LotPanierDaoImpl();

    private LotPanierLibrary(){

    }

    public List<LotPanier> listLotPanierByIdPanier(Integer id){return lotPanierDao.listLotPanierByIdPanier(id);}

    public LotPanier getLotPanierById(Integer id){return lotPanierDao.getLotPanierById(id);}

    public Integer getMontantLotById(Integer id){return lotPanierDao.getMontantLotById(id);}
}
