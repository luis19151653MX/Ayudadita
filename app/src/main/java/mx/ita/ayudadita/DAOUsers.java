package mx.ita.ayudadita;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUsers {
    private DatabaseReference databaseReference;

    public DAOUsers(){
        FirebaseDatabase db = FirebaseDatabase.getInstance("hhttps://projectdmayudaita-default-rtdb.firebaseio.com/");
        databaseReference=db.getReference(Users.class.getSimpleName());
    }

    /*Insert*/
    public Task<Void> add(Users user){
        return databaseReference.push().setValue(user);
    }
}
