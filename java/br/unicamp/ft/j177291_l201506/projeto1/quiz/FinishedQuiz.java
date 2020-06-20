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
public class FinishedQuiz extends Fragment {



    public FinishedQuiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finished_quiz, container, false);

        Button btnLegal;
        btnLegal = view.findViewById(R.id.btn_legal);
        btnLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = NavHostFragment.findNavController(FinishedQuiz.this);
                navController.navigate(R.id.nav_quiz_go_home);
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
