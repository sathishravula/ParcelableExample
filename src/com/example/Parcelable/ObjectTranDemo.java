package com.example.Parcelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;

public class ObjectTranDemo extends Activity implements OnClickListener {

  private Button sButton,pButton;
  public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser";
  public  final static String PAR_KEY = "com.easyinfogeek.objectPass.par";
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    setupViews();

  }

  public void setupViews(){
    sButton = (Button)findViewById(R.id.button1);
    pButton = (Button)findViewById(R.id.button2);
    sButton.setOnClickListener(this);
    pButton.setOnClickListener(this);
  }

  public void SerializeMethod(){
    Person mPerson = new Person();
    mPerson.setName("Leon");
    mPerson.setAge(25);
    Intent mIntent = new Intent(this,ObjectPassDemo1.class);
    Bundle mBundle = new Bundle();
    mBundle.putSerializable(SER_KEY,mPerson);
    mIntent.putExtras(mBundle);

    startActivity(mIntent);
  }

  public void PacelableMethod(){
    ArrayList<Book> books=new ArrayList<Book>();
    Book mBook = new Book();
    mBook.setBookName("Android Developer Guide");
    mBook.setAuthor("Leon");
    mBook.setPublishTime(2014);
    ArrayList<String> au=new ArrayList<String>();
    au.add("hai");
    au.add("hello");
    au.add("how are you");
    mBook.setAuthors(au);
    books.add(mBook);
    Book mBook1 = new Book();
    mBook1.setBookName("Android Developer Guide");
    mBook1.setAuthor("kane");
    mBook1.setPublishTime(2015);
    ArrayList<String> au1=new ArrayList<String>();
    au1.add("a");
    au1.add("b");
    au1.add("c");
    mBook1.setAuthors(au1);
    ArrayList<Store> stores=new ArrayList<Store>();
    Store store=new Store();
    store.setStoreName("amazon");
    store.setStoreId(123);
    stores.add(store);
    Store store1=new Store();
    store1.setStoreName("flipkart");
    store1.setStoreId(124);
    stores.add(store1);
    mBook1.setStores(stores);
    books.add(mBook1);
    Intent mIntent = new Intent(this,ObjectPassDemo2.class);
    Bundle mBundle = new Bundle();
    mBundle.putParcelableArrayList(PAR_KEY,books);
    mIntent.putExtras(mBundle);

    startActivity(mIntent);
  }

  public void onClick(View v) {
    if(v == sButton){
      SerializeMethod();
    }else{
      PacelableMethod();
    }
  }
}