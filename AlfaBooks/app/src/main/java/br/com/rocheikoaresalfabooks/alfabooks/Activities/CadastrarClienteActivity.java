package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 10/10/17.
 */

public class CadastrarClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadcli);

        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.cadastrar_cliente);


    }
}