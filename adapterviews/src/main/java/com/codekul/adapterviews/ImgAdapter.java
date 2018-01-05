package com.codekul.adapterviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniruddha on 4/1/18.
 */

public class ImgAdapter extends BaseAdapter {

    private Context context;
    private List<ImgItm> dtSt;
    private LayoutInflater inflater;

    public ImgAdapter(Context context, List<ImgItm> dtSt) {
        this.context = context;
        this.dtSt = dtSt;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dtSt.size();
    }

    @Override
    public Object getItem(int pos) {
        return dtSt.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View viewInf = inflater.inflate(R.layout.img_itm, viewGroup, false);

        ImgItm itm = dtSt.get(pos);

        ImageView imgVw = viewInf.findViewById(R.id.imgVw);
        imgVw.setImageResource(itm.img);

        TextView txtVw = viewInf.findViewById(R.id.txtVw);
        txtVw.setText(itm.nm);

        return viewInf;
    }
}
