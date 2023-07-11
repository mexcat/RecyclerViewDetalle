package cl.gencina.recyclerviewdetalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cl.gencina.recyclerviewdetalle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}