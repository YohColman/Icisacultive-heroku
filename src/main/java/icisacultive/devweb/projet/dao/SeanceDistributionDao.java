package icisacultive.devweb.projet.dao;

import icisacultive.devweb.projet.entities.SeanceDistribution;

import java.util.List;

public interface SeanceDistributionDao {

    public List<SeanceDistribution> listSeanceDistrib();

    public void ajouterSeanceDistrib(String date);
}
