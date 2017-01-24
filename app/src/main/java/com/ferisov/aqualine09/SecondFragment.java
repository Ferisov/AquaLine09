package com.ferisov.aqualine09;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 008-0814 on 26.09.2016.
 */
public class SecondFragment extends Fragment {
    private final String stoim = "130 руб.";
    String nashNomer = " +7(928)922-86-86";

    private Context context;
    //Кнопка -
    private Button buttonDel2;
    // Кнопка +
    private Button buttonAdd2;
    // Количество
    private TextView textViewKol2;
    // Счетчик
    private int count = 0;
    // Кнопка заказать
    private Button buttonBy2;

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //задаем разметку фрагменту
        final View view = inflater.inflate(R.layout.second, container, false);
        //ну и контекст, так как фрагменты не содержат собственного
        context = view.getContext();
        //выводим текст который хотим
        TextView wordsCount = (TextView) view.findViewById(R.id.textViewZaglavie2);

        // Количество
        textViewKol2 = (TextView) view.findViewById(R.id.textViewKol2);
        textViewKol2.setText("0");

        // Номер на активити
        TextView textViewNomer = (TextView) view.findViewById(R.id.textViewNomer2);
        textViewNomer.setText(nashNomer);

        // Цена
        TextView textViewStoim = (TextView) view.findViewById(R.id.textViewStoim2);
        textViewStoim.setText(stoim);

        //Knopka opisanie
        Button buttonOpis = (Button) view.findViewById(R.id.buttonOpis2);
        buttonOpis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), OpisanieLegendaGor.class);
                startActivity(intent);
            }
        });

        // Кнопка +
        buttonAdd2 = (Button) view.findViewById(R.id.buttonAdd2);
        buttonAdd2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                count = ++count;
                textViewKol2.setText(String.valueOf(count));
            }
        });

        //Кнопка -
        buttonDel2 = (Button) view.findViewById(R.id.buttonDel2);
        buttonDel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    count = --count;
                    textViewKol2.setText(String.valueOf(count));
                }
            }
        });

        // Кнопка заказать
        buttonBy2 = (Button) view.findViewById(R.id.buttonBy2);
        buttonBy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;

                try {
                    File file = new File(context.getFilesDir(), MainActivity.FILENAME);
                    //Проверяем существуеи ли файл, если нет то создаем
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    BufferedReader br = new BufferedReader(new FileReader(file));
                    str = br.readLine();
                    // Переход на Активность для ввода номера
                    if (str == null) {
                        Intent intent = new Intent(view.getContext(), Telefon.class);
                        startActivity(intent);
                    }
                    else  {
                        // Запускаем поток для отправки данных на сервер.
                        SecondFragment.MyTask mt = new SecondFragment.MyTask();
                        mt.execute(str);
                        Toast toast = Toast.makeText(getContext(), "Ваш заказ отправлен", Toast.LENGTH_SHORT );
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                catch (FileNotFoundException e){
                    System.out.println("FAIL NE SOZDAN");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        return view;
    }

    // Кдасс для создания нового потока, при отправке данных на сервер
    class MyTask  extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            // указываем адрес вашего сервера и путь принимающего скрипта
            HttpPost httppost = new HttpPost("http://aqualine09.ru/send.php");

            try {
                List nameValuePairs = new ArrayList(2);
                String elbrusinka = "Elbrusinka detskay"+ " "+ count + " ";
                for (String x : params) {
                    // Передоваемые данные
                    nameValuePairs.add(new BasicNameValuePair("Name", elbrusinka));
                    nameValuePairs.add(new BasicNameValuePair("Tel", x));
                }
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost); // отправка на сервер
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}
