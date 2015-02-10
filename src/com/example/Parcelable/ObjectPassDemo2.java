package com.example.Parcelable;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ObjectPassDemo2 extends Activity {

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TextView mTextView = new TextView(this);
    ArrayList<Book> mBook = getIntent().getParcelableArrayListExtra(ObjectTranDemo.PAR_KEY);
//    mTextView.setText("Book name is: " + mBook.getBookName()+"/n"+
//        "Author is: " + mBook.getAuthor() + "/n" +
//        "PublishTime is: " + mBook.getPublishTime());
    mTextView.setText(mBook.toString());
    setContentView(mTextView);
  }
}