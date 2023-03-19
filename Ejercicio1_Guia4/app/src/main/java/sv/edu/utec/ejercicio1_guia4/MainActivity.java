package sv.edu.utec.ejercicio1_guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private ArrayList<Personas> listapersonas;
    ListView lista;
    Integer[]Imgpersonas={
            R.drawable.abraham,
            R.drawable.casimiro,
            R.drawable.daniela,
            R.drawable.felicita,
            R.drawable.francisco,
            R.drawable.humberto,
            R.drawable.jose,
            R.drawable.juana,
            R.drawable.maria,
            R.drawable.matilde,
            R.drawable.nicolas,
            R.drawable.patricia
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listapersonas=new ArrayList<Personas>();
        listapersonas.add(new Personas("Abraham",'M'));
        listapersonas.add(new Personas("Casimiro",'M'));
        listapersonas.add(new Personas("Daniela",'F'));
        listapersonas.add(new Personas("Felicita",'F'));
        listapersonas.add(new Personas("Francisco",'M'));
        listapersonas.add(new Personas("Humberto", 'M'));
        listapersonas.add(new Personas("Jose",'M'));
        listapersonas.add(new Personas("Juana",'F'));
        listapersonas.add(new Personas("Maria",'F'));
        listapersonas.add(new Personas("Matilde",'F'));
        listapersonas.add(new Personas("Nicolas",'M'));
        listapersonas.add(new Personas("Patricia",'M'));
        AdaptadorPersona adaptador = new AdaptadorPersona(this);
        lista = findViewById(R.id.lvLista);
        lista.setAdapter(adaptador);
    }

    class AdaptadorPersona extends ArrayAdapter<Personas>
    {
        AppCompatActivity appCompatActivity;

        AdaptadorPersona(AppCompatActivity context)
        {
            super(context, R.layout.persona, listapersonas);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.persona, null);

            TextView textView1 = item.findViewById(R.id.tvNombres);
            textView1.setText(listapersonas.get(position).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imvFoto);
            imageView1.setImageResource(Imgpersonas[position]);

            return item;
        }
    }
}