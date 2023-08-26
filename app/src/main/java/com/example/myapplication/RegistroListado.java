package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroListado extends AppCompatActivity {

    private TextView alumno01;
    private TextView escuela01;
    private TextView carrera01;
    private TextView carrera;
    private TextView gastosAdi;
    private TextView gastosAdiCosto;
    private TextView pension;
    private TextView cuotas;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_listado);

        alumno01 = (TextView) findViewById(R.id.textView11);
        String dato= getIntent().getStringExtra("dato");
        alumno01.setText("ALUMNO: "+ dato);

        escuela01 = (TextView) findViewById(R.id.textView17) ;
        String dato1= getIntent().getStringExtra("dato1");
        escuela01.setText("ESCUELA: "+ dato1);

        carrera01 = (TextView) findViewById(R.id.textView22) ;
        String dato2= getIntent().getStringExtra("dato2");
        carrera01.setText("COSTO DE CARRERA: "+ dato2);

        carrera = (TextView) findViewById(R.id.textView18) ;
        String dato3= getIntent().getStringExtra("dato3");
        carrera.setText("CARRERA: "+ dato3);

        gastosAdi = (TextView) findViewById(R.id.textView19) ;
        String dato4= getIntent().getStringExtra("dato4");
        gastosAdi.setText( dato4);

        gastosAdiCosto = (TextView) findViewById(R.id.textView24) ;
        String dato5= getIntent().getStringExtra("dato5");
        gastosAdiCosto.setText("GASTOS ADICIONALES "+ dato5);

        gastosAdiCosto = (TextView) findViewById(R.id.textView20) ;
        String dato05= getIntent().getStringExtra("dato5");
        gastosAdiCosto.setText("MONTO GASTO ADICIONAL: "+ dato05);

        pension = (TextView) findViewById(R.id.textView23) ;
        String dato6= getIntent().getStringExtra("dato6");
        pension.setText("PENSION: "+ dato6);

        cuotas = (TextView) findViewById(R.id.textView21) ;
        String dato7= getIntent().getStringExtra("dato7");
        cuotas.setText( dato7);

        cuotas = (TextView) findViewById(R.id.textView25) ;
        String dato8= getIntent().getStringExtra("dato8");
        cuotas.setText( "TOTAL PAGAR: "+dato8);


    }

    //metodo volver
    public void volver(View v){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }
}