package com.yellowcat.pedrapapeletesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    void opcaoSelecionada(String escolhaUsuario) {
        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = (TextView) findViewById(R.id.textResultado);
        int numeroRandom = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaLeo = opcoes[numeroRandom];

        switch (escolhaLeo) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        //Leo ganha
        if ((escolhaLeo == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaLeo == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaLeo == "papel" && escolhaUsuario == "pedra")) {
            textoResultado.setText("Você perdeu. =)");
        }
        //Usuário ganha
        else if ((escolhaUsuario == "pedra" && escolhaLeo == "tesoura") ||
                (escolhaUsuario == "tesoura" && escolhaLeo == "papel") ||
                (escolhaUsuario == "papel" && escolhaLeo == "pedra")) {
            textoResultado.setText("Você ganhou. =(");
        }
        //Empate
        else {
            textoResultado.setText("Empate.");
        }
    }
}
