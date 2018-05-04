//BY: Gutierrez Merida Cristhian David
package com.example.cerbe.ejercicio1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOGTAG="INFO";
    EditText cNombre,cApellido,cNumCuenta,cCorreo;
    CheckBox cGenero1,cGenero2,cFacultad1,cFacultad2,cFacultad3,cFacultad4,cFacultad5;
    Button btnEnviar;
    int valGenero,valFacultad;
    Alumno alumno;
    String genero,facultad;
    Context contexto=this;
    VerificarEmail verifica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cNombre = (EditText) findViewById(R.id.etNombre);
        cApellido = (EditText) findViewById(R.id.etApellido);
        cNumCuenta = (EditText) findViewById(R.id.etNumCuenta);
        cCorreo = (EditText) findViewById(R.id.etCorreo);
        cGenero1 = (CheckBox) findViewById(R.id.cbGenero1);
        cGenero2 = (CheckBox) findViewById(R.id.cbGenero2);
        cFacultad1 = (CheckBox) findViewById(R.id.cbFacultad1);
        cFacultad2 = (CheckBox) findViewById(R.id.cbFacultad2);
        cFacultad3 = (CheckBox) findViewById(R.id.cbFacultad3);
        cFacultad4 = (CheckBox) findViewById(R.id.cbFacultad4);
        cFacultad5 = (CheckBox) findViewById(R.id.cbFacultad5);
        btnEnviar = (Button) findViewById(R.id.bnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valGenero=0;
                valFacultad=0;

                //Valida Nombre
                if(cNombre.length()==0){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeNom),Toast.LENGTH_SHORT).show();
                }

                //Valida Apellido
                if(cApellido.length()==0){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeApell),Toast.LENGTH_SHORT).show();
                }

                //Valida Numero de cuenta
                if(cNumCuenta.length()!=10){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeNum),Toast.LENGTH_SHORT).show();
                }

                //Valida Correo
                verifica = new VerificarEmail(cCorreo.getText().toString());
                if(verifica.verifica()!=true){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeCorreo),Toast.LENGTH_SHORT).show();
                }

                //Valida Genero
                if(cGenero1.isChecked()==true){
                    valGenero++;
                    genero=cGenero1.getText().toString();
                }
                if(cGenero2.isChecked()==true){
                    valGenero++;
                    genero=cGenero2.getText().toString();
                }
                if(valGenero!=1){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeGenero),Toast.LENGTH_SHORT).show();
                }


                //Valida Facultad
                if(cFacultad1.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad1.getText().toString();
                }
                if(cFacultad2.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad2.getText().toString();
                }
                if(cFacultad3.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad3.getText().toString();
                }
                if(cFacultad4.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad4.getText().toString();
                }
                if(cFacultad5.isChecked()==true){
                    valFacultad++;
                    facultad=cFacultad5.getText().toString();
                }

                if(valFacultad!=1){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensajeFac),Toast.LENGTH_SHORT).show();
                }


                //Toast Alumno y LOGTAG
                if(valGenero==1 && valFacultad==1 && cNumCuenta.length()==10 && cNombre.length()!=0 && cApellido.length()!=0 && verifica.verifica()==true){
                    alumno = new Alumno(cNombre.getText().toString(),cApellido.getText().toString(),
                            Long.parseLong(cNumCuenta.getText().toString()),cCorreo.getText().toString(),
                            genero,facultad,contexto);

                    Toast.makeText(getApplicationContext(),alumno.toString(),Toast.LENGTH_LONG).show();
                    Log.i(LOGTAG, alumno.toString());
                }
            }
        });
    }
}
