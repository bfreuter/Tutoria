/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoria.acceso.bd;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import tutoria.gui.*;

/**
 *
 * -gui -agents
 * T-JuanPerez:tutoria.Tutor;T-MariaLopez:tutoria.Tutor;T-MariahCarey:tutoria.Tutor;T-JimCarrey:tutoria.Tutor;T-MatDemmon:tutoria.Tutor;T-WillGraham:tutoria.Tutor;A-JuanPerez:tutoria.Alumno;A-MariaLopez:tutoria.Alumno;A-MariahCarey:tutoria.Alumno;A-JimCarrey:tutoria.Alumno
 */
public class Base {

    public static Connection GetConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/Simulacion";
            String usuarioDB = "root";
            String passwordDB = "root";
            conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return conexion;
        }
    }

    private static int GetDNIAlumno(String nombre) {
        int DNI = 0;
        Connection cnn;
        cnn = Base.GetConnection();
        ResultSet rs = null;
        Statement cmd = null;
        try {
            cmd = cnn.createStatement();
            rs = cmd.executeQuery("SELECT Alumnos_DNI FROM alumnos WHERE Alumnos_nombre = '" + nombre + "'");
            while (rs.next()) {
                DNI = Integer.parseInt(rs.getString("Alumnos_DNI"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjetosAprendizaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DNI;
    }

    private static int GetIdTema(String descripcion) {
        int idTema = 0;
        Connection cnn;
        cnn = Base.GetConnection();
        ResultSet rs = null;
        Statement cmd = null;
        try {
            cmd = cnn.createStatement();
            rs = cmd.executeQuery("SELECT Temas_id FROM temas WHERE Temas_descripcion  = '" + descripcion + "'");
            while (rs.next()) {
                idTema = Integer.parseInt(rs.getString("Temas_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObjetosAprendizaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idTema;
    }

    public void InsertarLog(String Tema, String Alumno) {

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        Connection cnn;
        cnn = Base.GetConnection();

        int DNI = Base.GetDNIAlumno(Alumno);
        int idTema = Base.GetIdTema(Tema);

        // the mysql insert statement
        String query = "INSERT INTO logs (Alumnos_DNI, Temas_id, Logs_fechaHora)"
                + " VALUES (?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt;
        try {
            preparedStmt = cnn.prepareStatement(query);
            preparedStmt.setInt(1, DNI);
            preparedStmt.setInt(2, idTema);
            preparedStmt.setDate(3, startDate);
            // execute the preparedstatement
            preparedStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ObjetosAprendizaje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet ObtenerAlumnos() {
        Connection cnn;
        cnn = Base.GetConnection();
        ResultSet rs = null;
        Statement cmd = null;
        if (cnn != null) {
            try {
                cmd = cnn.createStatement();
                rs = cmd.executeQuery("SELECT Alumnos_nombre FROM alumnos;");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return rs;
    }
    
    
        public ResultSet ObtenerProfesores() {
        Connection cnn;
        cnn = Base.GetConnection();
        ResultSet rs = null;
        Statement cmd = null;
        if (cnn != null) {
            try {
                cmd = cnn.createStatement();
                rs = cmd.executeQuery("SELECT Profesores_nombre FROM profesores;");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return rs;
    }
        
        public ResultSet ObtenerTemasTutoria(String Nombre) {
        Connection cnn;
        cnn = Base.GetConnection();
        ResultSet rs = null;
        Statement cmd = null;
        if (cnn != null) {
            try {
                cmd = cnn.createStatement();
                rs = cmd.executeQuery("SELECT Conocimiento_nivel, temas.Temas_id, Temas_descripcion FROM conocimiento INNER JOIN alumnos ON conocimiento.Alumnos_id  = alumnos.Alumnos_id INNER JOIN temas ON conocimiento.Temas_id = temas.Temas_id WHERE conocimiento.Conocimiento_nivel LIKE '%APROBADO%' AND alumnos.Alumnos_agente = '"+Nombre+"'");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return rs;
    }    
        
        public String QuitarEspacios(String dato){
    
        dato = dato.trim();
        dato = dato.replaceAll(" ", "");
        return dato;
    }    

}
