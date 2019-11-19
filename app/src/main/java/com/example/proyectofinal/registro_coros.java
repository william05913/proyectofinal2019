package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class registro_coros extends AppCompatActivity {
    private AsyncHttpClient clientec = new AsyncHttpClient();
    private ListView lvdatosc;

    AlertDialog.Builder dialogo;
    EditText buscar;

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
        setContentView(R.layout.activity_registro_coros);

        lvdatosc = findViewById(R.id.lvDatosRc);
        buscar = findViewById(R.id.buscarc);
        clientec = new AsyncHttpClient();


        obtenerCoros();

    }
    private void obtenerCoros(){
        String url = "https://proyectofinalsis21.000webhostapp.com/obtenerDatosCoro.php";
        clientec.post(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200){
                    listarCoros(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    private  void listarCoros(String respuesta){
        final ArrayList<Coros> lista = new ArrayList<Coros>();
        try{
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for (int i=0; i<jsonArreglo.length(); i++){
                Coros a = new Coros();
                a.setId(jsonArreglo.getJSONObject(i).getInt("id_c"));
                a.setTitulo(jsonArreglo.getJSONObject(i).getString("titulo"));
                a.setAutor(jsonArreglo.getJSONObject(i).getString("autor"));
                a.setLetra(jsonArreglo.getJSONObject(i).getString("letra"));

                lista.add(a);

            }
            final ArrayAdapter<Coros> a = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, lista);
            lvdatosc.setAdapter(a);


            buscar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    a.getFilter().filter(s);
                }

    }

