package com.uso.guia03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.uso.guia03.Adaptadores.AdaptadorInformacion;
import com.uso.guia03.Adaptadores.Informacion;

import java.util.ArrayList;
import java.util.List;

public class VerLista extends AppCompatActivity {

    private List<Informacion> datosInformacion = new ArrayList<>();
    private RecyclerView listInformacion;
    private AdaptadorInformacion adaptador;
    private LinearLayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        //Cargar los datos
        cargarInformacion();
        this.listInformacion = findViewById(R.id.listInformacion);
        this.manager = new LinearLayoutManager(this);
        this.adaptador = new AdaptadorInformacion(datosInformacion);

        //Configuramos el RecyclerView
        this.listInformacion.setHasFixedSize(true);
        this.listInformacion.setLayoutManager(this.manager);
        this.listInformacion.setAdapter(this.adaptador);
    }

    private void cargarInformacion() {
        this.datosInformacion = AgregarNombre.datosNuevosInformacion;
    }
}