package com.example.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Book implements Parcelable {
  private String bookName;
  private String author;
  private int publishTime;
  private ArrayList<String> authors;
  private ArrayList<Store> stores;

  public ArrayList<String> getAuthors() {
    return authors;
  }

  public void setAuthors(ArrayList<String> authors) {
    this.authors = authors;
  }

  public ArrayList<Store> getStores() {
    return stores;
  }

  public void setStores(ArrayList<Store> stores) {
    this.stores = stores;
  }

  public String getBookName() {
    return bookName;
  }
  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public int getPublishTime() {
    return publishTime;
  }
  public void setPublishTime(int publishTime) {
    this.publishTime = publishTime;
  }

  public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {
    public Book createFromParcel(Parcel source) {
      Book mBook = new Book();
      mBook.bookName = source.readString();
      mBook.author = source.readString();
      mBook.publishTime = source.readInt();
      ArrayList<String> authors=new ArrayList<String>();
      source.readStringList(authors);
      mBook.setAuthors(authors);
      ArrayList<Store> stores=new ArrayList<Store>();
      source.readList(stores,Store.class.getClassLoader());
      mBook.setStores(stores);
      return mBook;
    }
    public Book[] newArray(int size) {
      return new Book[size];
    }
  };

  public int describeContents() {
    return 0;
  }
  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeString(bookName);
    parcel.writeString(author);
    parcel.writeInt(publishTime);
    parcel.writeStringList(authors);
    parcel.writeList(stores);
  }

  @Override
  public String toString() {
    return "Book{" +
        "bookName='" + bookName + '\'' +
        ", author='" + author + '\'' +
        ", publishTime=" + publishTime +
        ", authors=" + authors +
        ", stores=" + stores +
        '}';
  }
}