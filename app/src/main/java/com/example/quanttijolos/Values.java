package com.example.quanttijolos;

public class Values {
    public double largura, altura, quantitativo, argamassa, orcamentotij,orcamentoarg,altTIJ,largTIJ,precTIJ,argTIJ;
    public int furos, tamanho;

    public void QuantTijolo(int fur, String taman){

            if(fur == 6 && taman=="Pequeno"){
                Values values1 = new Values();
                values1.precTIJ = 0.69;
                values1.largTIJ = 0.24;
                values1.altTIJ = 0.14;
                orcamentoarg = 2;
                quantitativo = (float) (largura * altura / ((largTIJ + 0.015) * (altTIJ+0.015)));
                argamassa  = ((largura * altura) - quantitativo * (largTIJ * altTIJ)) * 0.09;
            }

        System.out.println(orcamentoarg);


    }
}
