/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gabriel Guimarães
 */
public class Atributo {
    private String nome;
    private String tipo;
    private int maxLength;
    private boolean pk;
    private boolean nn;
    private boolean ai;

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }

    public boolean isNn() {
        return nn;
    }

    public void setNn(boolean nn) {
        this.nn = nn;
    }

    public boolean isAi() {
        return ai;
    }

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
    
    public String toString(){
        String strg = this.nome+" | "+this.tipo;
        if(this.tipo.equals("VARCHAR")){
            if(this.maxLength!=45){
                strg+="("+this.maxLength+")";
            }else{
                strg+="(45)";
            }
        }
        
        if (this.isPk()==true) {
            strg+=" | PK";
        }
        if (this.isNn()==true) {
            strg+=" | NN";
        }
        if (this.isAi()==true) {
            strg+=" | AI";
        }
        return strg;
    }

    public String getTipoDB() {
        if(this.tipo.equals("VARCHAR")){
            if(this.maxLength!=45){
                return "VARCHAR("+this.maxLength+")";
            }else{
                return "VARCHAR(45)";
            }
        }else{
            return this.tipo;
        }
    }
    
    
}
