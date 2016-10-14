package com.fyber.offerstutorial.UI.Activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fyber.offerstutorial.Adapters.OffersAdapter;
import com.fyber.offerstutorial.Callbacks.BaseListener;
import com.fyber.offerstutorial.NetworkManager.FyberAPIClient;
import com.fyber.offerstutorial.NetworkManager.ResponseModels.GetOffersModel;
import com.fyber.offerstutorial.NetworkManager.ResponseModels.OfferModel;
import com.fyber.offerstutorial.R;
import com.fyber.offerstutorial.Utils.ActionUtils;
import com.fyber.offerstutorial.Utils.MyApplication;
import com.fyber.offerstutorial.Utils.ParameterUtils;

import java.util.ArrayList;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BaseListener {

    private ListView offersListView;
    private TextView noOffersTextView;
    private OffersAdapter offersAdapter;
    private ArrayList<OfferModel> offerModelArrayList = new ArrayList<>();
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
    }

    private void initialization() {
        offersListView = (ListView) findViewById(R.id.lv_offers);
        noOffersTextView = (TextView) findViewById(R.id.tv_no_offers);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        offersAdapter = new OffersAdapter(this, offerModelArrayList);
        offersListView.setAdapter(offersAdapter);

        getOffers();
    }

    private void getOffers() {
        if (ActionUtils.isInternetConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            FyberAPIClient.getInstance(this).getOffers(Integer.parseInt(MyApplication.getAppId()),
                    MyApplication.getUID(), MyApplication.getLOCALE(),
                    ParameterUtils.unixTimestamp(), MyApplication.getGoogleAdId(), false, String.valueOf(Build.VERSION.SDK_INT), this);
        } else {
            noOffersTextView.setVisibility(View.VISIBLE);
            offersListView.setVisibility(View.GONE);
            noOffersTextView.setText(getResources().getString(R.string.no_connection));
        }
    }

    @Override
    public void onSuccess(Response response) {
        progressBar.setVisibility(View.GONE);

        GetOffersModel getOffersModel = (GetOffersModel) response.body();
        if (getOffersModel != null) {
            if (getOffersModel.getOffers() != null && getOffersModel.getOffers().length > 0) {
                noOffersTextView.setVisibility(View.GONE);
                offersListView.setVisibility(View.VISIBLE);

                for (int i = 0; i < getOffersModel.getOffers().length; i++) {
                    offerModelArrayList.add(getOffersModel.getOffers()[i]);
                }
                offersAdapter.notifyDataSetChanged();

            } else {
                noOffersTextView.setVisibility(View.VISIBLE);
                offersListView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onFailure() {
        noOffersTextView.setVisibility(View.VISIBLE);
        offersListView.setVisibility(View.GONE);
        noOffersTextView.setText(getResources().getString(R.string.request_failed));
    }
}
