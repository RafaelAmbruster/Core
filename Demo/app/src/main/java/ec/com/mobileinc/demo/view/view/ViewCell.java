/*
 * Copyright (c) 2015. Propiedad de Cubisima.com.
 * Owner: Rafael Ambruster.
 */

package ec.com.mobileinc.demo.view.view;

import android.content.Context;
import android.view.View;


public abstract class ViewCell<OBJECT> {

    Context context;
    View view;
    OBJECT object;
    int position;

    public ViewCell() {

    }

    public abstract void animate();

    public void build(Context context, View view) {
        this.context = context;
        this.view = view;
        this.load();
    }

    public void build(OBJECT object, int position) {
        this.object = object;
        this.position = position;
        this.fillin();
    }

    public abstract void build();

    public abstract void load();

    public abstract void fillin();

    public abstract void addListeners();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public OBJECT getObject() {
        return object;
    }

    public void setObject(OBJECT object) {
        this.object = object;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void onScroll(float yOffset) {
    }
}
