package com.uso.guia03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.uso.guia03.Adaptadores.Informacion;

import java.util.ArrayList;
import java.util.List;

public class AgregarNombre extends AppCompatActivity {

    public static final String TAG_MENSAJE = "MSJ";
    public EditText txtNombre;
    private static int contProgreso = 0;
    private ProgressBar progressBar;
    private Button btnGuardar;
    private Handler manejadorProcesos;
    private Informacion nuevaInfo = new Informacion();
    public static List<Informacion> datosNuevosInformacion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);

        this.progressBar = findViewById(R.id.progressBar);
        this.btnGuardar = findViewById(R.id.btnGuardar);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.btnGuardar.setEnabled(true);
        this.manejadorProcesos = new Handler();
        this.contProgreso = 0;

        this.progressBar.setMax(100);
    }

    public void btnProcesar_onClick(View v){
        Boolean bandera = false;

        if (txtNombre.getText().toString().trim().equals("")){
            txtNombre.setError("¡Este campo es obligatorio!");
        }else{
            bandera = true;
        }
        if (bandera){
            this.btnGuardar.setEnabled(false);
            //Creamos un nuevo para simular el guardado de datos
            new Thread(new ProcesoSecundario()).start();
            nuevaInfo.setNombre(txtNombre.getText().toString());
            datosNuevosInformacion.add(nuevaInfo);

        }
    }

    //PROCESO SECUNDARIO
    //==========================================================================
    final class ProcesoSecundario implements Runnable{

        @Override
        public void run() {
            while(contProgreso < 100){
                metodoEspera();
                manejadorProcesos.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(contProgreso);
                        //Validamos si se termino el conteo o el progreso
                        if(contProgreso == 100){
                            //Preparamos el mensaje para nuestra activity padre
                            Intent mensajePadre = new Intent();
                            mensajePadre.putExtra(TAG_MENSAJE, "¡Nombre Ingresado con éxito!");
                            setResult(RESULT_OK, mensajePadre);

                            //Cerramos la activity
                            finish();
                        }
                    }
                });
            }
        }

        private void metodoEspera() {
            try {
                Thread.sleep(50);
                contProgreso++;
            }catch (Exception e){

            }
        }
    }
}