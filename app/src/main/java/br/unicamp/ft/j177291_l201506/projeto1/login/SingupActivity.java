package br.unicamp.ft.j177291_l201506.projeto1.login;

import androidx.appcompat.app.AppCompatActivity;

import br.unicamp.ft.j177291_l201506.projeto1.MainActivity;
import br.unicamp.ft.j177291_l201506.projeto1.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SingupActivity extends AppCompatActivity {

    private EditText edt_user, edt_pass, edt_confirm_pass, edt_email;
    private RadioGroup rb_group_sex;
    private Spinner spnn_fav;
    private CheckBox cb_album, cb_dvd, cb_poster, cb_camiseta, cb_moletom, cb_colar, cb_pulseira,
            cb_agenda, cb_outros;
    private Button btn_cadastrar;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        edt_user = findViewById(R.id.edt_user);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_pass);
        edt_confirm_pass = findViewById(R.id.edt_confirm_pass);
        rb_group_sex = findViewById(R.id.rb_group_sex);
        spnn_fav = findViewById(R.id.spnn_fav);
        cb_album = findViewById(R.id.cb_album);
        cb_dvd = findViewById(R.id.cb_dvd);
        cb_poster = findViewById(R.id.cb_poster);
        cb_camiseta = findViewById(R.id.cb_camiseta);
        cb_moletom = findViewById(R.id.cb_moletom);
        cb_colar = findViewById(R.id.cb_colar);
        cb_pulseira = findViewById(R.id.cb_pulseira);
        cb_agenda = findViewById(R.id.cb_agenda);
        cb_outros = findViewById(R.id.cb_outros);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);
    
        auth = FirebaseAuth.getInstance();

        btn_cadastrar.setOnClickListener(new View.setOnClickListener() {
            @Override
            public void onClick(View view){

            String txt_user = edt_user.getText().toString();
            String txt_email = edt_email.getText().toString();
            String txt_pass = edt_pass.getText().toString();
            String txt_rb_group_sex = rb_group_sex.getText().toString();
            String txt_spnn_fav = spnn_fav.getText().toString();
            String txt_cd_album = cd_album.getText().toString();
            String txt_cd_dvd = cd_dvd.getText().toString();
            String txt_cd_poster =  cd_poster.getText().toString();
            String txt_cd_camiseta = cd_camiseta.getText().toString();
            String txt_cd_moletom = cd_moletom.getText().toString();
            String txt_cd_colar = cd_colar.getText().toString();
            String txt_cd_pulseira = cd_pulseira.getText().toString();
            String txt_cd_agenda = cd_agenda.getText().toString();
            String txt_cd_outros = cd_outros.getText().toString();


            if (edt_user.getText().toString().equals("")){
                Toast.makeText(this, "Por favor, preencha o nome de usuário!", Toast.LENGTH_SHORT).show();
            }
            else if (edt_email.getText().toString().equals("")){
                Toast.makeText(this, "Por favor, preencha o email!", Toast.LENGTH_SHORT).show();
            }
            else if (edt_pass.getText().toString().equals("")){
                Toast.makeText(this, "Por favor, preencha a senha!", Toast.LENGTH_SHORT).show();
            }
            else if (edt_confirm_pass.getText().toString().equals("")){
                Toast.makeText(this, "Por favor, confirme a senha!", Toast.LENGTH_SHORT).show();
            }
            else{
                 if (edt_pass.getText().toString().equals(edt_confirm_pass.getText().toString())){

                String goodies = verificarGoodies();
                String genero = verificarGenero();

                cadastrar
            }
            else{
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show();
            }
                }
        });

    }

    private String verificarGoodies(){
        String goodies = "";
        if(cb_album.isChecked()){
            goodies += cb_album.getText().toString() + ", ";
        }
        if(cb_dvd.isChecked()){
            goodies += cb_dvd.getText().toString() + ", ";
        }
        if(cb_poster.isChecked()){
            goodies += cb_poster.getText().toString() + ", ";
        }
        if(cb_camiseta.isChecked()){
            goodies += cb_camiseta.getText().toString() + ", ";
        }
        if(cb_moletom.isChecked()){
            goodies += cb_moletom.getText().toString() + ", ";
        }
        if(cb_colar.isChecked()){
            goodies += cb_colar.getText().toString() + ", ";
        }
        if(cb_pulseira.isChecked()){
            goodies += cb_pulseira.getText().toString() + ", ";
        }
        if(cb_agenda.isChecked()){
            goodies += cb_agenda.getText().toString() + ", ";
        }
        if(cb_outros.isChecked()){
            goodies += cb_outros.getText().toString() + ", ";
        }
        return goodies.substring(0, goodies.length() - 2);
    }

    private String verificarGenero(){
        String genero = "Não definido";

        int id_sex = rb_group_sex.getCheckedRadioButtonId();
        if (id_sex == R.id.rb_fem){
            genero = "Feminino";
        }
        else if (id_sex == R.id.rb_masc){
            genero = "Masculino";
        }

        return genero;
    }

    private void cadastrar (String edt_user, String edt_email, String edt_pass, String rb_group_sex, String spnn_fav, String cb_album, String cb_dvd, String cb_poster, String cb_camiseta, String cb_moletom, String cb_colar, String cb_pulseira, String cb_agenda, String cb_outros)
    {
        auth.createUserWithEmailAndPassword(edt_email, edt_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if (task.isSucessful())
                {
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    String userid = firebaseUser.getUid();

                    reference = FirebaseDatabase.getInstance().getReference(S: "Users").child(userid);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", userid);
                    hashMap.put("username", edt_user);
                    hashMap.put("imageURL", "default");
                
                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>(){
                        @Override
                        public void onComplete(@NonNull Task<Void> task){
                            if(task.isSucessful()){
                                Intent intent = new Intent(SingupActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                } else{
                    Toast.makeText(context: SingupActivity.this, text:" Não foi possível concluir o cadastro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
