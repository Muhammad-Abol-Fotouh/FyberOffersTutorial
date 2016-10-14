package com.fyber.offerstutorial.NetworkManager.ResponseModels;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class TimeToPayoutModel {

    private int amount;
    private String readable;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReadable() {
        return readable;
    }

    public void setReadable(String readable) {
        this.readable = readable;
    }
}
