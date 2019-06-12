package br.com.rocheikoaresalfabooks.alfabooks.Adapters;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroFragment;
import br.com.rocheikoaresalfabooks.alfabooks.Fragments.LivroSerializable;
import br.com.rocheikoaresalfabooks.alfabooks.R;

/**
 * Created by felipesoares on 04/10/17.
 */

public class LivrosFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<LivroSerializable> dataSet;
    private boolean setOnClickListener;

    public LivrosFragmentStatePagerAdapter(FragmentManager fm, ArrayList<LivroSerializable> dataSet, boolean setOnClickListener) {
        super(fm);
        this.dataSet = dataSet;
        this.setOnClickListener = setOnClickListener;
    }

    /*
     * Define e inicializa o fragment do PagerAdapter
     */
    @Override
    public Fragment getItem(int position) {

        LivroFragment fragment = new LivroFragment();
        Bundle args = new Bundle();
        args.putSerializable("livro", dataSet.get(position));
        args.putSerializable("onclick", setOnClickListener);
        args.putSerializable("breve", true);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }
}
