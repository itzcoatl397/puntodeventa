/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    public Producto() {
    }

    public Producto(Connection conn) {
       this.conexion = conn;
    }

    public void insertProducts() throws SQLException {

        String sql = "INSERT INTO productos(codigoProducto,nombreproducto,cantidad)VALUES (?,?,?)";
        PreparedStatement preparedStmt = conexion.prepareStatement(sql);

        preparedStmt.setString(1, getCodigoProducto());
        preparedStmt.setString(2, getNombre());
        preparedStmt.setString(3, getCantidad().toString());

        boolean registro = preparedStmt.execute();

        if (!preparedStmt.getMoreResults()) {
            JOptionPane.showMessageDialog(null, "Se agrego correctamente los productos");

        }

    }

    public void mostrarProductos(JTable datos) throws SQLException {
        String codigoProducto, nombreProducto, cantidad;
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet rst = null;
        PreparedStatement ps = null;
        ResultSetMetaData rsMd;

        try {

            datos.setModel(modelo);

            String sql = "SELECT codigoProducto,nombreproducto,cantidad FROM productos";
            ps = conexion.prepareStatement(sql);
            rst = ps.executeQuery();
            rsMd = rst.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();// obtebnemos las columnos

            modelo.addColumn("Codigo Producto");
           
            modelo.addColumn("Nombre Producto");
            modelo.addColumn("Cantidad Producto");
            while (rst.next()) {
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    filas[i] = rst.getObject(i + 1);

                }
                modelo.addRow(filas);

            }

        } catch (Exception e) {
            System.out.println(e.toString());

        }

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

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

}
