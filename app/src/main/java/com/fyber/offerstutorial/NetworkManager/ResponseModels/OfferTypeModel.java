package com.fyber.offerstutorial.NetworkManager.ResponseModels;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class OfferTypeModel {

    private int offer_type_id;
    private String readable;

    public int getOffer_type_id() {
        return offer_type_id;
    }

    public void setOffer_type_id(int offer_type_id) {
        this.offer_type_id = offer_type_id;
    }

    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }
}
