package cl.gencina.recyclerviewdetalle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.gencina.recyclerviewdetalle.databinding.FragmentRvBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RvFragment extends Fragment {
    FragmentRvBinding binding;
    List<Item> data = new ArrayList<>();
    RvAdapter infoAdapter = new RvAdapter();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RvFragment() {
        // Required empty public constructor
    }

    public static RvFragment newInstance(String param1, String param2) {
        RvFragment fragment = new RvFragment();
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
        binding = FragmentRvBinding.inflate(getActivity().getLayoutInflater(), container, false);
        setRvAdapter();

        return binding.getRoot();
    }

    public void setRvAdapter(){
        infoAdapter.setInfo(createData());
        binding.rvData.setAdapter(infoAdapter);
    }

    public List<Item> createData(){
            data.add(new Item("foto1", "https://images.unsplash.com/photo-1577741314755-048d8525d31e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"));
            data.add(new Item("foto2", "https://images.unsplash.com/photo-1579373903781-fd5c0c30c4cd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1074&q=80"));
            data.add(new Item("foto3", "https://images.unsplash.com/photo-1588699219474-fce022b9f633?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=765&q=80"));
            data.add(new Item("foto4", "https://images.unsplash.com/photo-1562229125-6d6075419a22?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1074&q=80"));
        return data;
    }
}