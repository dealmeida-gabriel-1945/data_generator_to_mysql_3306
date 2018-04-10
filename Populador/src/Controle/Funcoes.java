/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Atributo;
import Modelo.Tabela;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gabriel Guimarães
 */
public class Funcoes {

    public static String stringCorte(int max) {
        Random rand = new Random();
        String letras = "abcdefghijklmnopqrstuvwxyz";
        if (max <= 0) {
            int length = Funcoes.geraNum(50);
            return Funcoes.fazString(length);
        } else {
            return Funcoes.fazString(max);
        }
    }

    public static int intCorte(int max) {
        Random rand = new Random();
        String x = rand.nextInt() + "";
        if (max <= 0) {
            return Integer.parseInt(x);
        } else {
            if (x.length() >= max) {
                return Integer.parseInt(x.substring(0, max));
            } else {
                return Integer.parseInt(x);
            }
        }
    }

    public static float floatCorte(int max) {
        Random rand = new Random();
        String x = rand.nextInt() + "";
        if (max <= 0) {
            return Float.parseFloat(x);
        } else {
            if (x.length() >= max) {
                return Float.parseFloat(x.substring(0, max));
            } else {
                return Float.parseFloat(x);
            }
        }
    }

    public static int geraNum(int max) {
        Random rand = new Random();
        int i = rand.nextInt(max);
        i = Math.abs(i);
        if (i == 0) {
            return (i + 1);
        } else {
            return i;
        }
    }

    private static String fazString(int lenght) {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String x = "";
        for (int i = 1; i <= lenght; i++) {
            x += letras.charAt(Funcoes.geraNum(26));
            System.out.println(x);
        }
        return x;
    }

    public static String geraScript(ArrayList<Tabela> tabelas, String dbname) {
        String sql = "CREATE DATABASE "+dbname+"; \n";
        sql += "USE "+dbname+"; \n";
        for (Tabela tab : tabelas) {
            sql += "CREATE TABLE IF NOT EXISTS `" + dbname + "`.`" + tab.getNome() + "` ( \n";

            for (Atributo att : tab.getAtributos()) {
                sql += "`" + att.getNome() + "` " + att.getTipoDB() + "";
                if (att.isNn() == true) {
                    sql += " NOT NULL";
                }
                if (att.isPk() == true) {
                    sql += " AUTO_INCREMENT";
                }
                sql += ", \n";
            }
            for (Atributo att : tab.getAtributos()) {
                if (att.isPk() == true) {
                    sql += "PRIMARY KEY(" + att.getNome() + ")";
                }
            }

            sql += "); \n";
        }

        return sql;
    }
}
