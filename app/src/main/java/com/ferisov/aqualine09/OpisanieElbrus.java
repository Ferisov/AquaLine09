package com.ferisov.aqualine09;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 008-0814 on 06.10.2016.
 */

public class OpisanieElbrus extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.opisanie_elbrus);

        TextView textViewOpis = (TextView) findViewById(R.id.textViewOpis1);
        textViewOpis.setText("Эльбрусинка детская: \n" +
                "1. Разливается только в НОВУЮ БУТЫЛЬ! \n" +
                "2. Специальная вода для детей – с первых \n" +
                "дней жизни и до подросткового возраста. \n" +
                "Вода Эльбрусинка ДЕТСКАЯ –содержит 16  \n" +
                "природных макро и микроминералов, \n" +
                "которые нужны растущему организму \n" +
                "как кирпичи для стройки дома.");

        Button buttonOk1 = (Button) findViewById(R.id.buttonOk1);
        buttonOk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
