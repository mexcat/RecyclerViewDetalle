package cl.gencina.recyclerviewdetalle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import cl.gencina.recyclerviewdetalle.databinding.FragmentDetalleBinding;

public class DetalleFragment extends Fragment {
    private FragmentDetalleBinding binding;
    private static final String ARG_PARAM1 = "titulo";
    private static final String ARG_PARAM2 = "imagen";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetalleFragment() {
        // Required empty public constructor
    }
    public static DetalleFragment newInstance(String param1, String param2) {
        DetalleFragment fragment = new DetalleFragment();
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
        binding = FragmentDetalleBinding.inflate(getActivity().getLayoutInflater(), container, false);
        Glide.with(getContext())
                .load(mParam2)
                .into(binding.ivFotoDetalle);

        binding.tvTituloFoto.setText(mParam1);
        binding.fabBack.setOnClickListener(v ->{
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_detalleFragment_to_rvFragment);
        });
        return binding.getRoot();
    }
}