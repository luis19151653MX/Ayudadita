package mx.ita.ayudadita;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOQuestions {
    private DatabaseReference databaseReference;

    public DAOQuestions(){
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://projectdmayudaita-default-rtdb.firebaseio.com/");
        databaseReference=db.getReference(Questions.class.getSimpleName());
    }

    /*Insert*/
    public Task<Void> add(Questions question){ return databaseReference.push().setValue(question); }
}

