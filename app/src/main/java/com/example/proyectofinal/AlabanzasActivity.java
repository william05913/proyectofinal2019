package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AlabanzasActivity extends AppCompatActivity {

    private EditText ettitulo, etautor, etletra;
    private Button btnRegistrar;
    private AsyncHttpClient cliente = new AsyncHttpClient();
    private ListView lvdatos;

    AlertDialog.Builder dialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alabanzas);
    }
}
