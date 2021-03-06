/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cancela.dados;

import cancela.negocio.Codigo;
import cancela.negocio.CodigoSimples;
import cancela.negocio.Ticket;
import cancela.services.Calculo;
import cancela.services.CalculoSimples;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author italo
 */
public class CancelaDAOJavaDb implements CancelaDAO{

    public CancelaDAOInstace ref;
    
    public CancelaDAOJavaDb() throws CancelaDAOException{
        ref = CancelaDAOInstace.getInstance();
    } 
    
    
    @Override
    public boolean adicionar(Ticket p) throws CancelaDAOException {
        try {
            
            Connection con = ref.getConnection();
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO ticket (CODIGO, DATA,STATUS) VALUES (?,?,?)");
            
            stmt.setString(1, p.getCodigo().toString());
            
            Timestamp data = new Timestamp(p.getDate().getTimeInMillis());
            
            stmt.setString(2, data.toString());
            
            stmt.setInt(3, p.getStatus());
            
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao adicionar.", ex);
        }
    }

    @Override
    public Ticket getTicketPorCodigo(Codigo n) throws CancelaDAOException {
        try {
            Connection con = ref.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT * FROM ticket WHERE CODIGO=?"
                    );
            stmt.setString(1, n.toString());
            ResultSet resultado = stmt.executeQuery();
            Ticket p = null;
            if(resultado.next()) {
                Timestamp tm = resultado.getTimestamp("DATA");
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTimeInMillis(tm.getTime());
                int status = resultado.getInt("STATUS");
                p = new Ticket(n, cal,status);
            }
            stmt.close();
            return p;
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao buscar.", ex);
        }
    }
    
    @Override
    public List<Ticket> getTodos() throws CancelaDAOException {
        try {
            Connection con = ref.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM ticket");
            List<Ticket> lista = new ArrayList<Ticket>();
            while(resultado.next()) {
                Timestamp tm = resultado.getTimestamp("DATA");
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTimeInMillis(tm.getTime());
                Codigo cod = new CodigoSimples(resultado.getString("CODIGO"));
                int status = resultado.getInt("STATUS");
                Ticket p = new Ticket(cod, cal,status);
                lista.add(p);
            }
            stmt.close();
            return lista;
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao buscar.", ex);
        }    
    }

    @Override
    public boolean validaTicket(Codigo c) throws CancelaDAOException {
      try {
           Calculo cs = new CalculoSimples();
           Connection con = ref.getConnection();
           PreparedStatement stmt = con.prepareStatement(
                  "SELECT STATUS FROM Ticket "
                   + " WHERE CODIGO = ?"
                   );
            stmt.setString(1, c.getCodigo());
            ResultSet resultado = stmt.executeQuery();
            boolean valida = false;
            if(resultado.next()) {
                if(resultado.getInt("STATUS")!= 1)
                    valida = true;
            }
           stmt.close();
           return valida;
       }
       catch(SQLException ex) { 
           throw new CancelaDAOException("Falha ao liberar ticket.", ex);
       }
    }  
     @Override
    public List<Ticket> getTodosExtraviados() throws CancelaDAOException {
        try {
            Connection con = ref.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM ticket where STATUS in (SELECT STATUS FROM status where DESCRICAO = \'Extraviado\')");
            List<Ticket> lista = new ArrayList<Ticket>();
            while(resultado.next()) {
                Codigo cod = new CodigoSimples(resultado.getString("CODIGO"));
                Timestamp tm = resultado.getTimestamp("DATA");
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTimeInMillis(tm.getTime());
                int status = resultado.getInt("STATUS");
                Ticket p = new Ticket(cod, cal,status);
                lista.add(p);
            }
            stmt.close();
            con.close();
            return lista;
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao buscar.", ex);
        }   
    }

    @Override
    public List<Ticket> getTodosNaoPagos() throws CancelaDAOException {
        try {
            Connection con = ref.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM ticket where STATUS in (SELECT STATUS FROM status where DESCRICAO = \'Nao pago\')");
            List<Ticket> lista = new ArrayList<Ticket>();
            while(resultado.next()) {
                Codigo cod = new CodigoSimples(resultado.getString("CODIGO"));
                Timestamp tm = resultado.getTimestamp("DATA");
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTimeInMillis(tm.getTime());
                int status = resultado.getInt("STATUS");
                Ticket p = new Ticket(cod, cal,status);
                lista.add(p);
            }
            stmt.close();
            return lista;
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao buscar.", ex);
        }       
    }

    @Override
    public void liberaTicket(Codigo codigo, double valorPago) throws CancelaDAOException {
       try {
            Connection con = ref.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                  "UPDATE TICKET SET PRECO = ?, STATUS = 2 WHERE CODIGO = ?");
            stmt.setDouble(1, valorPago);
            stmt.setString(2, codigo.getCodigo());
            stmt.executeUpdate();
            stmt.close();
       }catch (SQLException ex) {
            throw new CancelaDAOException(ex.getMessage());
        }
    }

    @Override
    public void liberaTicketExtraviado(Codigo codigo) throws CancelaDAOException  {
        try {       
            Connection con = ref.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE TICKET SET STATUS = 0,PRECO = ? WHERE CODIGO = ?");
            stmt.setDouble(1, CalculoSimples.precoExtraviado);
            stmt.setString(2, codigo.getCodigo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new CancelaDAOException(ex.getMessage());
        }
    }


    @Override
    public String getStatus(int status) throws CancelaDAOException 
    {
    try {
            Connection con = ref.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT DESCRICAO FROM status WHERE STATUS=?"
                    );
            stmt.setInt(1,status);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()) {
                String result = resultado.getString("DESCRICAO");
                return result;
            }
            stmt.close();
            return "Status invalido";
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao buscar.", ex);
        }
    }

    @Override
    public List<Ticket> getTodosPagos() throws CancelaDAOException{
        try {
            Connection con = ref.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM ticket where STATUS in (SELECT STATUS FROM status where DESCRICAO = \'Pago\')");
            List<Ticket> lista = new ArrayList<Ticket>();
            while(resultado.next()) {
                Codigo cod = new CodigoSimples(resultado.getString("CODIGO"));
                Timestamp tm = resultado.getTimestamp("DATA");
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTimeInMillis(tm.getTime());
                int status = resultado.getInt("STATUS");
                Ticket p = new Ticket(cod, cal,status);
                lista.add(p);
            }
            stmt.close();
            return lista;
        } catch (SQLException ex) {
            throw new CancelaDAOException("Falha ao buscar.", ex);
        }  
    }
   
}
