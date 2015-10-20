/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria.acceso.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;


/**
 *
 * @author gaby
 */
public class AccesoLog {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }

    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost/simulacion",
                "root", "root");
    }

    private void closeConnection(Connection connection) {

        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }
   /*1 
    public int leerLogsOA() {
        int numeroAccesos = 0;
    */
    public HashMap<String, Integer> leerLogsOA() {        
        HashMap<String, Integer> logsOA = new HashMap();
        
        Connection connection = null;
        /* 1
        String sql = "SELECT count(Alumnos_DNI) AS Numero_accesos FROM "
                + "logs WHERE Alumnos_DNI = 38098764 AND Temas_id = 5 "
                + "AND Logs_fechaHora >= '" + leerUltimoAcceso() + "'";
        */
        
        String sql = "SELECT Temas_id, count(Alumnos_DNI) AS Numero_accesos FROM "
                + "logs WHERE Alumnos_DNI = 38098764 AND Logs_fechaHora >= '" 
                + leerUltimoAcceso() + "' GROUP BY Temas_id HAVING Numero_accesos >= 5";
      //  System.out.println(sql);
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            /* 1
            while (resultSet.next()) {
                numeroAccesos = resultSet.getInt("Numero_accesos");
            }
            */
                while (resultSet.next()) {
                logsOA.put("TEMA", resultSet.getInt("Temas_id"));
            }
           // actualizarUltimoAcceso();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        /* 1
        return numeroAccesos;
        */
        return logsOA;
        
    }
    
    private String leerUltimoAcceso(){
        Connection connection = null;
        String sql = "SELECT config_valor FROM config WHERE config_descripcion='ultimoAcceso'";
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("config_valor");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return "";
    }
    
    public void actualizarUltimoAcceso(){
        SimpleDateFormat mySQLDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Connection connection = null;
        String sql = "UPDATE config SET config_valor = '" 
                + mySQLDateTime.format(new Date()) + 
                "' WHERE config_descripcion='ultimoAcceso'";
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }
}
