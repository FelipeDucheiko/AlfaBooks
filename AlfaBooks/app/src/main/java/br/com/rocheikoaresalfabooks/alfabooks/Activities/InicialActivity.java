package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.LivrosFragmentStatePagerAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 20/09/17.
 */

public class InicialActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

//        /* Habilita botão de voltar e altera o título da activity */
//        ActionBar ab = getSupportActionBar();


        /* Define ação do botão de login para abrir a activity correspondente */
        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), LoginActivity.class));
            }
        });

        /* Define ação do textview "sobre nós" para abrir a activity correspondente */
        TextView sobreNosTxtv = (TextView) findViewById(R.id.sobre_nos);
        sobreNosTxtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), SobreActivity.class));
            }
        });

        /* ViewPager */
        ViewPager vp = (ViewPager) findViewById(R.id.livros_vpager);


        /* BancoTemporario é uma classe singleton */
        BancoTemporario banco = BancoTemporario.getInstance();


        /* Define e comprime bitmap padrão para imagem dos livros */
        Bitmap bmp = ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_alfabooks_logo)).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

        /* Objeto do tipo byte[] é necessário para serilializar o bitmap */
        byte[] byteArray = stream.toByteArray();

        /* Adiciona livros no BancoTemporario e demais informações
         *  Isto é feito utilizando objetos do tipo LivroSerializable
         * */
        banco.addItemDataSet(new LivroSerializable(1, "Titulo 1", "Descrição Breve 1", "Descrição Longa 1", 1, byteArray));
        banco.addItemDataSet(new LivroSerializable(2, "Titulo 2", "Descrição Breve 2", "Descrição Longa 2", 2, byteArray));
        banco.addItemDataSet(new LivroSerializable(3, "Titulo 3", "Descrição Breve 3", "Descrição Longa 3", 3, byteArray));
        banco.addItemDataSet(new LivroSerializable(4, "Titulo 4", "Descrição Breve 4", "Descrição Longa 4", 4, byteArray));
        banco.addItemDataSet(new LivroSerializable(5, "Titulo 5", "Descrição Breve 5", "Descrição Longa 5", 5, byteArray));


        /* Cria PagerAdapter passando as informações para popular o mesmo */
        LivrosFragmentStatePagerAdapter pagerAdapter = new LivrosFragmentStatePagerAdapter(getSupportFragmentManager(), banco.getItensDataSet(), true);

        /* Define Adapter para o ViewPager que compõe esta activity */
        vp.setAdapter(pagerAdapter);


    }

    /* Action bar Menu */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /* Processa clicks no menu da actionbar */
        switch (item.getItemId()) {
            case R.id.action_search:
                startActivity(new Intent(this, PesquisarActivity.class));
                break;
            case R.id.action_shopping_cart:
                startActivity(new Intent(this, CarrinhoActivity.class));
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    /* Infla o menu da actionbar */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_actionbar, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
