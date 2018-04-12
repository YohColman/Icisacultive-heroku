/**
 * Dao gérant toutes les opérations sur les commandes
 */

package icisacultive.devweb.projet.dao.impl;


import icisacultive.devweb.projet.dao.CommandeDao;
import icisacultive.devweb.projet.entities.Commande;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CommandeDaoImpl implements CommandeDao{

    @Override
    public List<Commande> listCommandes() {

        String query = "SELECT commande.idcommande, commande.montant, commande.paye, commande.date, utilisateur.nom, utilisateur.prenom FROM commande INNER JOIN utilisateur ON commande.idutilisateur = utilisateur.idutilisateur ORDER BY commande.date DESC";
        List<Commande> listOfCommandes = new ArrayList<>();
        try (
                Connection connection = icisacultive.devweb.projet.dao.impl.DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                listOfCommandes.add(new Commande(resultSet.getInt("idcommande"), resultSet.getInt("montant"), resultSet.getInt("paye"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getDate("date")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfCommandes;

    }

    @Override
    public List<Commande> listCommandesByUser(Integer idUser) {
        String query = "SELECT * FROM commande INNER JOIN lot ON commande.idlot=lot.idlot INNER JOIN panier ON lot.idpanier=panier.idpanier WHERE idutilisateur=? ORDER BY date DESC";
        List<Commande> lstCommandeByUser = new ArrayList<>();

        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ){
            statement.setInt(1, idUser);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    lstCommandeByUser.add(new Commande(resultSet.getInt("idcommande"), resultSet.getInt("montant"),resultSet.getInt("paye")
                            ,resultSet.getDate("date"), resultSet.getString("typepanier"), resultSet.getInt("nombrepanier")));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lstCommandeByUser;
    }

    @Override
    public void paymentDone(Integer idCommande) {

        System.out.println("ref");
        String query = "UPDATE commande SET paye=1 WHERE idcommande=?;";
        try(Connection connection = icisacultive.devweb.projet.dao.impl.DataSourceProvider.getDataSource().getConnection();
            java.sql.PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setInt(1, idCommande);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void passerCommande(Integer montant, Integer idUtilisateur,Integer idLot) {
        String query = "INSERT INTO commande(montant, date, paye, idutilisateur, idlot) VALUES(?, now(), 0, ?, ?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, montant);
            statement.setInt(2, idUtilisateur);
            statement.setInt(3, idLot);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
