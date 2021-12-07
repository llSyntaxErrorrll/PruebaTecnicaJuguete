package com.JuanFelipe.PruebaTecnicaJuguete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //declaracion de variables
    private TextView txtResultado;
    private RelativeLayout lyCapturar;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicia funcionalidad
        init();
    }

    private void init(){
        //inicia vistas y variable
        txtResultado = findViewById(R.id.txt_resultado);
        lyCapturar = findViewById(R.id.ly_capturar);
        userName = "";
        //inicia eventos click
        setOnClickListeners();
    }

    private void hablar(){
        cambiarVista(true);
        txtResultado.setText(getString(R.string.rs_hablar));
    }
    private void contar(){
        cambiarVista(true);
        txtResultado.setText(getString(R.string.rs_contar));
    }
    private void dormir(){
        cambiarVista(true);
        txtResultado.setText(getString(R.string.rs_dormir));
    }
    private void capturar(){
        cambiarVista(false);
        txtResultado.setText(getString(R.string.rs_capturar));
    }
    private void decir(){
        cambiarVista(true);
        if(!userName.equals("")){
            txtResultado.setText(userName);
        }else{
            txtResultado.setText(getString(R.string.rs_decir));
        }
    }

    private void guardarNombre(){
        //obtiene y guarda el nombre
        TextInputLayout txtNombre = findViewById(R.id.txt_nombre);
        String nombre = txtNombre.getEditText().getText().toString();
        userName = nombre;

        //cambia la vista y el texto
        cambiarVista(true);
        txtResultado.setText(getString(R.string.app_resultado));

        //muestra mensaje y muestra nombre
        Toast.makeText(this, getString(R.string.nombre_guardado), Toast.LENGTH_SHORT).show();
        decir();
    }

    private void cambiarVista(boolean showResultado){
        //funcion para si quiere mostrar resultado es true, sino entonces muestra capturar
        if(showResultado){
            txtResultado.setVisibility(View.VISIBLE);
            lyCapturar.setVisibility(View.GONE);
        }else{
            txtResultado.setVisibility(View.GONE);
            lyCapturar.setVisibility(View.VISIBLE);
        }
    }

    private void setOnClickListeners(){
        //boton hablar
        Button btnHablar = findViewById(R.id.btn_hablar);
        btnHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hablar();
            }
        });

        //boton contar
        Button btnContar = findViewById(R.id.btn_contar);
        btnContar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contar();
            }
        });

        //boton dormir
        Button btnDormir = findViewById(R.id.btn_dormir);
        btnDormir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dormir();
            }
        });

        //boton capturar
        Button btnCapturar = findViewById(R.id.btn_capturar);
        btnCapturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturar();
            }
        });

        //boton decir
        Button btnDecir = findViewById(R.id.btn_decir);
        btnDecir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decir();
            }
        });

        //boton aceptar
        Button btnAceptar = findViewById(R.id.btn_aceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarNombre();
            }
        });
    }
}