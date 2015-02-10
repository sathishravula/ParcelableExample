package com.example.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ehc on 10/2/15.
 */
public class Store implements Parcelable {
  private  String storeName;
  private  int storeId;

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
          dest.writeString(storeName);
          dest.writeInt(storeId);
  }

  public static final Parcelable.Creator<Store> CREATOR = new Creator<Store>() {
    public Store createFromParcel(Parcel source) {
     Store mStore = new Store();
      mStore.storeName = source.readString();
      mStore.storeId = source.readInt();
      return mStore;
    }
    public Store[] newArray(int size) {
      return new Store[size];
    }
  };

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  @Override
  public String toString() {
    return "Store{" +
        "storeName='" + storeName + '\'' +
        ", storeId=" + storeId +
        '}';
  }

  public int getStoreId() {
    return storeId;
  }

  public void setStoreId(int storeId) {
    this.storeId = storeId;
  }
}
