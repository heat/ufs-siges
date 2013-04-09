package br.ufs.escala.businesslogic;

import br.ufs.escala.businesslogic.admin.AuthBL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BusinessLogicFactory {
    private static BusinessLogicFactory instance;

    private BusinessLogicFactory() {
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {

        }
        String url =
                "jdbc:mysql://localhost:3306/mysql";

        Connection conn =
                DriverManager.getConnection(
                        url, "root", "");
        return conn;
    }

    public static BusinessLogicFactory getInstance() {
        if (instance == null) {
            instance = new BusinessLogicFactory();
        }
        return instance;
    }

    public AuthBL getAuthBL() {
        try {
            return new AuthBL(
                    getConnection());
        } catch (SQLException exception) {
            return null;
        }
    }
}
