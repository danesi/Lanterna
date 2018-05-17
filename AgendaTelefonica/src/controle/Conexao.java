/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

/**
 * 
 * CREATE TABLE contatos(
Codigo serial primary key,
NomeContato varchar(50),
FoneCelular varchar(16),
FoneFixo varchar(16)
)
 */

/**
 *
 * @author Boemo
 */
import java.sql.*;

public class Conexao {
  public static Connection AbrirConexao(){
  Connection con=null;
  try{
  
    Class.forName("org.postgresql.Driver").newInstance();
    String URL="jdbc:postgresql://localhost:5433/agenda";
    String usuario="postgres";
    String senha="ciet";
    con=DriverManager.getConnection(URL,usuario,senha);
    System.out.println("Conexão aberta");
  }catch(SQLException e){
  System.out.println("Erro de Conexão"+e.getMessage());
  }catch(ClassNotFoundException e1){
      System.out.println("Erro Classe"+e1.getMessage());
  }catch(Exception e2){
      System.out.println("Erro Exception"+e2.getMessage());
  }  
  
  return con;
  }
  public static void  fechaconexao(Connection con) throws SQLException{
        con.close();
  
  }
  
}
