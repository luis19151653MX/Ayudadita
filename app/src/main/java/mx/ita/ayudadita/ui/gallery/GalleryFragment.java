package mx.ita.ayudadita.ui.gallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.util.Locale;

import mx.ita.ayudadita.R;
import mx.ita.ayudadita.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private Button buttonEs;
    private Button buttonEn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        buttonEs=root.findViewById(R.id.buttonES);
        buttonEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocal("es");
            }
        });

        buttonEn=root.findViewById(R.id.buttonEN);
        buttonEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocal("en");
            }
        });

        return root;
    }

    public void setLocal(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(configuration, getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putString("My_Language", lang);
        editor.commit();
    }

    public void getLocal() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("My_Language", "");
        setLocal(language);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}