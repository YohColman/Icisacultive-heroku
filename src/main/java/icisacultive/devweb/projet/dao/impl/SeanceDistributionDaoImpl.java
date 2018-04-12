package icisacultive.devweb.projet.dao.impl;

import icisacultive.devweb.projet.dao.SeanceDistributionDao;
import icisacultive.devweb.projet.entities.SeanceDistribution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDistributionDaoImpl implements SeanceDistributionDao {
    @Override
    public List<SeanceDistribution> listSeanceDistrib() {
        String query = "SELECT * FROM seancedistribution ORDER BY dateseance DESC";
        List<SeanceDistribution> listOfSeanceDistribution = new ArrayList<>();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                listOfSeanceDistribution.add(new SeanceDistribution(resultSet.getString("dateseance")) );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfSeanceDistribution;
    }

    @Override
    public void ajouterSeanceDistrib(String date) {
        String query = "INSERT INTO seancedistribution(dateseance) VALUES(?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
