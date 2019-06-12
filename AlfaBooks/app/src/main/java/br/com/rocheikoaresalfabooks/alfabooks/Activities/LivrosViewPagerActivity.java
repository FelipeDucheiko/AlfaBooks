package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 04/10/17.
 */

public class LivrosViewPagerActivity extends AppCompatActivity {

    /* Utilizado na criação do ViewPager */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_livro);

    }
}
