package br.unicamp.ft.j177291_l201506.projeto1.musics;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.ft.j177291_l201506.projeto1.R;

public class ListaMusicaAdapter extends RecyclerView.Adapter {
    private ArrayList<Musica> musicas;
    public ListaMusicaAdapter(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.musics_adapter, parent, false);
        final ListaMusicaAdapterHolder listaMusicaAdapterHolder = new ListaMusicaAdapterHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (listaMusicaAdapterOnClickListener != null){
                    TextView txt_nomemusica = v.findViewById(R.id.text_view_nomemusica); //adapter_layout.xml
                    TextView txt_album = v.findViewById(R.id.text_view_album);
                    TextView txt_duracao = v.findViewById(R.id.text_view_duracao);
                    TextView txt_ano = v.findViewById(R.id.text_view_ano);

                    String txt = txt_nomemusica.getText().toString().split(" ")[0]+" - "+txt_duracao.getText().toString()+"\n"+txt_album.getText().toString()+" "+txt_ano.getText().toString();
                    listaMusicaAdapterOnClickListener.listaMusicaAdapterOnItemClick(txt);
                }
            }
        });

        return listaMusicaAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListaMusicaAdapterHolder) holder).bind(musicas.get(position));
    }

    @Override
    public int getItemCount() {
        //return mDataset.length;
        return this.musicas.size();
    }

    /* Parte da inteface para instanciação de eventos */
    // Definindo a interface para disparar gatilhos de onItemClick
    public interface ListaMusicaAdapterOnClickListener {
        void listaMusicaAdapterOnItemClick(String nome);
    }

    //Declarei o atributo
    private ListaMusicaAdapterOnClickListener listaMusicaAdapterOnClickListener;

    //Atribuo a instância para o atributo
    public void setListaMusicaAdapterOnClickListener(ListaMusicaAdapterOnClickListener m){
        this.listaMusicaAdapterOnClickListener = m;
    }

    class ListaMusicaAdapterHolder extends RecyclerView.ViewHolder {
        private TextView textViewNomeMusica;
        private TextView textViewAlbum;
        private TextView textViewDuracao;
        private TextView textViewAno;
        private ImageView imageView;

        public ListaMusicaAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textViewNomeMusica = itemView.findViewById(R.id.text_view_nomemusica); //adapter_layout.xml
            textViewAlbum = itemView.findViewById(R.id.text_view_album);
            textViewDuracao = itemView.findViewById(R.id.text_view_duracao);
            textViewAno = itemView.findViewById(R.id.text_view_ano);
        }

        public void bind(Musica musica){
            imageView.setImageResource(musica.getFoto());
            textViewNomeMusica.setText(musica.getNomeMusica());
            textViewAlbum.setText(musica.getNomeAlbum());
            textViewDuracao.setText(musica.getDuracao());
            textViewAno.setText(musica.getAno());
        }
    }

    // Create new views (invoked by the layout manager)


    // Replace the contents of a view (invoked by the layout manager)


    // Return the size of your dataset (invoked by the layout manager)



}