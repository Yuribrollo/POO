/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author OKS
 */
public class GameJam {
    private int idGJ;
    private String nomeGJ;
    private String temaGJ;
    private String duraGJ;
    private String premioGJ;
    private String descGJ;
    private String dataInGJ;
    private String dataFimGJ;

    public int getIdGJ() {
        return idGJ;
    }

    public void setIdGJ(int idGJ) {
        this.idGJ = idGJ;
    }

    public String getNomeGJ() {
        return nomeGJ;
    }

    public void setNomeGJ(String nomeGJ) {
        this.nomeGJ = nomeGJ;
    }

    public String getTemaGJ() {
        return temaGJ;
    }

    public void setTemaGJ(String temaGJ) {
        this.temaGJ = temaGJ;
    }

    public String getDuraGJ() {
        return duraGJ;
    }

    public void setDuraGJ(String duraGJ) {
        this.duraGJ = duraGJ;
    }

    public String getPremioGJ() {
        return premioGJ;
    }

    public void setPremioGJ(String premioGJ) {
        this.premioGJ = premioGJ;
    }

    public String getDescGJ() {
        return descGJ;
    }

    public void setDescGJ(String descGJ) {
        this.descGJ = descGJ;
    }

    public String getDataInGJ() {
        return dataInGJ;
    }

    public void setDataInGJ(String dataInGJ) {
        this.dataInGJ = dataInGJ;
    }

    public String getDataFimGJ() {
        return dataFimGJ;
    }

    public void setDataFimGJ(String dataFimGJ) {
        this.dataFimGJ = dataFimGJ;
    }
    
        @Override
    public String toString() {
        return this.nomeGJ;
    } 
}
