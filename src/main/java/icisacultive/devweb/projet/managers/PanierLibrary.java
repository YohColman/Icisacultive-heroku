package icisacultive.devweb.projet.managers;

import icisacultive.devweb.projet.dao.PanierDao;
import icisacultive.devweb.projet.dao.impl.PanierDaoImpl;
import icisacultive.devweb.projet.entities.Panier;

import java.util.List;

public class PanierLibrary {

    private static class PanierLibraryHolder {
        private final static PanierLibrary instance = new PanierLibrary();
    }

    public static PanierLibrary getInstance(){return PanierLibraryHolder.instance;}

    private PanierDao panierDao = new PanierDaoImpl();

    private PanierLibrary(){

    }

    public List<Panier> listPanier(){return panierDao.listPanier();}

    public Panier getPanier(Integer id){return panierDao.getPanier(id);}
}
