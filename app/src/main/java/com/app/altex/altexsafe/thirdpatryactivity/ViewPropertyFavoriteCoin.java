package com.app.altex.altexsafe.thirdpatryactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.app.altex.altexsafe.R;
import com.app.altex.altexsafe.customelements.WalletItem;
import com.app.altex.altexsafe.fragments.Wallets;


public class ViewPropertyFavoriteCoin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_favorite_coin);
        WalletItem wi = Wallets.currentCoinSet.get(getIntent().getIntExtra("coin_str_array",0));
        ((TextView)findViewById(R.id.vievCoin_txt_view)).setText("Price USD: $" + wi.price_usd + "\r\n"
                + "Price BTC: 0.010122\r\n"
                + "Market Cap: $20.51451 \r\n"
                + "Volume (24h): $523576154\r\n"
                + "Circulating Supply: 21,24,2333");
    }
}
