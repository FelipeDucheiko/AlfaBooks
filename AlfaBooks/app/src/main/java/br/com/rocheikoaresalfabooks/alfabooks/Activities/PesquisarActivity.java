package br.com.rocheikoaresalfabooks.alfabooks.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;

import br.com.rocheikoaresalfabooks.alfabooks.Adapters.ListViewAdapter;
import br.com.rocheikoaresalfabooks.alfabooks.BancoTemporario;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felip on 05/10/2017.
 */

public class PesquisarActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemClickListener  {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] nomeLivroLista;
    ArrayList<Livro> livrosLista = new ArrayList<Livro>();
    ArrayList<LivroSerializable> dataSet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        /* Habilita botão de voltar e altera o título da activity */
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.pesquisar);

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        /* Recupera a lista de livros e popula a listview */
        dataSet= BancoTemporario.getInstance().getItensDataSet();
        for(LivroSerializable ls : dataSet){
            Livro livro = new Livro(ls.getTitulo());
            livrosLista.add(livro);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, livrosLista);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        list.setOnItemClickListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        /* Para cada item selecionado, abre a activity que exibe detalhes */
        Intent it = new Intent(parent.getContext(), ExibirLivroActivity.class);
        it.putExtra("livro", BancoTemporario.getInstance().getLivroSerializable(dataSet.get(position).getTitulo()));
        startActivity(it);
    }
}



