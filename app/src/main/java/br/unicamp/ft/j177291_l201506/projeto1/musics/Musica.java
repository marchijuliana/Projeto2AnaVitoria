package br.unicamp.ft.j177291_l201506.projeto1.musics;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;

import br.unicamp.ft.j177291_l201506.projeto1.R;

public class Musica {
    private String nomeMusica;;
    private String nomeAlbum;
    private String duracao;
    private int foto;
    private int ano;

    public Musica(String nomeMusica, String nomeAlbum, String duracao, int foto, int ano) {

        this.nomeMusica = nomeMusica;
        this.nomeAlbum = nomeAlbum;
        this.duracao = duracao;
        this.foto = foto;
        this.ano = ano;
    }

    public String getNomeMusica() { return nomeMusica; }

    public String getNomeAlbum() { return nomeAlbum; }

    public String getDuracao() { return duracao; }

    public int getFoto() { return foto; }

    public int getAno() { return ano;}

    public static ArrayList<Musica> getMusicas(Context context) {
        if (context != null) {
            String[] nomes = context.getResources().getStringArray(R.array.item_musica_nome);
            String[] albuns = context.getResources().getStringArray(R.array.item_musica_album);
            String[] duracoes = context.getResources().getStringArray(R.array.item_musica_duracao);
            int[] anos = context.getResources().getIntArray(R.array.item_musica_ano);
            TypedArray fotos = context.getResources().obtainTypedArray(R.array.item_musica_foto);

            ArrayList<Musica> musicas = new ArrayList<>();
            for(int i = 0 ; i < anos.length ; i++){
                musicas.add(new Musica(nomes[i], albuns[i], duracoes[i], fotos.getResourceId(i,0), anos[i]));
            }
            fotos.recycle();
            return musicas;
        }
        return null;
    }
}