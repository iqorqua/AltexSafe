package com.app.altex.altexsafe.etherum_wallet.interfaces;


public interface StorableWallet {

    public String getPubKey();

    public long getDateAdded();

    public void setPubKey(String pubKey);

    public void setDateAdded(long dateAdded);
}
