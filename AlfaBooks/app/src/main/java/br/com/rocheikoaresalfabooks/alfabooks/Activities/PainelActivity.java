package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.rocheikoaresalfabooks.alfabooks.R;
/**
 * Created by aleffer on 09/10/17.
 */

public class PainelActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_painel);

        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.painel_adm);



        /* Define ação para cada um dos botões do painel de administração */
        Button cadCliBtn = (Button) findViewById(R.id.cad_cli_btn);
        Button atuCliBtn = (Button) findViewById(R.id.atu_cli_btn);
        Button delCliBtn = (Button) findViewById(R.id.rem_cli_btn);
        Button cadProdBtn = (Button) findViewById(R.id.cad_prod_btn);
        Button atuProdBtn = (Button) findViewById(R.id.atu_prod_btn);
        Button delProdBtn = (Button) findViewById(R.id.rem_prod_btn);
        Button cadFornBtn = (Button) findViewById(R.id.cad_forn_btn);
        Button atuFornBtn = (Button) findViewById(R.id.atu_forn_btn);
        Button delFornBtn = (Button) findViewById(R.id.rem_forn_btn);


        cadCliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), CadastrarClienteActivity.class);
                startActivity(it);
            }
        });
        atuCliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), AtualizarClienteActivity.class);
                startActivity(it);
            }
        });
        delCliBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), RemoverClienteActivity.class);
                startActivity(it);
            }
        });
        cadProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), CadastrarProdutoActivity.class);
                startActivity(it);
            }
        });
        atuProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), AtualizarProdutoActivity.class);
                startActivity(it);
            }
        });
        delProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), RemoverProdutoActivity.class);
                startActivity(it);
            }
        });
        cadFornBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), CadastrarFornecedorActivity.class);
                startActivity(it);
            }
        });
        atuFornBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), AtualizarFornecedorActivity.class);
                startActivity(it);
            }
        });
        delFornBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(view.getContext(), RemoverFornecedorActivity.class);
                startActivity(it);
            }
        });

    }
}
