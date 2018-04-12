package icisacultive.devweb.projet.dao;

import icisacultive.devweb.projet.entities.Commande;

import java.sql.Date;
import java.util.List;

public interface CommandeDao {

    public List<Commande> listCommandes();

    public List<Commande> listCommandesByUser(Integer idUser);

    public void paymentDone(Integer idCommande);

    public void passerCommande(Integer montant, Integer idUtilisateur, Integer idLot);

}
