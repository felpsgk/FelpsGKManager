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


public class custoViagem extends Fragment {

    private TextInputLayout txtKmGasto;
    private TextInputLayout txtPrecoCombust;
    private TextInputLayout txtGastoCarro;
    private TextView txtResṕostaGasto;
    private Button btnCalcGasto;

    public custoViagem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //NESTA TELA SE CALCULA O GASTO DE COMBUSTÍVEL DE UMA VIAGEM EM KM.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        txtKmGasto = v.findViewById(R.id.txtKmGasto);
        txtPrecoCombust = v.findViewById(R.id.txtPrecoCombust);
        txtGastoCarro = v.findViewById(R.id.txtGastoCarro);
        btnCalcGasto = v.findViewById(R.id.btnCalcularGasto);
        txtResṕostaGasto = v.findViewById(R.id.txtResṕostaGasto);

        btnCalcGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat df = new DecimalFormat("0.00");

                double kmGasto = Double.parseDouble(txtKmGasto.getEditText().getText().toString());
                double gastoCarro = Double.parseDouble(txtGastoCarro.getEditText().getText().toString());
                double precoCombustivel = Double.parseDouble(txtPrecoCombust.getEditText().getText().toString());
                double gastoFinal = (kmGasto / gastoCarro) * precoCombustivel;

                txtResṕostaGasto.setText("Em uma viagem de "+kmGasto+"KM, você gastará R$" + df.format(gastoFinal) + " de combustível de acordo com os valores fornecidos.");
            }
        });


        return v;
    }

}
