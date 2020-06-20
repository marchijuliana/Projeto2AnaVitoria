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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText senha;
    private Button botao_login;
    private Button botao_cadastrar;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        email = (EditText)findViewById(R.id.editTextEmail);
        senha = (EditText)findViewById(R.id.input_senha);
        botao_login = (Button)findViewById(R.id.botao_login);
        botao_cadastrar = (Button)findViewById(R.id.botao_cadastrar);

        botao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(email.getText().toString() || TextUtils.isEmpty(senha.getText().toString()){
                    Toast.makeText(context:LoginActivity.this, text:"Todos os campos precisam estar preenchidos!", Toast.LENGTH_SHORT).show();
                } else {
                    auth.signInWithEmailAndPassword(email.getText().toString(), senha.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                            if(task.isSuccessful()){
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(context:LoginActivity.this, text:"Autenticação falhou, tente novamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                        
                    });
                }
                //validate(email.getText().toString(), senha.getText().toString());
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

}
