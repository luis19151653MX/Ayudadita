package mx.ita.ayudadita;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_write_question#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_write_question extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_write_question() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_write_question.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_write_question newInstance(String param1, String param2) {
        fragment_write_question fragment = new fragment_write_question();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_write_question, container, false);
        final EditText escribePregunta = view.findViewById(R.id.escribePregunta);
        ImageButton btn = view.findViewById(R.id.enviarPregunta);
        DAOQuestions dao = new DAOQuestions();

        btn.setOnClickListener(v->{
            Questions question = new Questions("1",escribePregunta.getText().toString(), "1","1","1","1");
            dao.add(question).addOnCompleteListener(suc->
            {
                Navigation.findNavController(view).navigate(R.id.action_fragment_write_question_to_fragment_allquestions);
                Toast.makeText(getActivity(), "Pregunta registrada", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(getActivity(), ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
        // Inflate the layout for this fragment
        return view;


    }
}