package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText alumno;
    private EditText escuela;
    private EditText carrera;
    private Spinner selccion ;
    private CheckBox Biblioteca;
    private CheckBox Medio;
    private TextView costoCarrera;
    private TextView gastosAdi;
    private EditText gastosAdicionales;
    private RadioButton cuota4;
    private RadioButton cuota5;
    private RadioButton cuota6;
    private EditText pension;
    private TextView pensionText;
    private Button calcular;
    private EditText total;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alumno = (EditText)findViewById(R.id.extAlumno);
        escuela = (EditText)findViewById(R.id.editTextEscuela);
        selccion= (Spinner) findViewById(R.id.spinner);
        costoCarrera= (EditText) findViewById(R.id.CostoCarrera);
        carrera= (EditText) findViewById(R.id.editTextTextCarrera);
        Biblioteca=(CheckBox) findViewById(R.id.checkBoxBiblioteca);
        Medio=(CheckBox) findViewById(R.id.checkBoxMedio);
        gastosAdi=(TextView) findViewById(R.id.textView9) ;
        gastosAdicionales=(EditText) findViewById(R.id.GastosAdicionales) ;
        cuota4 =(RadioButton) findViewById(R.id.rbtn4);
        cuota5 =(RadioButton) findViewById(R.id.rbtn5);
        cuota6 =(RadioButton) findViewById(R.id.rbtn6);
        pension = (EditText)findViewById(R.id.Pension);
        pensionText=(TextView) findViewById(R.id.textView12) ;

        calcular=(Button) findViewById(R.id.button8) ;
        total=(EditText) findViewById(R.id.Total);



        String [] opciones= {"Eligue tu Carrera","Tecnologías de la Información", "Administración", "Sistemas"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        selccion.setAdapter(adapter);

        selccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_LONG).show();
                carrera.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularCuota();
                Calcular();

            }
        });






    }

    //metodo radio boton
    public void CalcularCuota() {
        if (cuota4.isChecked() == true) {
            int resultado01 = ((3000) + ((3000 * 12) / 100)) / 4;
            int cotaReal=4;
            String pension01 = String.valueOf(resultado01);
            pension.setText("$/."+pension01);

            String cot = String.valueOf(cotaReal);
            pensionText.setText("NUMERO DE CUOTAS: "+cot);

        } else if (cuota5.isChecked() == true) {
            int resultado02 = ((3000) + ((3000 * 12) / 100)) / 5;
            int cotaReal=5;
            String pension02 = String.valueOf(resultado02);
            pension.setText("$/."+pension02);

            String cot = String.valueOf(cotaReal);
            pensionText.setText("NUMERO DE CUOTAS: "+cot);

        } else if (cuota6.isChecked() == true) {
            int resultado03 = ((3000) + ((3000 * 12) / 100)) / 6;
            int cotaReal=6;
            String pension03 = String.valueOf(resultado03);
            pension.setText("$/."+pension03);

            String cot = String.valueOf(cotaReal);
            pensionText.setText("NUMERO DE CUOTAS: "+cot);

        }
    }

    //metodos calcular
    public void Calcular(){
        //Seleciones
        String sel = selccion.getSelectedItem().toString();
        if (sel.equals("Eligue tu Carrera")){
            int CostoCa = 0;
            String resultado = String.valueOf(CostoCa);
            costoCarrera.setText("$/."+resultado);
        } else if (sel.equals("Tecnologías de la Información")){
            int CostoCa1 = 0 + 3000;
            String resultado1 = String.valueOf(CostoCa1);
            costoCarrera.setText("$/."+resultado1);
        } else if (sel.equals("Administración")) {
            int CostoCa2 = 0 + 3000;
            String resultado2 = String.valueOf(CostoCa2);
            costoCarrera.setText("$/."+resultado2);
        }  else if (sel.equals("Sistemas")){
            int CostoCa3 = 0 + 3000;
            String resultado3 = String.valueOf(CostoCa3);
            costoCarrera.setText("$/."+resultado3);
        }

    }
    //Metdodo check
    public void accion(View v){
        String seleccion = "";
        if (Biblioteca.isChecked()){
            int gasto01 = 25;
            int resl01 = ((3000) + ((3000 * 12) / 100)) / 25;
            seleccion = seleccion + Biblioteca.getText();
            gastosAdi.setText("GASTOS ADICIONALES: "+seleccion);

            String resultado01 = String.valueOf(gasto01);
            gastosAdicionales.setText("$/."+resultado01);

            //GASTO TOTAL
            String p = String.valueOf(resl01);
            total.setText("$/."+p);



        } else if  (Medio.isChecked()){
            int gasto02= 22;
            int resl02 = ((3000) + ((3000 * 12) / 100)) / 22;
            seleccion = seleccion + Medio.getText();
            gastosAdi.setText("GASTOS ADICIONALES: "+seleccion);

            String resultado02 = String.valueOf(gasto02);
            gastosAdicionales.setText("$/."+resultado02);

            //GASTO TOTAL
            String p = String.valueOf(resl02);
            total.setText("$/."+p);


    }
    }




    //metodo imprimir
    public void imprimir(View v){
        Intent imprimir = new Intent(this, RegistroListado.class);
        imprimir.putExtra("dato" , alumno.getText().toString());
        imprimir.putExtra("dato1" , escuela.getText().toString());
        imprimir.putExtra("dato2" , costoCarrera.getText().toString());
        imprimir.putExtra("dato3" , carrera.getText().toString());
        imprimir.putExtra("dato4" , gastosAdi.getText().toString());
        imprimir.putExtra("dato5" , gastosAdicionales.getText().toString());
        imprimir.putExtra("dato6" , pension.getText().toString());
        imprimir.putExtra("dato7" , pensionText.getText().toString());
        imprimir.putExtra("dato8" , total.getText().toString());
        startActivity(imprimir);
    }
}