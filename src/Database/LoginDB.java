/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import UI.Inicio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gerar
 */
public class LoginDB {



    public static boolean validateUserName(String username, String password, Connection cn) throws SQLException {
        boolean existsUser = false;
        Statement st = cn.createStatement();
        String usuario,clave;
        String sql = "SELECT username,password FROM login";
        ResultSet result = st.executeQuery(sql);

        while (result.next()) {
             usuario = result.getString("username");
             clave = result.getString("password");

            if (usuario.equals(username) && clave.equals(password))
                  existsUser = true;
              
}

    
        result.close();
        st.close();
        cn.close();
        return existsUser;
    }

}
