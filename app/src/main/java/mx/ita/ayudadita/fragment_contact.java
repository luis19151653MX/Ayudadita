package mx.ita.ayudadita;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_contact extends Fragment implements GestureOverlayView.OnGesturePerformedListener{

    private GestureLibrary libreria;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_contact.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_contact newInstance(String param1, String param2) {
        fragment_contact fragment = new fragment_contact();
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
        libreria= GestureLibraries.fromRawResource(getActivity(), R.raw.gestures);
        if(!libreria.load()){
            // finish();
        }
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        GestureOverlayView gestureView = view.findViewById(R.id.gestures);
        gestureView.addOnGesturePerformedListener(this);
        return view;
    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction> predictions=libreria.recognize(gesture);
        if(predictions.size()>0){
            String comando = predictions.get(0).name;
            if(comando.equals("acerca_de")){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);

            }
        }
    }
}

