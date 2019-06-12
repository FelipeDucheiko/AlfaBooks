package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.CarrinhoAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.cart_title_txtv);


        /* Define o ReclyclerView e seu LayoutManege */
        mRecyclerView = (RecyclerView) findViewById(R.id.carrinho_rcyclview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /* Define o adaptador personalizado CarrinhoAdapter como adaptador da ReclyclerView */
        mAdapter = new CarrinhoAdapter(carregarLista());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mRecyclerView.getLayoutManager());
    }

    private ArrayList<ItensCarrinhoSerializable> carregarLista() {

        /* Recupera lista de itens do carrinho da classe BancoTemporario */
        return BancoTemporario.getInstance().getItensCarrinho();
    }
}
