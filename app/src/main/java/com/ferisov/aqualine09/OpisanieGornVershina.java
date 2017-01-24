package com.ferisov.aqualine09;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 008-0814 on 07.10.2016.
 */

public class OpisanieGornVershina extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.opisanie_gor_vershina);

        TextView textViewOpis = (TextView) findViewById(R.id.textViewOpis3);
        textViewOpis.setText("Горная Вершина : \n" +
                "НАСТОЯЩАЯ ГОРНАЯ ВОДА – добывается \n" +
                "на высоте 1100 м над уровнем моря в \n" +
                "пос.Нижний Архыз (Архызское ущелье, \n" +
                "Карачаево-Черкесия). Рекомендована \n" +
                "Роспотребнадзором РФ для употребления\n" +
                "детьми с первых дней жизни, детей более" +
                "старшего возраста и взрослых.\n " +
                "Лучшая вода 2011 года!\n");

        Button buttonOk1 = (Button) findViewById(R.id.buttonOk3);
        buttonOk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
