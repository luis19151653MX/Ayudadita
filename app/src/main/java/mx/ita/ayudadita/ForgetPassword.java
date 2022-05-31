package mx.ita.ayudadita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private EditText edit_textEmail;
    private Button btnForgetPassword;

    private String email="";

    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        edit_textEmail = (EditText) findViewById(R.id.editTextEmail);
        btnForgetPassword = (Button) findViewById(R.id.btnResetPassword);

        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email= edit_textEmail.getText().toString();

                if (!email.isEmpty()){
                    mDialog.setMessage("Es un momento...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    forgetPassword();
                }else{
                    Toast.makeText(ForgetPassword.this, "Debe ingresar el correo", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void forgetPassword(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetPassword.this, "Se envió el correo", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ForgetPassword.this, "No se pudo enviar el correo", Toast.LENGTH_SHORT).show();
                }
                mDialog.dismiss();
            }
        });
    }
}