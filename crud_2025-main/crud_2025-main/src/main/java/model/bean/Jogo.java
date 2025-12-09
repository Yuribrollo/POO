/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author OKS
 */
public class Jogo {
    private int idJogo;
    private String nomeJogo;
    private String generoJogo;
    private String descJogo;
    private Equipe equipe;
    private GameJam gamejam;;

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getGeneroJogo() {
        return generoJogo;
    }

    public void setGeneroJogo(String generoJogo) {
        this.generoJogo = generoJogo;
    }

    public String getDescJogo() {
        return descJogo;
    }

    public void setDescJogo(String descJogo) {
        this.descJogo = descJogo;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public GameJam getGamejam() {
        return gamejam;
    }

    public void setGamejam(GameJam gamejam) {
        this.gamejam = gamejam;
    }
    
    
    
    @Override
    public String toString() {
        return this.nomeJogo;
    } 
}
