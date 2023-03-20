package sv.edu.utec.ejercicio2_guia4;

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
    private ArrayList<Frutas> listafrutas;
    ListView lista;
    Integer[] imaFrutas ={
            R.drawable.ahuacate,
            R.drawable.arandano,
            R.drawable.banana,
            R.drawable.cereza,
            R.drawable.ciruela,
            R.drawable.durazno,
            R.drawable.frambuesa,
            R.drawable.fresa,
            R.drawable.granada,
            R.drawable.guayaba,
            R.drawable.kiwi,
            R.drawable.licha,
            R.drawable.limon,
            R.drawable.mandarina,
            R.drawable.mango,
            R.drawable.manzana,
            R.drawable.manzanaverde,
            R.drawable.melocoton,
            R.drawable.melon,
            R.drawable.naranja,
            R.drawable.papaya,
            R.drawable.pera,
            R.drawable.pina,
            R.drawable.sandia,
            R.drawable.uva
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listafrutas=new ArrayList<Frutas>();
        listafrutas.add(new Frutas("Aguacate","Con forma de pera, en su interior contiene una única semilla redondeada de color claro."));
        listafrutas.add(new Frutas("Arandano","Es una baya globosa, de unos 6mm de diámetro y de color negro azulado."));
        listafrutas.add(new Frutas("Banana","Tiene forma alargada o ligeramente curvada, de 100-200 g de peso."));
        listafrutas.add(new Frutas("Cereza","El fruto es una drupa de unos 2 cm de diámetro, cuyo color oscila desde el rojo claro hasta el morado oscuro."));
        listafrutas.add(new Frutas("Ciruela","El fruto es redondo u oval recubierto por una cera blanquecina, de color amarillo, rojo o violáceo"));
        listafrutas.add(new Frutas("Durazno", "Mide de cinco a siete centímetros y medio y es de color amarillento, con tonalidades rojizas en la parte donde pega el sol."));
        listafrutas.add(new Frutas("Frambuesa","Es una fruta pequeña, cónica o redondeada con una piel aterciopelada de color rojo o amarillento."));
        listafrutas.add(new Frutas("Fresa","Es una fruta de forma cónica o casi redonda, de tamaño variable según la especie (de 15 a 22 mm de diámetro)"));
        listafrutas.add(new Frutas("Granada","De forma globosa, con diámetro de unos diez centímetros, y coronado por un tubo corto y con dientecitos."));
        listafrutas.add(new Frutas("Guayaba","Los frutos son redondos, un poco achatados en los polos, de color verde claro."));
        listafrutas.add(new Frutas("Kiwi","Es una baya con forma de elipse y cubierta de una piel repleta de vellosidades."));
        listafrutas.add(new Frutas("Licha","Tiene un color rojo visualmente atractivo, su cáscara es gruesa."));
        listafrutas.add(new Frutas("Limon","El jugo se usa para dar sabor a la comida y la bebida, y para prevenir el escorbuto."));
        listafrutas.add(new Frutas("Mandarina","Es muy parecida a la naranja, pero más pequeña y de forma esférica, contiene una pulpa dulce y jugosa que se divide en 10 ó 12 gajos"));
        listafrutas.add(new Frutas("Mango","Es una drupa que consta de una piel exterior, una porción carnosa comestible y un hueso central que encierra una sola semilla"));
        listafrutas.add(new Frutas("Manzana","La piel puede ser de color verde, amarilla o rojiza, y la pulpa, harinosa o crujiente"));
        listafrutas.add(new Frutas("Manzana Verde"," Este tipo de manzana es fácil de reconocer por su color verde intenso."));
        listafrutas.add(new Frutas("Melocoton"," es un fruto carnoso, de un color que oscila entre el blanco, amarillento, anaranjado o rojizo, dulce y aromático."));
        listafrutas.add(new Frutas("Melon","Pertenece al grupo de las cucurbitáceas, como el pepino, sandía, calabacita, entre otros"));
        listafrutas.add(new Frutas("Naranja","Es el fruto del naranjo dulce, árbol que pertenece al género Citrusde la familia de las rutáceas."));
        listafrutas.add(new Frutas("Papaya","Es conocida como fruta de consumo, tanto en forma directa como en jugos y dulces"));
        listafrutas.add(new Frutas("Pera","Es una fruta en forma de bombilla; su cáscara es lisa, la cual puede ser de color verde, amarillo, café o rojizo."));
        listafrutas.add(new Frutas("Piña"," Es una hierba perenne, de escaso porte y hojas duras y lanceoladas de hasta 1 m de largo."));
        listafrutas.add(new Frutas("Sandia","Es un fruto de gran tamaño, que se caracteriza por tener una de color verde"));
        listafrutas.add(new Frutas("Uva","Pulpa carnosa, consistente, piel fina."));
        AdaptadorFruta adaptador = new AdaptadorFruta(this);
        lista = findViewById(R.id.lvFrutas);
        lista.setAdapter(adaptador);
    }

    class AdaptadorFruta extends ArrayAdapter<Frutas>
    {
        AppCompatActivity appCompatActivity;

        AdaptadorFruta(AppCompatActivity context)
        {
            super(context, R.layout.frutas, listafrutas);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.frutas, null);

            TextView textView1 = item.findViewById(R.id.tvNombre);
            textView1.setText(listafrutas.get(position).getNombre());

            TextView textView2 = item.findViewById(R.id.tvInfo);
            textView2.setText(listafrutas.get(position).getInfo());

            ImageView imageView1 = item.findViewById(R.id.imvFrutas);
            imageView1.setImageResource(imaFrutas[position]);

            return item;
        }
    }
}