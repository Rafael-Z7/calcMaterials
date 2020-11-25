package com.example.quanttijolos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calcular = (Button) findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText HightEditText = (EditText) findViewById(R.id.HightEditText);
                EditText WidthEditText = (EditText) findViewById(R.id.WidthEditText);

                RadioGroup radioFuro = (RadioGroup) findViewById(R.id.radioFuro);
                RadioGroup radioTamanho = (RadioGroup) findViewById(R.id.radioTamanho);
                int altura = Integer.parseInt(HightEditText.getText().toString());
                int largura = Integer.parseInt(WidthEditText.getText().toString());

                int radioFuroSelected = radioFuro.getCheckedRadioButtonId();
                int radioTamanhoSelected = radioTamanho.getCheckedRadioButtonId();
                int furos;
                String tamanho;

                double precTIJ = 0, largTIJ = 0, altTIJ = 0;


                if(radioFuroSelected != 1 && radioTamanhoSelected != 1){
                    RadioButton furoSelected = findViewById(radioFuroSelected);
                    RadioButton tamanhoSelected = findViewById(radioTamanhoSelected);
                    furos = Integer.parseInt(furoSelected.getText().toString());
                    tamanho =  tamanhoSelected.getText().toString();
                    
                    if(furos == 6){
                        if(tamanho == "Pequeno"){
                             precTIJ = 0.42;
                             largTIJ = 0.19;
                             altTIJ = 0.14;
                        }else if(tamanho == "Médio"){
                            precTIJ = 0.69;
                            largTIJ = 0.24;
                            altTIJ = 0.14;
                        }else if(tamanho == "Grande"){
                            precTIJ = 0.69;
                            largTIJ = 0.29;
                            altTIJ = 0.14;
                        }
                    }else if(furos == 8){
                        if(tamanho == "Pequeno"){
                            precTIJ = 0.79;
                            largTIJ = 0.19;
                            altTIJ = 0.19;
                        }else if(tamanho == "Médio"){
                            precTIJ = 1.10;
                            largTIJ = 0.24;
                            altTIJ = 0.19;
                        }else if(tamanho == "Grande"){
                            precTIJ = 1.14;
                            largTIJ = 0.29;
                            altTIJ = 0.19;
                        }
                    }
                }

                float quantitativo, argamassa, orcamentotij,orcamentoarg;


                quantitativo = (float) (largura + altura / ((largTIJ + 0.015) * (altTIJ + 0.015)));
                argamassa = (float) ((float) ((largura * altura) - quantitativo * (largTIJ * altTIJ)) * 0.09);
                orcamentotij = (float) (quantitativo * precTIJ);
                orcamentoarg = (float) (argamassa * 453.33);

                float totalorc = orcamentoarg + orcamentotij;

                TextView  totalBlocksTextView = (TextView) findViewById(R.id.totalBlocksTextView);
                TextView  BudgetTextView = (TextView) findViewById(R.id.BudgetTextView);
                TextView ArgamassaBudgetTextView = (TextView) findViewById(R.id.ArgamassaBudgetTextView);
                TextView ArgamassaQuantTextView = (TextView) findViewById(R.id.ArgamassaQuantTextView);
                TextView TotalBudgetTextView = (TextView) findViewById(R.id.TotalBudgetTextView);

              totalBlocksTextView.setText(quantitativo + " unidades");
                BudgetTextView.setText(orcamentotij + "");
                ArgamassaBudgetTextView.setText(orcamentoarg + "");
                ArgamassaQuantTextView.setText(argamassa + "m3");


            }
        });



    }
}