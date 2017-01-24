package com.ferisov.aqualine09;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 008-0814 on 07.10.2016.
 */

public class OpisanieGemchug extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.opisanie_gemchug);

        TextView textViewOpis = (TextView) findViewById(R.id.textViewOpis4);
        textViewOpis.setText("Жемчужина Кавказа: \n" +
            "Питьевая вода высшей категории из зоны\n" +
            "лесных массивов Карачаево-Черкесии.\n" +
            "Добывается в поселке Буково \n" +
            "(Карачаево-Черкесия),окруженном \n" +
            "нетронутыми буковыми и сосновыми лесами.\n" );

        Button buttonOk1 = (Button) findViewById(R.id.buttonOk4);
        buttonOk1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            finish();
        }
    });
}


}
