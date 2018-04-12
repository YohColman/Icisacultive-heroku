/**
 * Dao gérant les lots de paniers
 */

package icisacultive.devweb.projet.dao.impl;

import icisacultive.devweb.projet.dao.LotPanierDao;
import icisacultive.devweb.projet.entities.LotPanier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LotPanierDaoImpl implements LotPanierDao {
    @Override
    public List<LotPanier> listLotPanierByIdPanier(Integer id) {
        String query = "SELECT * FROM lot WHERE idpanier=? ORDER BY nombrepanier";
        List<LotPanier> lstLotPanier = new ArrayList<>();

        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ){
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    lstLotPanier.add(new LotPanier(resultSet.getInt("idlot"), resultSet.getInt("prix"),resultSet.getInt("nombrepanier")
                            ,resultSet.getInt("idpanier")));
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lstLotPanier;
    }

    @Override
    public LotPanier getLotPanierById(Integer id) {
        String query = "SELECT * FROM lot INNER JOIN panier ON lot.idpanier=panier.idpanier WHERE lot.idlot=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return new LotPanier(
                            resultSet.getInt("idlot"),
                            resultSet.getInt("prix"),
                            resultSet.getInt("nombrepanier"),
                            resultSet.getInt("idpanier"),
                            resultSet.getString("typepanier")

                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getMontantLotById(Integer id) {
        String query = "SELECT * FROM lot WHERE idlot=?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return resultSet.getInt("prix");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
