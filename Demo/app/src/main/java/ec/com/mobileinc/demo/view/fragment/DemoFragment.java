package ec.com.mobileinc.demo.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ec.com.mobileinc.demo.R;

public class DemoFragment extends CoreFragment {
    private static final String KEY_TITLE = "Demo";

    public DemoFragment() {

    }

    public static DemoFragment newInstance(String title) {
        DemoFragment f = new DemoFragment();

        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    protected void Load() {

    }

    @Override
    protected void Fill() {

    }

    @Override
    protected void Add() {

    }

    @Override
    protected void Search() {

    }

    @Override
    protected void Empty(boolean information) {

    }

    @Override
    protected void Error() {

    }

    @Override
    public void onClick(View v) {

    }
}
