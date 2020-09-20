package com.uso.guia03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int ID_ENCUESTA = 1;
    Button btnVerLista;
    Button btnMisDatos;
    Button btnAgregarNombre;
    Boolean bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnVerLista = findViewById(R.id.btnVerLista);
        this.btnMisDatos = findViewById(R.id.btnDatos);
        this.btnAgregarNombre = findViewById(R.id.btnAgregarNombre);
        this.bandera = false;
    }

    public void onActivityResult(int requestcode, int resultcode, Intent data ){
        super.onActivityResult(requestcode, resultcode, data);

        //Verificamos quien nos contesto de nuestras activitys hijas
        switch (requestcode){
            case ID_ENCUESTA:
                //Validamos como finalizo el proceso de la activity hija
                if(RESULT_OK == resultcode){
                    //Procesamos el mensaje
                    String msjActivityHija =  data.getStringExtra(AgregarNombre.TAG_MENSAJE);
                    Toast.makeText(this, msjActivityHija, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public void btnMisDatos_onClick(View v){
        Intent misDatos = new Intent(this, MisDatos.class);
        startActivity(misDatos);
    }
    public void btnVerLista_onClick(View v){
        if (bandera){
            Intent i = new Intent(this,VerLista.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "¡Primero debe ingresar datos, antes de ver la lista!", Toast.LENGTH_SHORT).show();
        }

    }
    public void btnAgregarNombre_onClick(View v){
        bandera=true;
        Intent i = new Intent(this, AgregarNombre.class);
        startActivityForResult(i, ID_ENCUESTA);
    }
}