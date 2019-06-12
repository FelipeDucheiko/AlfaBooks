package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosFragmentStatePagerAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroFragment;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felip on 08/10/2017.
 * Edited by felipesoares on 10/10/2017
 */

public class ExibirLivroActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_livro);


        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        /* Cria fragment e define argumentos utilizados pelo fragment */
        LivroFragment fragment = new LivroFragment();
        Bundle args = new Bundle();
        args.putSerializable("livro", getIntent().getSerializableExtra("livro"));
        args.putSerializable("onclick", false);
        args.putSerializable("breve", false);
        fragment.setArguments(args);
        setFragment(fragment);
    }

    protected void setFragment(Fragment fragment) {

        /* Popula o conteúdo da activity com o fragment criado */
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
    }
}
