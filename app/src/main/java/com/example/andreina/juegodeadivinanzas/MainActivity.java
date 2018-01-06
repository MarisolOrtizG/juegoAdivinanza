package com.example.andreina.juegodeadivinanzas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int contador = 0;
        private int r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darNuevoAlAzar();
    }

    private void darNuevoAlAzar() {

        Button b1 = (Button) findViewById(R.id.botonI);
        b1.setText(Integer.toString(r1));

        Button b2 = (Button) findViewById(R.id.botonD);
        b2.setText(Integer.toString(r2));

        TextView txt = (TextView) findViewById(R.id.resultado);
        txt.setText("Puntos: " + contador);

        if(contador == 5) {
            contador = 0;

            Toast.makeText(this, "¡Ganaste!", Toast.LENGTH_SHORT).show();
            TextView bt = (TextView) findViewById(R.id.botonI);
            bt.setText("?");
            TextView bt2 = (TextView) findViewById(R.id.botonD);
            bt2.setText("?");

        } else if(contador == -3){
            contador = 0;

            txt.setText("Puntos: " + contador);

            TextView bt = (TextView) findViewById(R.id.botonI);
            bt.setText("?");

            TextView bt2 = (TextView) findViewById(R.id.botonD);
            bt2.setText("?");

            Toast.makeText(this, "¡Perdiste!", Toast.LENGTH_SHORT).show();

        } else {

            txt.setText("Puntos: " + contador);

            Random rand = new Random();
            r1 = rand.nextInt(10);
            while (true) {
                r2 = rand.nextInt(10);
                if (r1 != r2) break;
            }
        }
    }

    public void onClickIzq(View view) {

        if(r1 > r2)
            contador++;
        else
            contador--;

        darNuevoAlAzar();

        TextView txt = (TextView) findViewById(R.id.resultado);
        txt.setText("Puntos: " + contador);
    }

    public void onClickDer(View view) {

        if(r1 < r2)
            contador++;
        else
            contador--;

        darNuevoAlAzar();

        TextView txt = (TextView) findViewById(R.id.resultado);
        txt.setText("Puntos: " + contador);

    }
}
