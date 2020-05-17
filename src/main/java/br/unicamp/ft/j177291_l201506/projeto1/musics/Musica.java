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
    private String ano;

    public Musica(String nomeMusica, String nomeAlbum, String duracao, String ano, int foto) {

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

    public String getAno() { return ano;}

    public static ArrayList<Musica> getMusicas(Context context) {
        if (context != null) {
            String[] infos = context.getResources().getStringArray(R.array.musica_nome);
            TypedArray fotos = context.getResources().obtainTypedArray(R.array.musica_foto);

            ArrayList<Musica> musicas = new ArrayList<>();
            for(int i = 0 ; i < infos.length ; i++){
                String[] info = infos[i].split(",");
                musicas.add(new Musica(info[0], info[1], info[2], info[3],fotos.getResourceId(i,0)));
            }
            fotos.recycle();
            return musicas;
        }
        return null;
    }
}