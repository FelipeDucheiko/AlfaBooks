package br.com.rocheikoaresalfabooks.alfabooks.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * Created by felipesoares on 04/10/17.
 */

public class LivroSerializable implements Serializable {

    /*
     * Serializa os dados de Livro
     */

    private int id;
    private String titulo;
    private String descricaoBreve;
    private String descricaoLonga;
    private float valor;
    private byte[] bmp;

    public LivroSerializable(int id, String titulo, String descricaoBreve, String descricaoLonga, float valor, byte[] compressedBmpArray){
        this.id = id;
        this.titulo = titulo;
        this.descricaoBreve = descricaoBreve;
        this.descricaoLonga = descricaoLonga;
        this.valor = valor;
        this.bmp = compressedBmpArray;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricaoBreve() {
        return descricaoBreve;
    }

    public String getDescricaoLonga() {
        return descricaoLonga;
    }

    public float getValor() {
        return valor;
    }

    public Bitmap getBitmap() {
        return BitmapFactory.decodeStream(new ByteArrayInputStream(bmp));
    }
}
