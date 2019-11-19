package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_close)
                    .setTitle("Advertencia")
                    .setIcon(R.drawable.ic_close)
                    .setMessage("¿Realmente desea salir?")
                    .setNegativeButton(android.R.string.cancel, null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
            return true;
        }
        //para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coros);

        ettituloc = findViewById(R.id.ettituloc);
        etautorc = findViewById(R.id.etautorc);
        etletrac = findViewById(R.id.etletrac);

        btnRegistrarc = findViewById(R.id.btnRegistrarC);

        lvdatosc = findViewById(R.id.lvDatosRc);

        clientec = new AsyncHttpClient();

        almacenarCoros();
    }
}
