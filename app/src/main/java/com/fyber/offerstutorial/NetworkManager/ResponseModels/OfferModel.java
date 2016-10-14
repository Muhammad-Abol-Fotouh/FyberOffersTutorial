package com.fyber.offerstutorial.NetworkManager.ResponseModels;

import java.io.Serializable;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class OfferModel implements Serializable{

    private String title;
    private int offer_id;
    private String teaser;
    private String required_actions;
    private String link;
    private OfferTypeModel[] offer_types;
    private ThumbnailModel thumbnail;
    private int payout;
    private TimeToPayoutModel time_to_payout;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getRequired_actions() {
        return required_actions;
    }

    public void setRequired_actions(String required_actions) {
        this.required_actions = required_actions;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public OfferTypeModel[] getOffer_types() {
        return offer_types;
    }

    public void setOffer_types(OfferTypeModel[] offer_types) {
        this.offer_types = offer_types;
    }

    public ThumbnailModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public TimeToPayoutModel getTime_to_payout() {
        return time_to_payout;
    }

    public void setTime_to_payout(TimeToPayoutModel time_to_payout) {
        this.time_to_payout = time_to_payout;
    }
}
