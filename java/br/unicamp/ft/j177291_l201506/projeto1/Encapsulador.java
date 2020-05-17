package br.unicamp.ft.j177291_l201506.projeto1;

import java.io.Serializable;

public class Encapsulador implements Serializable {
    private String user;
    private String email;
    private String senha;
    private String genero;
    private String fav;
    private String goodies;

    public Encapsulador(String user, String email, String senha, String genero, String fav, String goodies){
        this.user = user;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.fav = fav;
        this.goodies = goodies;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getGenero() {
        return genero;
    }

    public String getFav() {
        return fav;
    }

    public String getGoodies() {
        return goodies;
    }
}