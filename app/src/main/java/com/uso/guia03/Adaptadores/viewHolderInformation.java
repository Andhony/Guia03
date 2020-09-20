package com.uso.guia03.Adaptadores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uso.guia03.R;

public class viewHolderInformation extends RecyclerView.ViewHolder {
    private TextView lblNombre;

    public viewHolderInformation(@NonNull View itemView) {
        super(itemView);
        this.lblNombre = itemView.findViewById(R.id.lblNombre);
    }

    public TextView getLblNombre() {
        return lblNombre;
    }

}
