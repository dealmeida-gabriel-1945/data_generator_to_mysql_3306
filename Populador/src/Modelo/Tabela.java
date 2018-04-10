/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Guimarães
 */
public class Tabela {
    private String nome;
    private int vezes;
    private ArrayList<Atributo> atributos;
    
    public Tabela(String nome, int vezes, ArrayList<Atributo> atributos) {
        this.nome = nome;
        this.vezes = vezes;
        this.atributos = atributos;
    }
    
    public Tabela() {
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVezes() {
        return vezes;
    }

    public void setVezes(int vezes) {
        this.vezes = vezes;
    }

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Atributo> atributos) {
        this.atributos = atributos;
    }
    
    
}
