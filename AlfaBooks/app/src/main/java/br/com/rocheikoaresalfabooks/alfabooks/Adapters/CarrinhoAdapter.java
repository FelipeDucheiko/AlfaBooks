package br.com.rocheikoaresalfabooks.alfabooks.Adapters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 26/09/17.
 */

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder>{

    private ArrayList<ItensCarrinhoSerializable> dataSet;


    public CarrinhoAdapter(ArrayList<ItensCarrinhoSerializable> dataSet) {
        this.dataSet = dataSet;
    }


    /* Define conteúdo apresentado na tela e
     * define a ação do botão de remover com um snackbar reversível
     */
    @Override
    public void onBindViewHolder(CarrinhoAdapter.ViewHolder holder, int position) {


        holder.tituloTxtv.setText(dataSet.get(position).getNome());
        holder.qtdTxtv.setText(String.valueOf (dataSet.get(position).getQtd()));

        holder.removeBtn.setTag(position);

        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int)view.getTag();

                Snackbar mySnackbar = Snackbar.make(view,
                        R.string.remove_item_carrinho, Snackbar.LENGTH_LONG);
                mySnackbar.setAction(R.string.desfazer, new DesfazerRemover(dataSet, dataSet.get(position), position));
                mySnackbar.show();

                dataSet.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataSet.size()-position+1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    /** View Holder **/


    /*
     * É usado como referência para a criação e população dos itens do carrinho
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView tituloTxtv;
        private TextView qtdTxtv;
        private ImageButton removeBtn;

        public ViewHolder(View v) {
            super(v);
            mView = v;
            tituloTxtv = mView.findViewById(R.id.item_cart_txtv );
            qtdTxtv = mView.findViewById(R.id.qtd_cart_etxt );
            removeBtn = mView.findViewById(R.id.deleta_item_imgbtn);
        }
    }

    /*
     * Infla o fragment do carrrinho
     */
    @Override
    public CarrinhoAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_cart, parent, false);

        v.setMinimumWidth(parent.getMeasuredWidth());
        CarrinhoAdapter.ViewHolder vh = new CarrinhoAdapter.ViewHolder(v);

        return vh;
    }

    /*
     * Classe usada para desfazer a ação do snackbar
     */

    public class DesfazerRemover implements View.OnClickListener {

        private ArrayList<ItensCarrinhoSerializable> dataSet;
        private ItensCarrinhoSerializable item;
        private int position;

        public DesfazerRemover(ArrayList<ItensCarrinhoSerializable> dataSet, ItensCarrinhoSerializable item, int position) {

            this.dataSet = dataSet;
            this.item = item;
            this.position = position;

        }

        @Override
        public void onClick(View view) {

            dataSet.add(position, item);
            notifyItemInserted(position);
            notifyItemRangeChanged(position, dataSet.size()-position+1);

        }
    }
}
