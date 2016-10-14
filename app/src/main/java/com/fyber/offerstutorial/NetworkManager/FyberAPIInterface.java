package com.fyber.offerstutorial.NetworkManager;

import com.fyber.offerstutorial.NetworkManager.ResponseModels.GetOffersModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public interface FyberAPIInterface {

    @GET("/feed/v1/offers.json")
    Call<GetOffersModel> getAllOffers(@Query("appid") int appid,
                                      @Query("google_ad_id") String google_ad_id,
                                      @Query("google_ad_id_limited_tracking_enabled") boolean google_ad_id_limited_tracking_enabled,
                                      @Query("locale") String locale,
                                      @Query("os_version") String os_version,
                                      @Query("timestamp") long timestamp,
                                      @Query("uid") String uid,
                                      @Query("hashkey") String hashkey);
}
