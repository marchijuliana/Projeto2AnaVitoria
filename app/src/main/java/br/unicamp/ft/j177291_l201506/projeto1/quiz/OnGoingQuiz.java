package br.unicamp.ft.j177291_l201506.projeto1.quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.unicamp.ft.j177291_l201506.projeto1.MainActivity;
import br.unicamp.ft.j177291_l201506.projeto1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnGoingQuiz extends Fragment {


    public OnGoingQuiz() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_going_quiz, container, false);

        Button btnFinalizarQuiz;
        btnFinalizarQuiz = view.findViewById(R.id.btn_finalizar_quiz);
        btnFinalizarQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle pontuacao = new Bundle();
//                pontuacao.putString("msg", msg);

                NavController navController = NavHostFragment.findNavController(OnGoingQuiz.this);
                navController.navigate(R.id.nav_end_quiz, pontuacao);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        MainActivity.fab.setVisibility(View.GONE);
    }
}
