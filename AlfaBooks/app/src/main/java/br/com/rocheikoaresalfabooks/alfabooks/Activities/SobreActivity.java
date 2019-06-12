package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felip on 05/10/2017.
 */

public class SobreActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sobre);

        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.sobre);

    }
}
