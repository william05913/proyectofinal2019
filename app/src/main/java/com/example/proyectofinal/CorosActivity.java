package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;

public class CorosActivity extends AppCompatActivity {

    private EditText ettituloc, etautorc, etletrac;
    private Button btnRegistrarc;
    private AsyncHttpClient clientec = new AsyncHttpClient();
    private ListView lvdatosc;

    AlertDialog.Builder dialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coros);
    }
}
