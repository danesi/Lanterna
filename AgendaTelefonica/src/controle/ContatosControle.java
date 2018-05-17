/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

/**
 *
 * @author boemo
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Contato;

/**
 *
 * @author boemo
 */
public class ContatosControle {
    private Connection con;

    public ContatosControle(Connection con) {
        this.con = con;
    }
    
    public String InserirContato(Contato cont){
    
    String SQL = "insert into contatos(codigo, nomecontato, fonecelular, fonefixo) "
            + "values(Default,?,?,?)";
    try{
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.setString(1, cont.getNomeContato());
        ps.setString(2, cont.getNumCelular());
        ps.setString(3, cont.getNumFixo());
        //ps.executeUpdate();//podemos retirar este aqui.
        if(ps.executeUpdate()>0){
        return "Inclusão de novo contato realizada com sucesso";
        }else{
        return "Erro ao tentar incluir novo contato";
        }
    
    }catch(SQLException e){
        return e.getMessage();
    }

    }
    public String AlterarContato (Contato cont){
    String SQL = "UPDATE contatos SET nomecontato=?, fonecelular=?, fonefixo=? WHERE codigo =?";
    try{
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.setString(1, cont.getNomeContato());
        ps.setString(2, cont.getNumCelular());
        ps.setString(3, cont.getNumFixo());
        ps.setInt(4, cont.getCodigoContato());
        ps.executeUpdate();//podemos retirar este aqui.
        if(ps.executeUpdate()>0){
        return "Inclusão de novo contato realizada com sucesso";
        }else{
        return "Erro ao tentar incluir novo contato";
        }
    
    }catch(SQLException e){
        return e.getMessage();
    }
    }    
    public String ExcluirContato (String codigo){

    String SQL = "delete from contatos where codigo="+codigo;
    try{
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.executeUpdate();//podemos retirar este aqui.
       
        return "Exclusão do contato realizada com sucesso";
       
        
    
    }catch(SQLException e){
        return e.getMessage();
    }
    }
    public Contato consultaContato(int cod){
         String SQL="Select * from contatos where codigo ="+cod;
          Contato cont =new Contato();
         try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs= ps.executeQuery(); 
            if(rs !=null){
            while(rs.next()){
           
            cont.setCodigoContato(rs.getInt("codigo"));
            cont.setNomeContato(rs.getString("nomecontato"));
            cont.setNumCelular(rs.getString("fonecelular"));
            cont.setNumFixo(rs.getString("fonefixo"));
              }
            }
            
            return cont;
        } catch (SQLException e) {
            return null;
        }
    
    }
    public List<Contato> consultaContatoporNome(String nome){
       String SQL="Select * from contatos where nomecontato like '"+nome+"%'";
       List<Contato> listafunc = new ArrayList<Contato>();
       try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs= ps.executeQuery(); 
            if(rs !=null){
            while(rs.next()){
            Contato cont =new Contato();
            cont.setCodigoContato(rs.getInt("codigo"));
            cont.setNomeContato(rs.getString("nomecontato"));
            cont.setNumCelular(rs.getString("fonecelular"));
            cont.setNumFixo(rs.getString("fonefixo"));
           
            
            listafunc.add(cont);
            }
            }
            return listafunc;
        } catch (SQLException e) {
            return null;
        }
    }   
    
    public List<Contato> listarTodosContatos() {
        String SQL="Select * from contatos order by codigo";
        List<Contato> listafunc = new ArrayList<Contato>();
       try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs= ps.executeQuery(); 
            if(rs !=null){
            while(rs.next()){
            Contato cont =new Contato();
            cont.setCodigoContato(rs.getInt("codigo"));
            cont.setNomeContato(rs.getString("nomecontato"));
            cont.setNumCelular(rs.getString("fonecelular"));
            cont.setNumFixo(rs.getString("fonefixo"));
            
            
            listafunc.add(cont);
            }
            }
            return listafunc;
        } catch (SQLException e) {
            return null;
        }
    }
    public int NumeroTotalRegistros() {
        String SQL = "Select count(*) from contatos";
        int numt = 0;
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    numt = rs.getInt(1);
                }
            }
            return numt;
        } catch (SQLException e) {
            System.out.println("" + e);
            return 0;
        }
    }      
        
    
}