package icisacultive.devweb.projet.dao;

import icisacultive.devweb.projet.entities.Panier;

import java.util.List;

public interface PanierDao {
    public List<Panier> listPanier();

    public Panier getPanier(Integer id);
    
}
