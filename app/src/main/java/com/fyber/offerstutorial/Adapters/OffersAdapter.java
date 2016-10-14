package com.fyber.offerstutorial.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.fyber.offerstutorial.NetworkManager.ResponseModels.OfferModel;
import com.fyber.offerstutorial.UI.CustomViews.OfferItem;
import java.util.ArrayList;

/**
 * Created by muhammadkorany on 10/10/16.
 */

public class OffersAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<OfferModel> offerModelArrayList;
    private OfferItem offerItem;

    public OffersAdapter(Context context, ArrayList<OfferModel> offerModelArrayList){
        this.context = context;
        this.offerModelArrayList = offerModelArrayList;
    }

    @Override
    public int getCount() {
        return offerModelArrayList.size();
    }

    @Override
    public OfferModel getItem(int position) {
        return offerModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            offerItem = new OfferItem(context);
        }else{
            offerItem = (OfferItem) convertView;
        }

        offerItem.setData(offerModelArrayList.get(position));

        return offerItem;
    }
}
