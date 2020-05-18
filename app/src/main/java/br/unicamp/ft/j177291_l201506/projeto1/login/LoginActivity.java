package br.unicamp.ft.j177291_l201506.projeto1.login;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.unicamp.ft.j177291_l201506.projeto1.MainActivity;
import br.unicamp.ft.j177291_l201506.projeto1.R;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText senha;
    private Button botao_login;
    private Button botao_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.editTextEmail);
        senha = (EditText)findViewById(R.id.input_senha);
        botao_login = (Button)findViewById(R.id.botao_login);
        botao_cadastrar = (Button)findViewById(R.id.botao_cadastrar);

        botao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(), senha.getText().toString());
            }
        });

        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SingupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("user", userName);
        startActivity(intent);

//        if((userName.equals("admin")) && (userPassword.equals("admin"))){
//
//        }else{
//            Toast.makeText(this, "Email ou usuário incorretos!", Toast.LENGTH_LONG).show();
//        }
    }

}
