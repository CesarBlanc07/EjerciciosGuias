package sv.edu.utec.ejercicio3_guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    ListView ListaPais;
    ArrayAdapter<CharSequence> adaptador;
    TextView Mensaje;
    List <String> seleccion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaPais = findViewById(R.id.lvDias);
        Mensaje = findViewById(R.id.tvPaises);

        adaptador = ArrayAdapter.createFromResource(this,R.array.arregloPaises, android.R.layout.simple_list_item_multiple_choice);
        ListaPais.setAdapter(adaptador);
        ListaPais.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ListaPais.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                SparseBooleanArray checked = ListaPais.getCheckedItemPositions();
                seleccion.clear();

                for (int i = 0; i < checked.size(); i++)
                {
                    int positionChecked = checked.keyAt(i);
                    if (checked.valueAt(i))
                    {
                        seleccion.add(adaptador.getItem(positionChecked).toString());
                    }
                }

                String elementos = "";
                for (String elemento : seleccion)
                {
                    elementos += elemento + "  ";
                }
                Mensaje.setText(elementos);
            }
        });
    }
}