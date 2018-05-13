package com.app.altex.altexsafe.etherum_wallet.interfaces;


import okhttp3.Response;

public interface NetworkUpdateListener {

    public void onUpdate(Response s);
}
