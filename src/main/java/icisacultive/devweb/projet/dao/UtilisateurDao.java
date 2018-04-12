package icisacultive.devweb.projet.dao;

import icisacultive.devweb.projet.entities.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    List<Utilisateur> listerUtilisateurs();

    Utilisateur getUtilisateur(Long id);

    Utilisateur getUtilisateur(String mail);

    String getMotDePasseUtilisateur(String identifiant);

    void addUtilisateur(String nom, String prenom, Integer telephone, String mail, String motDePasse);


}
