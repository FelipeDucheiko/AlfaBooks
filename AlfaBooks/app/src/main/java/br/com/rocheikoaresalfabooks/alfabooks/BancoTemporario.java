package br.com.rocheikoaresalfabooks.alfabooks;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.ItensCarrinhoSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;

/**
 * Created by felipesoares on 06/10/17.
 */

public class BancoTemporario {
    private static final BancoTemporario ourInstance = new BancoTemporario();
    private ArrayList<LivroSerializable> dataSet;
    private ArrayList<ItensCarrinhoSerializable> carrinho;
    public static BancoTemporario getInstance() {
        return ourInstance;
    }

    private BancoTemporario() {
        dataSet = new ArrayList<>();
        carrinho = new ArrayList<>();


    }

    /** Carrinho **/

    public void addItemCarrinho(ItensCarrinhoSerializable it){
        carrinho.add(it);
    }
    public void remItemCarrinho(ItensCarrinhoSerializable it){
        carrinho.remove(it);
    }
    public ArrayList<ItensCarrinhoSerializable> getItensCarrinho() {
        return carrinho;
    }



    /** DATASET **/

    public void addItemDataSet(LivroSerializable it){
        dataSet.add(it);
    }
    public void remItemDataSet(LivroSerializable it){
        dataSet.remove(it);
    }

    public ArrayList<LivroSerializable> getItensDataSet() {
        return dataSet;
    }

    public LivroSerializable getLivroSerializable(String titulo){

        for(LivroSerializable ls : dataSet){
            if(ls.getTitulo() == titulo)
                return ls;
        }


        return null;
    }



}
