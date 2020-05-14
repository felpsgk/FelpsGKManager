package com.example.CountMoney;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class alcVSgas extends Fragment {

    private TextInputLayout txtGas;
    private TextInputLayout txtAlc;
    private TextView txtResṕosta;
    private Button btnCalc;

    public alcVSgas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //NESTA TELA SE CALCULA COM QUAL COMBUSTIVEL É MELHOR ABASTECER.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        txtGas = v.findViewById(R.id.txtGasolina);
        txtAlc = v.findViewById(R.id.txtAlcool);
        btnCalc = v.findViewById(R.id.btnCalc);
        txtResṕosta = v.findViewById(R.id.txtResṕosta);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat df =  new DecimalFormat("0.000");

                double alcool = Double.parseDouble(txtAlc.getEditText().getText().toString());
                double gasolina = Double.parseDouble(txtGas.getEditText().getText().toString());
                double razao = alcool / gasolina;

                if (razao < 0.685) {
                    txtResṕosta.setText("Relação alc/gas = %" + df.format(razao) + "\nAbasteça com álcool.");
                } else {
                    txtResṕosta.setText("Relação alc/gas = %" + df.format(razao) + "\nAbasteça com gasolina.");
                }
            }
        });


        return v;
    }
}
