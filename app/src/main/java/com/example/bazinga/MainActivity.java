package com.example.bazinga;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //removendo sidebar
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void selecionadoLargato(View view) {
        this.opcaoSelecionada("largato");
    }

    public void selecionadoSpock(View view) {
        this.opcaoSelecionada("spock");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResultado = findViewById(R.id.img_resultado);
        TextView textoResultado = findViewById(R.id.txt_resultado);

        int numero = new Random().nextInt(5); //0 1 2 3 4
        String[] opcoes = {"pedra", "papel", "tesoura", "largato", "spock"};
        String escolhaApp = opcoes[numero];


        switch (escolhaApp) {

            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

            case "largato":
                imageResultado.setImageResource(R.drawable.largato);
                break;

            case "spock":
                imageResultado.setImageResource(R.drawable.spock);
                break;
        }

        //regras jogo

        if (
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "pedra" && escolhaUsuario == "largato") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "papel" && escolhaUsuario == "spock") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "largato") ||
                (escolhaApp == "largato" && escolhaUsuario == "spock") ||
                (escolhaApp == "largato" && escolhaUsuario == "papel") ||
                (escolhaApp == "spock" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "spock" && escolhaUsuario == "pedra")

        ) { //app ganhador
            textoResultado.setText("Você Perdeu! :(");

        } else if (
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "pedra" && escolhaApp == "largato") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "papel" && escolhaApp == "spock") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "largato") ||
                (escolhaUsuario == "largato" && escolhaApp == "spock") ||
                (escolhaUsuario == "largato" && escolhaApp == "papel") ||
                (escolhaUsuario == "spock" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "spock" && escolhaApp == "pedra")
        ) {//usuario ganhador
            textoResultado.setText("Você Ganhou! :) Bazinga!");
        } else {//empate
            textoResultado.setText("Empatamos! ;)");
        }



    }
}