/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author OKS
 */
public class Equipe {
    private int idEquipe;
    private String nomeEquipe;
    private List<Usuario> usuarios;

    public Equipe(){
        usuarios = new ArrayList<>();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    

    @Override
    public String toString() {
        return this.nomeEquipe;
    } 
}
