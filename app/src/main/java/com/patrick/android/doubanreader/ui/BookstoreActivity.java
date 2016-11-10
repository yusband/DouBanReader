package com.patrick.android.doubanreader.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.patrick.android.doubanreader.R;
import com.patrick.android.doubanreader.adapter.TestAdapter;
import com.patrick.android.doubanreader.entity.Book;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookstoreActivity extends AppCompatActivity {
public static List<Book> list=new ArrayList<>();
RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookstore);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_test);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TestTask testTask=new TestTask();
        testTask.execute("https://book.douban.com");
    }
private class  TestTask extends AsyncTask<String,Void,List<Book>> {

    @Override
    protected List<Book> doInBackground(String... params) {
        String address = params[0];
        Document doc = null;
        String title = null;
        try {
            doc = Jsoup.connect(address).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {
            title = doc.title();
            Log.i("bookstore", title);
            Element element=doc.getElementById("wrapper");
            Elements contents = element.getElementsByTag("img");
            int count=0;
            for (Element link : contents) {
                String name = link.attr("alt");
                String path = link.attr("title");

                String src = link.attr("src");
                Book book=new Book();
                book.setBook_name(name);
                book.setBook_image_address(src);
                if(book.getBook_name().length()>0) {
                    list.add(book);

                    Log.i("current book is ",list.get(count).getBook_name());
                    Log.i("current src is ",list.get(count).getBook_image_address());
                    Log.i("list size is ", String.valueOf(list.size()));
                    count++;
                }

            }

        }
        return list;
    }

    @Override
    protected void onPostExecute(List<Book> books) {
        super.onPostExecute(books);
        TestAdapter adapter=new TestAdapter(context,books);
        recyclerView.setAdapter(adapter);
    }
}
    private void JsoupTest(){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://book.douban.com").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {
            String title = doc.title();
            Log.i("bookstore",title);
        }

    }
}
