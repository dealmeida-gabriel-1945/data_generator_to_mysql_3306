/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Atributo;
import Modelo.ConnectionFactory;
import Modelo.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Gabriel Guimarães
 */
public class QualqueCoisaControle {
    
    Random rand = new Random();

    private Connection connection;
    private PreparedStatement stmt;

    private String bd;
    private String usuario;
    private String senha;

    public QualqueCoisaControle(String bd, String usuario, String senha) {
        this.bd = bd;
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean pegaConnect() {
        this.connection = ConnectionFactory.getConnection(bd, usuario, senha);
        if (this.connection == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getBd() {
        return bd;
    }

    public void povoa(Tabela tabela) {

        String sql = "";

        //sql = sql + "use " + this.bd + "; ";

        sql = sql + "insert into " + this.bd + "." + tabela.getNome() + " (";

        for (int i = 0; i < tabela.getAtributos().size(); i++) {
            sql = sql + tabela.getAtributos().get(i).getNome();

            if (i == (tabela.getAtributos().size() - 1)) {

            } else {
                sql = sql + ",";
            }
        }

        sql = sql + ")"
                + " values "
                + "(";

        for (int i = 0; i < tabela.getAtributos().size(); i++) {
            
            if(tabela.getAtributos().get(i).getTipo().equals("INT")){
                    sql = sql + Funcoes.intCorte(tabela.getAtributos().get(i).getMaxLength());
                }else if(tabela.getAtributos().get(i).getTipo().equals("TEXT")){
                    sql = sql + "'"+Funcoes.stringCorte(tabela.getAtributos().get(i).getMaxLength())+"'";
                }else if(tabela.getAtributos().get(i).getTipo().equals("FLOAT")){
                    sql = sql + Funcoes.floatCorte(tabela.getAtributos().get(i).getMaxLength());
                }else if(tabela.getAtributos().get(i).getTipo().equals("BOOLEAN")){
                    sql = sql + rand.nextBoolean();
                }
            
            if (i == (tabela.getAtributos().size() - 1)) {

            } else {
                sql = sql + ",";
            }
        }

        sql = sql + ");";
        System.out.println(sql);
        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
