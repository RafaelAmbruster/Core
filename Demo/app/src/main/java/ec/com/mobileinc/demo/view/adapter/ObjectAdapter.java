package ec.com.mobileinc.demo.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import ec.com.mobileinc.demo.view.view.ViewCell;


public class ObjectAdapter<OBJECT> extends ArrayAdapter<OBJECT> {

    public ObjectAdapterLoadMore listener;
    Context context;
    int layoutId;
    Class cellClass;

    ArrayList<Integer> apparitions = new ArrayList<>();

    public ObjectAdapter(Context context, List<OBJECT> objets, int layoutId, Class<? extends ViewCell> cellClass) {
        super(context, layoutId, objets);
        this.context = context;
        this.layoutId = layoutId;
        this.cellClass = cellClass;
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = super.getCount();
        } catch (Exception e) {
        }
        return count;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = View.inflate(context, layoutId, null);

        ViewCell cell = null;
        if (view.getTag() != null && view.getTag() instanceof ViewCell)
            cell = (ViewCell) view.getTag();
        if (view.getTag() == null) {
            try {
                cell = (ViewCell) Class.forName(cellClass.getName()).newInstance();
                cell.build(context, view);
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.setTag(cell);
        }
        cell.build(getItem(i), i);


        int apparition = appear(i);
        if (apparition == 1) {
            try {
                cell.animate();
            } catch (Exception e) {
            }
        }

        if (apparition >= 1 && listener != null && getCount() > 4 && i >= (getCount() - 3)) {
            listener.loadMore();
        }

        return view;
    }

    public int appear(int positon) {
        int apparition = apparitions.size() <= positon ? 0 : apparitions.get(positon);
        apparition++;
        apparitions.add(positon, apparition);
        return apparition;
    }

    public interface ObjectAdapterLoadMore {
        public void loadMore();
    }
}
