package br.com.rocheikoaresalfabooks.alfabooks.Fragments;

import java.io.Serializable;

/**
 * Created by felipesoares on 26/09/17.
 */

public class ItensCarrinhoSerializable implements Serializable {
    /*
     * Serializa os dados de um Item do Carrinho
     */

    private String nome;
    private int qtd, id;
    private float valor;

    public ItensCarrinhoSerializable(int id, String nome, int qtd, float valor){
        this.id=id;
        this.nome=nome;
        this.qtd=qtd;
        this.valor=valor;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQtd() {
        return qtd;
    }

    public float getValor() {
        return valor;
    }
}
