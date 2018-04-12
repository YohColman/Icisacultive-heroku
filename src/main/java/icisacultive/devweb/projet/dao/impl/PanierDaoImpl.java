/**
 * Dao gérant les paniers (petit format, ...)
 */

package icisacultive.devweb.projet.dao.impl;

import icisacultive.devweb.projet.dao.PanierDao;
import icisacultive.devweb.projet.entities.Panier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PanierDaoImpl implements PanierDao{


    @Override
    public List<Panier> listPanier() {

        String query = "SELECT * FROM panier ORDER BY idpanier";
        List<Panier> listOfPanier = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
            ) {
            while (resultSet.next()) {
                listOfPanier.add(new Panier(resultSet.getInt("idpanier"), resultSet.getString("typepanier")));
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listOfPanier;
    }

    @Override
    public Panier getPanier(Integer id) {
        return null;
    }
}
