package br.unicamp.ft.j177291_l201506.projeto1.musics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.unicamp.ft.j177291_l201506.projeto1.R;

import br.unicamp.ft.j177291_l201506.projeto1.musics.Musica;
import br.unicamp.ft.j177291_l201506.projeto1.musics.ListaMusicaAdapter;

public class MusicsFragment extends Fragment {
    private ListaMusicaAdapter listaMusicaAdapter;
    private RecyclerView recyclerView;

    public MusicsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_musics, container, false);

        listaMusicaAdapter = new ListaMusicaAdapter(Musica.getMusicas(getContext()));

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listaMusicaAdapter);

        ListaMusicaAdapter.ListaMusicaAdapterOnClickListener onClickListener = new ListaMusicaAdapter.ListaMusicaAdapterOnClickListener(){
            @Override
            public void listaMusicaAdapterOnItemClick(String text) {
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
            }
        };
        listaMusicaAdapter.setListaMusicaAdapterOnClickListener(onClickListener);

        return view;
    }
}