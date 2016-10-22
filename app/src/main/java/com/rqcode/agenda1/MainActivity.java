package com.rqcode.agenda1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_RESULT = 1000;
    @Override
    protected void onStart (){
        super.onStart();
       Toast msg = Toast.makeText(getApplicationContext(), "estamos en el on start", Toast.LENGTH_LONG);
        msg.setGravity(Gravity.BOTTOM, 0, 0);
        msg.show();
    }
    @Override
    protected void onStop () {
        super.onStop();
        Toast msg = Toast.makeText(getApplicationContext(), "estamos en el on stop", Toast.LENGTH_LONG);
        msg.setGravity(Gravity.BOTTOM, 0, 0);
        msg.show();
    }
    @Override
    protected void onResume (){
        super.onResume ();
        Toast msg = Toast.makeText(getApplicationContext(), "estamos en el on resume", Toast.LENGTH_LONG);
        msg.setGravity(Gravity.BOTTOM, 0, 0);
        msg.show();
    }
    @Override
    protected void onDestroy (){
        super.onDestroy ();
        Toast msg = Toast.makeText(getApplicationContext(), "estamos en el on destroy", Toast.LENGTH_LONG);
        msg.setGravity(Gravity.BOTTOM, 0, 0);
        msg.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast msg = Toast.makeText(getApplicationContext(), "estamos en el on create", Toast.LENGTH_LONG);
        msg.setGravity(Gravity.BOTTOM, 0, 0);
        msg.show();

//****************************************************************************************
//*******************        listener del botón siguiente     ****************************
//****************************************************************************************
        // crea objeto botón para enlazarlo con el de XML
        final Button BotonSiguiente = (Button) findViewById(R.id.btnSiguiente);
        // crea función onclicklistener
        BotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // crea objetos tv
                TextView tvNombre = (TextView) findViewById(R.id.tieNombre);
                DatePicker dpFecha = (DatePicker) findViewById(R.id.dpFechaNacimiento);
                TextView tvTelefono = (TextView) findViewById(R.id.tieTelefono);
                TextView tvEmail = (TextView) findViewById(R.id.tieEmail);
                TextView tvdescripcion = (TextView) findViewById(R.id.tieDescripcion);
                // crea intent
                Intent browserIntent = new Intent(MainActivity.this,ConfirmarDatos.class);
                 // carga parametros en el intent
                browserIntent.putExtra("pNombre",tvNombre.getEditableText().toString());
                browserIntent.putExtra("pFecha",String.format("%02d",dpFecha.getDayOfMonth())+"/"+
                            String.format("%02d", dpFecha.getMonth()) +"/"+String.format("%04d",dpFecha.getYear()));
                browserIntent.putExtra("pTelefono",tvTelefono.getEditableText().toString());
                browserIntent.putExtra("pEmail",tvEmail.getEditableText().toString());
                browserIntent.putExtra("pDescripcion",tvdescripcion.getEditableText().toString());
                // lanza actividad
                startActivityForResult(browserIntent, REQUEST_RESULT);
            }
        });
    }
}
