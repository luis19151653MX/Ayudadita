package mx.ita.ayudadita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import mx.ita.ayudadita.ui.home.HomeFragment;

public class Login extends AppCompatActivity {
    private EditText edCorreo;
    private EditText edContraseña;
    private Button Login;
    private Button Registrar;

    private String correo;
    private String contraseña;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth= FirebaseAuth.getInstance();

        edCorreo = (EditText) findViewById(R.id.email);
        edContraseña = (EditText) findViewById(R.id.password);
        Registrar = (Button) findViewById(R.id.crear_cuenta);
        Login= (Button) findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correo = edCorreo.getText().toString();
                contraseña = edContraseña.getText().toString();

                if(!correo.isEmpty() && !contraseña.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(Login.this, "Completa los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(Login.this, MainActivity.class));
                }else{
                    Toast.makeText(Login.this, "No pudo iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}