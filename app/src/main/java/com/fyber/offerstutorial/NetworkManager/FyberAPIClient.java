package com.fyber.offerstutorial.NetworkManager;

import android.content.Context;
import android.view.View;

import com.fyber.offerstutorial.Callbacks.BaseListener;
import com.fyber.offerstutorial.NetworkManager.ResponseModels.GetOffersModel;
import com.fyber.offerstutorial.R;
import com.fyber.offerstutorial.UI.Activities.FormActivity;
import com.fyber.offerstutorial.UI.Activities.MainActivity;
import com.fyber.offerstutorial.Utils.ActionUtils;
import com.fyber.offerstutorial.Utils.MyApplication;
import com.fyber.offerstutorial.Utils.ParameterUtils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by muhammadkorany on 10/4/16.
 */

public class FyberAPIClient {

    private static Context mContext;
    private static  FyberAPIClient fyberAPIClient;
    private OkHttpClient.Builder httpClient;
    private Retrofit.Builder builder;
    private Retrofit retrofit;
    private FyberAPIInterface fyberAPIInterface;
    private String host = "http://api.fyber.com/";


    private FyberAPIClient() {
        initialization();
    }

    public static synchronized FyberAPIClient getInstance(final Context context) {
        mContext = context;

        if (fyberAPIClient == null) {
            fyberAPIClient = new FyberAPIClient();
        }
        return fyberAPIClient;
    }

    private void initialization() {
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

        builder = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.client(httpClient.build()).build();

        fyberAPIInterface = retrofit.create(FyberAPIInterface.class);
    }

    public void getOffers(int appid, String uid, String locale, long timestamp,
             String addID, boolean adEnabled, String osVersion, final BaseListener baseListener) {

        String params = "appid="+ appid + "&google_ad_id=" + addID + "&google_ad_id_limited_tracking_enabled=" + adEnabled + "&locale=" +
                locale + "&os_version=" + osVersion + "&timestamp=" + timestamp + "&uid=" + uid + "&" + MyApplication.getApiKey();

        String hash = null;
        try {
            hash = ParameterUtils.sha1Hash(params);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Call<GetOffersModel> call = fyberAPIInterface.getAllOffers(appid, addID, adEnabled, locale,  osVersion, timestamp, uid,
                hash);

        call.clone().enqueue(new Callback<GetOffersModel>() {
            @Override
            public void onResponse(Call<GetOffersModel> call, Response<GetOffersModel> response) {
                if (response.code()==500 || response.code()==502){
                    ActionUtils.showToast(mContext, mContext.getResources().getString(R.string.internal_server_error));
                }else if(response.code()==400){
                    ActionUtils.showToast(mContext, mContext.getResources().getString(R.string.bad_request));
                }else if(response.code()==401){
                    ActionUtils.showToast(mContext, response.message());
                }else if(response.code()==404){
                    ActionUtils.showToast(mContext, response.message());
                }else if (response.code()==200){
                    baseListener.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Call<GetOffersModel> call, Throwable t) {
                baseListener.onFailure();
            }

        });

    }
}
