package cl.gencina.recyclerviewdetalle;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.internal.ContextUtils;

import java.util.List;

import cl.gencina.recyclerviewdetalle.databinding.ItemBinding;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private List<Item> data;
    private Context context;

    public void setInfo(List<Item> data){
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context  = parent.getContext();
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind( data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ItemBinding binding;

        public MyViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(Item info){
            Glide.with(context)
                    .load(info.getImagen())
                    .into(binding.ivFoto);
            binding.tvNombre.setText(info.getTitulo());
            binding.cvData.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("titulo", info.getTitulo());
                bundle.putString("imagen", info.getImagen());
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_rvFragment_to_detalleFragment,bundle);
            });
        }

    }
}
