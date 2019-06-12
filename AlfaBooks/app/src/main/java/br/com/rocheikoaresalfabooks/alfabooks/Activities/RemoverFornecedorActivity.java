package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.rocheikoaresalfabooks.alfabooks.R;

public class RemoverFornecedorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remforn);

        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.remover_fornecedor);

    }
}
