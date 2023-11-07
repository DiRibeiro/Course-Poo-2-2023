package fix3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class TitlesDAO {
    public Titles readTitle(int isbn) {
        try {
            Connection conn = ConnectSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM titles WHERE ISBN=?");
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String title = rs.getString(2);
                int edition = rs.getInt(3);
                String copyright = rs.getString(4);
                Titles t = new Titles(isbn, title, edition, copyright);
                return t;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TitlesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } // ok
    public ArrayList<Titles> listTitles(){
        ArrayList<Titles> myListTitles = new ArrayList<Titles>();

        try{
            Connection conn = ConnectSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM titles");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int isbn = rs.getInt(1);
                String title = rs.getString(2);
                int edition = rs.getInt(3);
                String copyright = rs.getString(4);
                Titles t = new Titles(isbn, title, edition, copyright);
                myListTitles.add(t);
            }
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(TitlesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myListTitles;
    }
    public int insertTitles(Titles T) {
        try {
            Scanner teclado = new Scanner(System.in);
            Connection conn = ConnectSQL.getConexaoMySQL();

            System.out.println("Digite o nome do livro: ");
            String title = teclado.next();
            System.out.println("Digite o número da edição: ");
            int edition = teclado.nextInt();
            System.out.println("Digite o nome da editora: ");
            String copyright = teclado.next();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO titles(title, editionNumber, copyright) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.setInt(2, edition);
            ps.setString(3, copyright);

            int retorno = ps.executeUpdate();
            conn.close();
            return retorno;

        } catch (SQLException ex) {
            Logger.getLogger(TitlesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // inserção falhou
    } // ok
    public static int updateTitles(Titles t) {
        try{
            Connection conn = ConnectSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE titles SET title=?, editionNumber=?, copyright=? WHERE ISBN=?");
            ps.setString(1, t.getTitle());
            ps.setInt(2, t.getEditionNumber());
            ps.setString(3, t.getCopyright());
            ps.setInt(4, t.getISBN());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(TitlesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int deleteTitles(int isbn) {
        try{
            Connection conn = ConnectSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM titles WHERE ISBN=?");
            ps.setInt(1, isbn);

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(TitlesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
