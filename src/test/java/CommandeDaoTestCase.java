import icisacultive.devweb.projet.dao.CommandeDao;
import icisacultive.devweb.projet.dao.impl.CommandeDaoImpl;
import icisacultive.devweb.projet.dao.impl.DataSourceProvider;
import icisacultive.devweb.projet.entities.Commande;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class CommandeDaoTestCase {
    private CommandeDao commandeDao = new CommandeDaoImpl();


    @Before
    public void initDb() throws Exception {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM commande WHERE idcommande=5 ");
            stmt.executeUpdate("INSERT INTO commande(idcommande, date, montant, paye, idutilisateur, idlot) VALUES (5, 08/05/2018, 24, 0, 1,1);");
        }
    }

    @Test
    public void shouldListCommandes() {
        List<Commande> listeCommandes= commandeDao.listCommandes();

        assertThat(listeCommandes).hasSize(4);
        assertThat(listeCommandes).extracting("id", "montant","paye", "nomClient", "prenomClient").containsOnly(
                tuple(1, 24, 1, "Cena", "John" ),
                tuple(2, 24, 0, "Orton", "Randy" ),
                tuple(3, 24, 0, "Trump", "Donald" ),
                tuple(4, 24, 1, "Cena", "John" ));
    }

    @Test
    public void shouldPaymentDone() {

        commandeDao.paymentDone(5);

        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM commmande WHERE idcommande =5 ")) {
                assertThat(rs.next()).isTrue();
                assertThat(rs.getInt("paye")).isEqualTo(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldPasserCommande() {
    }
}