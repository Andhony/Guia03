package com.uso.guia03.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.uso.guia03.R;

import java.util.List;

public class AdaptadorInformacion extends RecyclerView.Adapter<viewHolderInformation> {
    private List<Informacion> listaInformacion;

    public AdaptadorInformacion(List<Informacion> data){
        this.listaInformacion = data;
    }

    @NonNull
    @Override
    public viewHolderInformation onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creamos la vista que representa el item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_informacion,parent,false);
        viewHolderInformation vhInformacion = new viewHolderInformation(vista);
        return vhInformacion;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderInformation holder, int position) {
        //Enlazamos los datos con el ViewHolder
        holder.getLblNombre().setText(this.listaInformacion.get(position).getNombre());
        //holder.getLblEdad().setText(this.listaInformacion.get(position).getEdad());
        //holder.getLblAlimento().setText(this.listaInformacion.get(position).getAlimento());
    }

    @Override
    public int getItemCount() {
        return this.listaInformacion.size();
    }
}
