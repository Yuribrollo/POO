/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author OKS
 */
public class Avaliacao {
    private int idAval;
    private String notaAval;
    private String comentAval;
    private Jogo jogo;
    private Usuario usuario;

    public int getIdAval() {
        return idAval;
    }

    public void setIdAval(int idAval) {
        this.idAval = idAval;
    }

    public String getNotaAval() {
        return notaAval;
    }

    public void setNotaAval(String notaAval) {
        this.notaAval = notaAval;
    }

    public String getComentAval() {
        return comentAval;
    }

    public void setComentAval(String comentAval) {
        this.comentAval = comentAval;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
