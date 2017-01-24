package com.ferisov.aqualine09;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 008-0814 on 07.10.2016.
 */

public class OpisanieLegendaGor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.opisanie_legenda_gor);

        TextView textViewOpis = (TextView) findViewById(R.id.textViewOpis2);
        textViewOpis.setText("Легенда гор: \n" +
                "Минеральная столовая питьевая вода \n" +
                "«Легенда гор»  происходит из талых \n" +
                "вод кавказских ледников. В ее составе\n" +
                "16 макро и микро элементов,  необходимых\n" +
                "для жизнедеятельности организма \n" +
                "человека. При этом она имеет малую \n" +
                " жесткость и минерализацию и \n " +
                "рекомендована Пятигорским НИИ \n " +
                "Курортологии к ежедневному употреблению " +
                "без ограничений. \n");

        Button buttonOk1 = (Button) findViewById(R.id.buttonOk2);
        buttonOk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
