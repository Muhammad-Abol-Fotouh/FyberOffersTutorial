package com.fyber.offerstutorial.NetworkManager.ResponseModels;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class GetOffersModel implements Serializable{

    private String code;
    private String message;
    private int count;
    private int pages;
    private InformationModel information;
    private OfferModel[] offers;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public InformationModel getInformation() {
        return information;
    }

    public void setInformation(InformationModel information) {
        this.information = information;
    }

    public OfferModel[] getOffers() {
        return offers;
    }

    public void setOffers(OfferModel[] offers) {
        this.offers = offers;
    }
}
