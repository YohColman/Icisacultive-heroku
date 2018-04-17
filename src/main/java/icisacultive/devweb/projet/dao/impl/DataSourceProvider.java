/**
 * Classe indiquant la source pour la BDD
 */

package icisacultive.devweb.projet.dao.impl;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {

    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setServerName("dz8959rne9lumkkw.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("ara3e26dgj2jtpf4");
            dataSource.setUser("fqybdkksyu1nmms9");
            dataSource.setPassword("wa9x1xgwqbo3basj");
        }
        return dataSource;
    }
}