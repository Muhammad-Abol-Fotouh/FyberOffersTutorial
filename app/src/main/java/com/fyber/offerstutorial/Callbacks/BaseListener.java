package com.fyber.offerstutorial.Callbacks;

import retrofit2.Response;

/**
 * Created by muhammadkorany on 10/7/16.
 */

public interface BaseListener {
    void onSuccess(Response response);
    void onFailure();
}
