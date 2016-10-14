package com.fyber.offerstutorial.UI.CustomViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fyber.offerstutorial.NetworkManager.ResponseModels.OfferModel;
import com.fyber.offerstutorial.R;
import com.squareup.picasso.Picasso;

/**
 * Created by muhammadkorany on 10/10/16.
 */

public class OfferItem extends LinearLayout {

    private Context context;
    private LayoutInflater layoutInflater;
    private TextView offerDescription, offerTitle;
    private ImageView offerIcon;

    public OfferItem(Context context) {
        super(context);
        this.context = context;
        initialization();
    }

    private void initialization() {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.item_offer, this, true);

        offerIcon = (ImageView)findViewById(R.id.iv_offer_icon);
        offerDescription = (TextView)findViewById(R.id.tv_offer_description);
        offerTitle = (TextView)findViewById(R.id.tv_offer_title);
    }


    public void setData(OfferModel offerModel){
        Picasso.with(context).load(offerModel.getThumbnail().getHires()).into(offerIcon);
        offerDescription.setText(offerModel.getTeaser());
        offerTitle.setText(offerModel.getTitle());
    }
}
