/**
 * Dao gérant les utilisateurs
 */

package icisacultive.devweb.projet.dao.impl;

import icisacultive.devweb.projet.dao.UtilisateurDao;
import icisacultive.devweb.projet.entities.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao {
    @Override
    public List<Utilisateur> listerUtilisateurs() {
        String query = "SELECT * FROM utilisateur ORDER BY idutilisateur";
        List<Utilisateur> lstUtilisateur = new ArrayList<>();

        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ){
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    lstUtilisateur.add(new Utilisateur(resultSet.getInt("idutilisateur"), resultSet.getString("nom"),resultSet.getString("prenom")
                            ,resultSet.getInt("telephone"), resultSet.getString("mail"), resultSet.getString("motdepasse")
                            ,resultSet.getInt("admin")));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lstUtilisateur;
    }

    @Override
    public Utilisateur getUtilisateur(Long id) {
        return null;
    }

    @Override
    public Utilisateur getUtilisateur(String identifiant) {
        Utilisateur utilisateur = null;
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE mail=?");
            stmt.setString(1, identifiant);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                utilisateur = new Utilisateur(resultSet.getInt("idutilisateur"), resultSet.getString("nom"),resultSet.getString("prenom")
                        ,resultSet.getInt("telephone"), resultSet.getString("mail"), resultSet.getString("motdepasse")
                        ,resultSet.getInt("admin"));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Problème dans la récupération de l'utilisateur");
        }

        if (utilisateur==null){
            System.out.println("Pas d'utilisateur récupéré");
        } else {
            System.out.println("Un utilisateur a été récupéré");
        }

        return utilisateur;
    }

    @Override
    public String getMotDePasseUtilisateur(String identifiant) {
        String motDePasse = null;
        try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("SELECT motdepasse FROM utilisateur WHERE mail=?");
            stmt.setString(1, identifiant);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                motDePasse = results.getString("motdepasse");
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Problème dans la récupération de mot de passe de l'utilisateur");
        }

        return motDePasse;
    }

    @Override
    public void addUtilisateur(String nom, String prenom, Integer telephone, String mail, String motDePasse) {
        String query = "INSERT INTO utilisateur(nom, prenom, telephone, mail, motdepasse) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setInt(3, telephone);
            statement.setString(4, mail);
            statement.setString(5, motDePasse);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ADDUTILISATEUR UTILISATEURDAOIMPL Echec de l'ajout d'un nouvel utilisateur");
            e.printStackTrace();
        }
    }
}
