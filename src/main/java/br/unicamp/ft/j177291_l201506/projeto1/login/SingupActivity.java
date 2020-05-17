package br.unicamp.ft.j177291_l201506.projeto1.login;

import br.unicamp.ft.j177291_l201506.projeto1.Encapsulador;
import br.unicamp.ft.j177291_l201506.projeto1.R;
import br.unicamp.ft.j177291_l201506.projeto1.ShowCadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SingupActivity extends Activity {

    private EditText edt_user, edt_pass, edt_confirm_pass, edt_email;
    private RadioGroup rb_group_sex;
    private Spinner spnn_fav;
    private CheckBox cb_album, cb_dvd, cb_poster, cb_camiseta, cb_moletom, cb_colar, cb_pulseira,
            cb_agenda, cb_outros;
    private Button btn_cadastrar;

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
    }

    public void onClickCadastrarUsuario(View view) {
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
                Encapsulador capsula = new Encapsulador(edt_user.getText().toString(), edt_email.getText().toString(),
                        edt_pass.getText().toString(), genero, spnn_fav.getSelectedItem().toString(), goodies);

                Intent intent = new Intent(SingupActivity.this, ShowCadastro.class);
                intent.putExtra("capsula", capsula);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show();
            }
        }
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
}
