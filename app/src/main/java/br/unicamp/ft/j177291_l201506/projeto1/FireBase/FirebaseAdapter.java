package br.unicamp.ft.j177291_l201506.projeto1.FireBase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.unicamp.ft.j177291_l201506.projeto1.R;

public class FirebaseAdapter extends FirebaseRecyclerAdapter<Resposta, RecyclerView.ViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirebaseAdapter(@NonNull FirebaseRecyclerOptions<Resposta> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,
                                    int i, @NonNull Resposta resposta) {

        ((RespostaViewHolder)viewHolder).bind(resposta);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_firebase_recycler,
                parent, false);
        return new RespostaViewHolder(view);
    }

    /*
    public static class RespostaViewHolder extends RecyclerView.ViewHolder{

        private TextView answer;
        private TextView choosen;

        public RespostaViewHolder(@NonNull View itemView) {
            super(itemView);
            answer = itemView.findViewById(R.id.txtAnswer);
            choosen = itemView.findViewById(R.id.txtChosen);
        }

        void bind(Resposta resposta){
            this.answer.setText(resposta.getAnswer());
            this.choosen.setText(resposta.getChosen());
        }
    }
    */
}