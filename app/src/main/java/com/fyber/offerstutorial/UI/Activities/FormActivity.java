package com.fyber.offerstutorial.UI.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.fyber.offerstutorial.Callbacks.BaseListener;
import com.fyber.offerstutorial.NetworkManager.FyberAPIClient;
import com.fyber.offerstutorial.NetworkManager.ResponseModels.GetOffersModel;
import com.fyber.offerstutorial.NetworkManager.ResponseModels.OfferModel;
import com.fyber.offerstutorial.R;
import com.fyber.offerstutorial.Utils.ActionUtils;
import com.fyber.offerstutorial.Utils.MyApplication;
import com.fyber.offerstutorial.Utils.ParameterUtils;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by muhammadkorany on 10/9/16.
 */

public class FormActivity extends Activity implements View.OnClickListener{

    private MaterialEditText appID, uid;
    private Button getOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        initialization();
    }

    private void initialization(){
        appID = (MaterialEditText)findViewById(R.id.et_app_id);
        uid = (MaterialEditText)findViewById(R.id.et_uid);

        getOffers = (Button)findViewById(R.id.btn_get_offers);
        getOffers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get_offers:
                if (validateFields()) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }

    private boolean validateFields(){

        if (uid.getText().toString().isEmpty()){
            uid.requestFocus();
            uid.setError(getResources().getString(R.string.required_field));
            return false;
        }else{
            if (!(uid.getText().toString().equals(MyApplication.getUID()))){
                uid.requestFocus();
                uid.setError(getResources().getString(R.string.invalid_uid));
                return false;
            }

        }

        if (appID.getText().toString().isEmpty()){
            appID.requestFocus();
            appID.setError(getResources().getString(R.string.required_field));
            return false;
        }else{
            if (!(appID.getText().toString().equals(MyApplication.getAppId()))){
                appID.requestFocus();
                appID.setError(getResources().getString(R.string.invalid_app_id));
                return false;
            }

        }
        return true;
    }
}
