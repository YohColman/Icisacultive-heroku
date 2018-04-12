package icisacultive.devweb.projet.entities;

public class Utilisateur {

    private Integer id;
    private String nom;
    private String prenom;
    private Integer telephone;
    private String mail;
    private String motdepasse;
    private Integer admin;

    public Utilisateur(Integer id, String nom, String prenom, Integer telephone, String mail, String motdepasse, Integer admin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.motdepasse = motdepasse;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        if (this.admin == 1) {
            return true;
        } else {
            return false;
        }
    }
}
