package com.patrick.android.doubanreader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.patrick.android.doubanreader.R;
import com.patrick.android.doubanreader.entity.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */

public class TestAdapter extends RecyclerView.Adapter {
    private  List<Book> list;
    Context mContext;
    public TestAdapter(Context context,List<Book> list) {
        this.list=list;
        this.mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==1){
            return new TestAdapter.TestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_bookstore_test,parent,false));
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TestViewHolder){
            String address=list.get(position).getBook_image_address();
            Picasso.with(mContext).load(address).into(((TestAdapter.TestViewHolder) holder).imageView);
            ( (TestViewHolder) holder).textView_title.setText(list.get(position).getBook_name());

        }
    }
    public int getItemViewType(int position) {
        if(position<0){
            return position;
        }
        else return  1;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class TestViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView_title;
        public TestViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageview_test);

            textView_title=(TextView)itemView.findViewById(R.id.textview_test);
        }
    }
}
