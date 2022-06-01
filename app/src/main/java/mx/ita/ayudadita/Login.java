package mx.ita.ayudadita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

import mx.ita.ayudadita.ui.home.HomeFragment;

public class Login extends AppCompatActivity {
    private EditText edCorreo;
    private EditText edContraseña;
    private Button Login;
    private Button Registrar;
    private TextView Olvide_contraseña;

    private String correo;
    private String contraseña;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLocal();
        setContentView(R.layout.activity_login);

        mAuth= FirebaseAuth.getInstance();

        edCorreo = (EditText) findViewById(R.id.email);
        edContraseña = (EditText) findViewById(R.id.password);
        Registrar = (Button) findViewById(R.id.crear_cuenta);
        Login = (Button) findViewById(R.id.login);
        Olvide_contraseña = (TextView) findViewById(R.id.olvide_contraseña);

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

        Olvide_contraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, ForgetPassword.class));
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

    public void setLocal(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("My_Language", lang);
        editor.commit();
    }

    public void getLocal() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = sharedPreferences.getString("My_Language", "");
        setLocal(language);
    }
}