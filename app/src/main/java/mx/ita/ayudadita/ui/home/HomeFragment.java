package mx.ita.ayudadita.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import mx.ita.ayudadita.R;
import mx.ita.ayudadita.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment  {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //botones de semestres
        Button semestre1 = root.findViewById(R.id.button0);

        semestre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre2 = root.findViewById(R.id.button1);

        semestre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre3 = root.findViewById(R.id.button2);

        semestre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre4 = root.findViewById(R.id.button3);

        semestre4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre5 = root.findViewById(R.id.button4);

        semestre5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre6 = root.findViewById(R.id.button5);

        semestre6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre7 = root.findViewById(R.id.button6);

        semestre7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre8 = root.findViewById(R.id.button7);

        semestre8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        Button semestre9 = root.findViewById(R.id.button8);

        semestre9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_fragment_first_semester);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}