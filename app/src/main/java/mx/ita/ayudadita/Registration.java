package mx.ita.ayudadita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final EditText nombre = findViewById(R.id.nombre);
        final EditText correo = findViewById(R.id.correo);
        final EditText contraseña = findViewById(R.id.contraseña);

        Button btn = findViewById(R.id.registrar);
        DAOUsers dao = new DAOUsers();

        btn.setOnClickListener(v->
        {
            /*INSERTAR*/
            Users user = new Users(nombre.getText().toString(), correo.getText().toString(), contraseña.getText().toString());
            dao.add(user).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }


}