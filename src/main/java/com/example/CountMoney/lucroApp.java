package com.example.CountMoney;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class lucroApp extends Fragment {

    public lucroApp() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_tab3, container, false);

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
