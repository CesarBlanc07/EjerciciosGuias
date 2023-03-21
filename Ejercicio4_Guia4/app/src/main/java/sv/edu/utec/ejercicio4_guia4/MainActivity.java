package sv.edu.utec.ejercicio4_guia4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List <Persona> personList = new ArrayList<>();
        personList.add(new Persona("Jose Tobar", 32, "San Salvador"));
        personList.add(new Persona("Magdalena Hernandez", 27, "Sonsonate"));
        personList.add(new Persona("Camilo Joya", 45, "San Miguel"));

        PersonaAdaptador adapter = new PersonaAdaptador(this, R.layout.persona_info, personList);

        ListView listView = findViewById(R.id.lvLista);
        listView.setAdapter(adapter);
    }

    public class PersonaAdaptador extends ArrayAdapter<Persona>
    {

        public PersonaAdaptador(@NonNull Context context, int resource, @NonNull List<Persona> objects)
        {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.persona_info, parent, false);
            }

            Persona gente = getItem(position);

            TextView nombre = convertView.findViewById(R.id.tvNombre);
            TextView edad = convertView.findViewById(R.id.tvEdad);
            TextView direccion = convertView.findViewById(R.id.tvDireccion);

            nombre.setText(gente.getNombre());
            edad.setText(String.format("Edad: %d", gente.getEdad()));
            direccion.setText(String.format("Dirección: %s", gente.getDireccion()));

            return convertView;
        }
    }

}