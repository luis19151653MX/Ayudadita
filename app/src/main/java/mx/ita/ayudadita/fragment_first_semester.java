package mx.ita.ayudadita;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_first_semester#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_first_semester extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_first_semester() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_first_semester.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_first_semester newInstance(String param1, String param2) {
        fragment_first_semester fragment = new fragment_first_semester();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first_semester, container, false);

        ImageButton materia=view.findViewById(R.id.imageButton);
        materia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_first_semester_to_fragment_allquestions);
            }
        });

        ImageButton materia2=view.findViewById(R.id.imageButton2);
        materia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_first_semester_to_fragment_allquestions);
            }
        });

        ImageButton materia3=view.findViewById(R.id.imageButton3);
        materia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_first_semester_to_fragment_allquestions);
            }
        });

        ImageButton materia4=view.findViewById(R.id.imageButton4);
        materia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_first_semester_to_fragment_allquestions);
            }
        });

        ImageButton materia5=view.findViewById(R.id.imageButton5);
        materia5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_first_semester_to_fragment_allquestions);
            }
        });

        ImageButton materia6=view.findViewById(R.id.imageButton6);
        materia6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_first_semester_to_fragment_allquestions);
            }
        });
        return view;
    }
}