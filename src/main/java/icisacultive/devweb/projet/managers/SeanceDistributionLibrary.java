package icisacultive.devweb.projet.managers;

import icisacultive.devweb.projet.dao.SeanceDistributionDao;
import icisacultive.devweb.projet.dao.impl.SeanceDistributionDaoImpl;
import icisacultive.devweb.projet.entities.SeanceDistribution;

import java.sql.Date;
import java.util.List;

public class SeanceDistributionLibrary {

    private static class SeandeDistributionLibraryHolder {
        private final static SeanceDistributionLibrary instance = new SeanceDistributionLibrary();
    }

    public static SeanceDistributionLibrary getInstance(){return SeandeDistributionLibraryHolder.instance;}

    private SeanceDistributionDao seanceDistributionDao = new SeanceDistributionDaoImpl();

    private SeanceDistributionLibrary(){

    }

    public List<SeanceDistribution> listSeanceDistribution(){return this.seanceDistributionDao.listSeanceDistrib();}

    public void ajouterSeance(String date){this.seanceDistributionDao.ajouterSeanceDistrib(date);}
}
