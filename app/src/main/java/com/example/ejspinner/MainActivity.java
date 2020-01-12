package com.example.ejspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spOpciones;
    private TextView tvOpciones,tvOpciones1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recogemosTodo();
        //nos creamos un array con las opciones
        String[]opciones={"Madrid","Barcelona","Cadiz","Almeria","Sevilla"};
        //si queremos lo ordenamos por si ek array es dinamico
       // ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,opciones);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,R.layout.layout_spinner,opciones);
        spOpciones.setAdapter(adapter);
        ponerListener();
    }
    public void recogemosTodo(){
        spOpciones=(Spinner)findViewById(R.id.spOpciones);
        tvOpciones=(TextView)findViewById(R.id.tvOpciones);
        tvOpciones1=(TextView)findViewById(R.id.tvOpciones1);
    }
    public void verOpciones(View v){
        String seleccion=spOpciones.getSelectedItem().toString();
        tvOpciones.setText(seleccion);
    }
    public void ponerListener(){
        spOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvOpciones1.setText(spOpciones.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
