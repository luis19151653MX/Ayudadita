package mx.ita.ayudadita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
//jolj
public class Registration extends AppCompatActivity {

    private Button Registrar;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    private String nombre;
    private String correo;
    private String contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        final EditText edit_nombre = findViewById(R.id.edit_nombre);
        final EditText edit_correo = findViewById(R.id.edit_correo);
        final EditText edit_contraseña = findViewById(R.id.edit_contraseña);
        Registrar = (Button) findViewById(R.id.registrar);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = edit_nombre.getText().toString();
                correo = edit_correo.getText().toString();
                contraseña = edit_contraseña.getText().toString();

                if (!nombre.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){
                    if (contraseña.length()>=6){
                        registerUser();
                    }else{
                        Toast.makeText(Registration.this, "Debe de ternar +6",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registration.this, "Completa los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void registerUser(){
        mAuth.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre", nombre);
                    map.put("correo", correo);
                    map.put("contraseña", contraseña);

                    String id= mAuth.getCurrentUser().getUid();

                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(Registration.this, Login.class));
                                finish();
                            }else{
                                Toast.makeText(Registration.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(Registration.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
    }

}