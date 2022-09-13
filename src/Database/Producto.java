/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerar
 */
public class Producto {

    private String codigoProducto, nombre;
    private int cantidad;
    private Connection conexion = null;

    public Producto(String codigoProducto, String nombre, int cantidad, Connection conexion) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.conexion = conexion;
    }

    public void insertProducts() throws SQLException {
      

        String sql = "INSERT INTO productos(codigoProducto,nombreproducto,cantidad)VALUES (?,?,?)";
        PreparedStatement preparedStmt = conexion.prepareStatement(sql);

        preparedStmt.setString(1, getCodigoProducto());
        preparedStmt.setString(2, getNombre());
        preparedStmt.setString(3,getCantidad().toString());

         boolean registro = preparedStmt.execute();

        if (!preparedStmt.getMoreResults()) {
            JOptionPane.showMessageDialog(null,"Se agrego correctamente los productos");
            
        }

         conexion.close();
preparedStmt.close();
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Connection getConexion() {
        return conexion;
    }

}
