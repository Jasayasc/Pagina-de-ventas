
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado validar(String user, String pass) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Pass=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
            System.out.println("Devuelve un empleado de manera exitosa");
        }
        catch (Exception e) {
            
        }
        return em;
    }
    //Operaciones del crud
    
     public List listar() {
        String sql = "select * from empleado";
        ArrayList<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
            System.out.println("Consulta de manera exitosa");
        } catch(Exception e) {
            
        }
        return lista;
    }
    public void agregar (Empleado em) {
        String sql="insert into empleado(Dni, Nombres, Telefono, Estado, User, Pass)values(?,?,?,?,?,?)";
        
        try {
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,em.getDni());
            ps.setString(2,em.getNom());
            ps.setString(3,em.getTel());
            ps.setString(4,em.getEstado());
            ps.setString(5,em.getUser());
            ps.setString(6,em.getPass());
            ps.executeUpdate();
            System.out.println("Insertó de manera exitosa");
        } catch(Exception e) {
            
        }
        //return r;
    }
    
    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
            System.out.println("Lista el empleado id manera exitosa");
        } catch(Exception e) {
            
        }
        return emp;
        
    }
    
    public void actualizar (Empleado em) {
        String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        System.out.println("Preparando sentencia update");
        try {
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,em.getDni());
            ps.setString(2,em.getNom());
            ps.setString(3,em.getTel());
            ps.setString(4,em.getEstado());
            ps.setString(5,em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
            System.out.println("Actualiza de manera exitosa");
        } catch(Exception e) {
            
        }
        //return r;
    }
    public void delete (int id) {
        String sql="delete from empleado where IdEmpleado="+id;
        try {
            con = cn.Conexion();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Elimina de manera exitosa");
        }
        catch (Exception e) {
            
        }
    }
}
