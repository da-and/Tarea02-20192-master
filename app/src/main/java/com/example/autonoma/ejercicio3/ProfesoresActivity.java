package com.example.autonoma.ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.autonoma.ejercicio3.adapter.MainAdapter;
import com.example.autonoma.ejercicio3.api.usuarioApi;
import com.example.autonoma.ejercicio3.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ProfesoresActivity extends AppCompatActivity {

    EditText etNombre, etApellido;
    Button btnGrebar;
    ArrayList Profesores;
    ListView lvProfesores;
    String nombreCompleto;

    ArrayAdapter<String> adapter;
    usuarioApi usuario;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        //fin onCreate




        //
        etNombre= findViewById(R.id.etNombre);
        etApellido= findViewById(R.id.etApellido);
        btnGrebar= findViewById(R.id.btnAgregar);
        lvProfesores = findViewById(R.id.lvProfesores);
        // inicializamos el array
        Profesores = new ArrayList<String>();
        //adaptadoir
        adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Profesores);
        //asignamos adaptador al list view
       // lvProfesores.setAdapter(adapter);



        //
        btnGrebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profesores.add("Nombre: " + etNombre.getText().toString() + "   " + "Apellido: " + etApellido.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });//fin setOnClickListener

        retrofit = new MainAdapter().getRetrofit();
        usuario = retrofit.create(usuarioApi.class);





    } // Fin onCreate




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

        menu.setHeaderTitle("Profesor:" + Profesores.get(info.position));

        inflater.inflate(R.menu.menu_contextual,menu);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        switch(item.getItemId()){

            case R.id.menu_eliminar:

                Profesores.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;

        }

        return super.onContextItemSelected(item);
    }

    //mostramos el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;

    }
    //detectar click


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            //inicio case add_item
            case R.id.menu_add_item:
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Agregar Item",
                        Toast.LENGTH_LONG).show();
                //agregar item al listado
                Profesores.add("Profesor X");
                adapter.notifyDataSetChanged();

                return true;

            //inicio case refrescar
            case R.id.menu_refrescar:
                Toast.makeText(
                        ProfesoresActivity.this,
                        "Refrescar",
                        Toast.LENGTH_LONG).show();
                //refrecar el adaptador
                adapter.notifyDataSetChanged();

                return true;

            //inicio case Ver map
            case R.id.menu_vermapa:
                //TIP: Crear in activityt Plantilla Mapa
                //Lleva al Activity
                Intent intent = new Intent(ProfesoresActivity.this,MainActivity2.class);
                startActivity(intent);

                Toast.makeText(
                        ProfesoresActivity.this,
                        "Ver Mapa",
                        Toast.LENGTH_LONG).show();

                return true;

            //inicio case Cerrar
            case R.id.menu_cerrar:
                //llevarte al mainActivity 
                //

                Intent intent2 = new Intent(ProfesoresActivity.this,MainActivity.class);
                startActivity(intent2);


                Toast.makeText(
                        ProfesoresActivity.this,
                        "Cerrar Sesión",
                        Toast.LENGTH_LONG).show();
                return true;
            //

            default:
                return super.onOptionsItemSelected(item);
        }
        //
    }
} // Fin ProfesoresActivity





/*
*
* // Inflamos el layout del menu de opciones

// Manejamos eventos click en el menu de opciones
@Override
public boolean onOptionsItemSelected(MenuItem item) {
   switch (item.getItemId()) {
       case R.id.add_item:
           // Añadimos nuevo nombre
           this.alummnos.add("Added nº" + (++contador));
           // Notificamos al adaptador del cambio producido
           this.miAdaptador.notifyDataSetChanged();
           return true;
       default:
           return super.onOptionsItemSelected(item);
   }
}


* */
