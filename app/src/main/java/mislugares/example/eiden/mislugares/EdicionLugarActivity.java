package mislugares.example.eiden.mislugares;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Eiden on 26/01/2018.
 */

public class EdicionLugarActivity extends AppCompatActivity {
    private EditText nombre;
    private Spinner tipo;
    private EditText direccion;
    private EditText telefono;
    private EditText url;
    private EditText comentario;
    private long id;
    private Lugar lugar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicion_lugar);
        Bundle extras = getIntent().getExtras();
        lugar = MainActivity.lugares.elemento((int) id);
        nombre = (EditText) findViewById(R.id.nombre);
        nombre.setText(lugar.getNombre());
        direccion = (EditText) findViewById(R.id.direccion);
        direccion.setText(lugar.getDireccion());
        telefono = (EditText) findViewById(R.id.telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));
        url = (EditText) findViewById(R.id.url);
        url.setText(lugar.getUrl());
        comentario = (EditText) findViewById(R.id.comentario);
        comentario.setText(lugar.getComentario());
        tipo = (Spinner) findViewById(R.id.tipo);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        tipo.setAdapter(adaptador);
        tipo.setSelection(lugar.getTipo().ordinal());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edicion_lugar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_cancelar:
                return true;
            case R.id.accion_guardar:
                lanzarguardarLugar(0);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void lanzarguardarLugar(int id){
        lugar.setNombre(nombre.getText().toString());
        lugar.setTipo(TipoLugar.values()[tipo.getSelectedItemPosition()]);
        lugar.setDireccion(direccion.getText().toString());
        lugar.setTelefono(Integer.parseInt(telefono.getText().toString()));
        lugar.setUrl(url.getText().toString());
        lugar.setComentario(comentario.getText().toString());
        finish();
    }
}