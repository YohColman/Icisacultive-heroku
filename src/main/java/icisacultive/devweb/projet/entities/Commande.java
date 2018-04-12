package icisacultive.devweb.projet.entities;

import java.util.Date;

public class Commande {
    private Integer id;
    private Integer montant;
    private Integer paye;
    private String nomClient;
    private String prenomClient;
    private Date date;
    private String typePanier;
    private Integer nombrePanier;

    private Integer idUtilisateur;

    public Commande(Integer id, Integer montant, Integer paye, Date date) {
        this.id = id;
        this.montant = montant;
        this.paye=paye;
        this.date=date;
    }

    public Commande(Integer id, Integer montant, Integer paye, Date date, String type, Integer nombre) {
        this.id = id;
        this.montant = montant;
        this.paye=paye;
        this.date=date;
        this.typePanier=type;
        this.nombrePanier=nombre;
    }


    public Commande(Integer id, Integer montant, Integer paye, String nom, String prenom) {
        this.id = id;
        this.montant = montant;
        this.paye=paye;
        this.nomClient = nom;
        this.prenomClient=prenom;
    }

    public Commande(Integer id, Integer montant, Integer paye, String nom, String prenom, Date date) {
        this.id = id;
        this.montant = montant;
        this.paye=paye;
        this.nomClient = nom;
        this.prenomClient=prenom;
        this.date=date;
    }

    public String getTypePanier() {
        return typePanier;
    }

    public void setTypePanier(String typePanier) {
        this.typePanier = typePanier;
    }

    public Integer getNombrePanier() {
        return nombrePanier;
    }

    public void setNombrePanier(Integer nombrePanier) {
        this.nombrePanier = nombrePanier;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMontant() {
        return montant;
    }



    public Integer getPaye() {
        return paye;
    }

    public void setPaye(Integer paye) {
        this.paye = paye;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }


    public Date getDate() {
        return date;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }


}
