package icisacultive.devweb.projet.entities;

import java.util.Date;

public class LigneDeCommande {

    private Integer idLigneDeCommande;
    private Integer receptionne;
    private Integer idCommande;
    private Date date;
    private String typePanier;
    private String nomUtilisateur;
    private String prenomUtilisateur;

    public LigneDeCommande(Integer idLigneDeCommande, Integer receptionne, Integer idCommande, Date date) {
        this.idLigneDeCommande = idLigneDeCommande;
        this.receptionne = receptionne;
        this.idCommande = idCommande;
        this.date = date;
    }

    public LigneDeCommande(Integer idLigneDeCommande, Integer receptionne, Integer idCommande, Date date, String type) {
        this.idLigneDeCommande = idLigneDeCommande;
        this.receptionne = receptionne;
        this.idCommande = idCommande;
        this.date = date;
        this.typePanier=type;
    }

    public LigneDeCommande(Integer idLigneDeCommande, Integer receptionne, Integer idCommande, Date date, String typePanier, String nomUtilisateur, String prenomUtilisateur) {
        this.idLigneDeCommande = idLigneDeCommande;
        this.receptionne = receptionne;
        this.idCommande = idCommande;
        this.date = date;
        this.typePanier = typePanier;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getTypePanier() {
        return typePanier;
    }

    public void setTypePanier(String typePanier) {
        this.typePanier = typePanier;
    }

    public Integer getIdLigneDeCommande() {
        return idLigneDeCommande;
    }

    public void setIdLigneDeCommande(Integer idLigneDeCommande) {
        this.idLigneDeCommande = idLigneDeCommande;
    }

    public Integer getReceptionne() {
        return receptionne;
    }

    public void setReceptionne(Integer receptionne) {
        this.receptionne = receptionne;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
