package com.rqcode.agenda1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

// extrae parámetros
        Bundle parametros = getIntent().getExtras();
// guarda parámetros en variable string
        String nombre = parametros.getString("pNombre");
        String fecha = parametros.getString("pFecha", "Default").toString();
        String telefono = parametros.getString("pTelefono", "Default").toString();
        String email = parametros.getString("pEmail", "Default").toString();
        String descripcion = parametros.getString("pDescripcion", "Default").toString();
// crea objetos tv
        TextView tvNombre = (TextView) findViewById(R.id.NombreConfirmar);
        TextView tvFecha = (TextView) findViewById(R.id.FechaNacimientoConfirmar);
        TextView tvTelefono = (TextView) findViewById(R.id.TelefonoConfirmar);
        TextView tvEmail = (TextView) findViewById(R.id.EmailConfirmar);
        TextView tvdescripcion = (TextView) findViewById(R.id.DescripcionConfirmar);
// carga parámetros en tv
        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvdescripcion.setText(descripcion);
//*************************************************************************************
//**************           llama a editar datos                 ***********************
//*************************************************************************************
// crea objeto botón para enlazarlo con el de XML
        final Button btnEditar = (Button) findViewById(R.id.BotonConfirmar);
// crea función onclicklistener
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

    }
}
