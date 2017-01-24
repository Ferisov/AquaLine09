package com.ferisov.aqualine09;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;

/**
 * Created by 008-0814 on 28.09.2016.
 */
//Класс активности для записи телефона в файл
public class Telefon  extends Activity {
    private Context context;
    EditText textPhone;
    Button buttonTel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.telefon);

        textPhone = (EditText) findViewById(R.id.editText);
        buttonTel = (Button) findViewById(R.id.buttonTel);
        buttonTel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    // Запись данных в файл
                    FileOutputStream outputStream = openFileOutput(MainActivity.FILENAME, Context.MODE_PRIVATE );
                    outputStream.write(textPhone.getText().toString().getBytes());
                    outputStream.close();

                    //Возврат на предыдущую активность
                    finish();
                }
                catch (Exception e){
                    System.out.println("OSHIBKA 1");
                }
            }
        });
    }
}
