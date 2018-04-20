package icisacultive.devweb.projet.dao;

import icisacultive.devweb.projet.entities.LigneDeCommande;

import java.util.List;

public interface LigneDeCommandeDao {
    public List<LigneDeCommande> listLigneDeCommande();

    public List<LigneDeCommande> listLigneDeCommandeByDate(String date);

    public List<LigneDeCommande> listLigneDeCommandeByUser(Integer idCommande);

    public LigneDeCommandeDao getLigneDeCommande(Integer id);

    public void ajouterLigneDeCommande(Integer idCommande);

    public Integer getNombreDePanierCommande(Integer idCommande);

    public void choisirDateLigneDeCommande(Integer idLigneDeCommande, String date);

    public void changerStatutLigneDeCommande(Integer idLigneDeCommande);
}
