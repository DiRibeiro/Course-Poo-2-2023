package fix3;

import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.*;

public class AuthorDAO {

    public Author read(int id) {
        try {
            Connection conn = ConnectSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM authors WHERE authorsID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Author a = new Author(id, firstName, lastName);
                return a;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    public ArrayList<Author> list(){
        ArrayList<Author> myList = new ArrayList<Author>();

        try{
            Connection conn = ConnectSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM authors");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Author a = new Author(id, firstName, lastName);
                myList.add(a);
            }
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }
    
    public int insert(Author A) {
        try {
            Scanner teclado = new Scanner(System.in);
            Connection conn = ConnectSQL.getConexaoMySQL();

            System.out.println("Digite o nome: ");
            String firstName = teclado.next();
            System.out.println("Digite o sobrenome: ");
            String lastName = teclado.next();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO authors(firstName, lastName) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);

            int retorno = ps.executeUpdate();
            conn.close();
            return retorno;

        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; 
    } 
    
    public static int update(Author a) {
        try{
            Connection conn = ConnectSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE authors SET firstName=?, lastName=? WHERE authorsID=?");
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setInt(3, a.getPeopleID());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int delete(int id) {
        try{
            Connection conn = ConnectSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM authors WHERE authorsID=?");
            ps.setInt(1, id);

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
