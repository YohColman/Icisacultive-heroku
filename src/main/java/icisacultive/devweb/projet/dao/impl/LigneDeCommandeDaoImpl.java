package icisacultive.devweb.projet.dao.impl;

import icisacultive.devweb.projet.dao.LigneDeCommandeDao;
import icisacultive.devweb.projet.entities.LigneDeCommande;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LigneDeCommandeDaoImpl implements LigneDeCommandeDao {
    @Override
    public List<LigneDeCommande> listLigneDeCommande() {
        String query = "SELECT * FROM lignedecommande";
        List<LigneDeCommande> listOfLigneDeCommande = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                listOfLigneDeCommande.add(new LigneDeCommande(resultSet.getInt("idlignedecommande"), resultSet.getInt("receptionne"), resultSet.getInt("idcommande"), resultSet.getDate("date")) );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfLigneDeCommande;
    }

    @Override
    public List<LigneDeCommande> listLigneDeCommandeByDate(String date) {
        String query = "SELECT * FROM lignedecommande INNER JOIN commande ON lignedecommande.idcommande=commande.idcommande INNER JOIN lot ON lot.idlot=commande.idlot INNER JOIN panier ON panier.idpanier=lot.idpanier INNER JOIN utilisateur ON commande.idutilisateur=utilisateur.idutilisateur WHERE lignedecommande.date=?";
        List<LigneDeCommande> lstLigneDeCommandeByUserByCommande = new ArrayList<>();

        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ){
            statement.setString(1, date);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    lstLigneDeCommandeByUserByCommande.add(new LigneDeCommande(resultSet.getInt("idlignedecommande"), resultSet.getInt("receptionne"), resultSet.getInt("idcommande"), resultSet.getDate("date"), resultSet.getString("typepanier"), resultSet.getString("nom"), resultSet.getString("prenom")));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lstLigneDeCommandeByUserByCommande;
    }

    @Override
    public List<LigneDeCommande> listLigneDeCommandeByUser(Integer idCommande) {
        String query = "SELECT * FROM lignedecommande INNER JOIN commande ON lignedecommande.idcommande=commande.idcommande INNER JOIN lot ON lot.idlot=commande.idlot INNER JOIN panier ON panier.idpanier=lot.idpanier WHERE commande.idcommande=?";
        List<LigneDeCommande> lstLigneDeCommandeByUserByCommande = new ArrayList<>();

        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ){
            statement.setInt(1, idCommande);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    lstLigneDeCommandeByUserByCommande.add(new LigneDeCommande(resultSet.getInt("idlignedecommande"), resultSet.getInt("receptionne"), resultSet.getInt("idcommande"), resultSet.getDate("date"), resultSet.getString("typepanier")));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lstLigneDeCommandeByUserByCommande;
    }

    @Override
    public LigneDeCommandeDao getLigneDeCommande(Integer id) {
        return null;
    }

    @Override
    public void ajouterLigneDeCommande(Integer idCommande) {
        String query = "INSERT INTO lignedecommande(idcommande) VALUES(?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idCommande);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getNombreDePanierCommande(Integer idCommande) {
        String query = "SELECT * FROM commande INNER JOIN lot ON lot.idlot=commande.idlot INNER JOIN panier ON lot.idpanier=panier.idpanier WHERE commande.idcommande=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idCommande);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return resultSet.getInt("nombrepanier");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void choisirDateLigneDeCommande(Integer idLigneDeCommande, String date) {
        String query = "UPDATE lignedecommande SET date='"+date+"' WHERE idlignedecommande=?;";
        try(Connection connection = icisacultive.devweb.projet.dao.impl.DataSourceProvider.getDataSource().getConnection();
            java.sql.PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setInt(1, idLigneDeCommande);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changerStatutLigneDeCommande(Integer idLigneDeCommande) {
        String query = "UPDATE lignedecommande SET receptionne=1 WHERE idlignedecommande=?;";
        try(Connection connection = icisacultive.devweb.projet.dao.impl.DataSourceProvider.getDataSource().getConnection();
            java.sql.PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setInt(1, idLigneDeCommande);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
