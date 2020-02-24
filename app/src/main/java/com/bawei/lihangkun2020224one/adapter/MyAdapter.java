package com.bawei.lihangkun2020224one.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lihangkun2020224one.R;
import com.bawei.lihangkun2020224one.activity.MainActivity;
import com.bawei.lihangkun2020224one.bean.BeanClass;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<BeanClass.ResultsBean.NewsistBean> newsist;

    public MyAdapter(Context context, List<BeanClass.ResultsBean.NewsistBean> newsist) {
        this.context = context;
        this.newsist = newsist;
    }

    @Override
    public int getCount() {
        return newsist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
             holder = new ViewHolder();
            convertView  = View.inflate(context, R.layout.itemone, null);
             holder.tx1 = convertView.findViewById(R.id.tx1);
            holder.tx2 = convertView.findViewById(R.id.tx2);
            holder.tx3 = convertView.findViewById(R.id.tx3);
            holder.tx4 = convertView.findViewById(R.id.tx4);
            holder.tu = convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else{
             holder = (ViewHolder) convertView.getTag();
        }
        BeanClass.ResultsBean.NewsistBean newsistBean = newsist.get(position);
        String content = newsistBean.getContent();
        String title = newsistBean.getTitle();
        String time = newsistBean.getTime();
        String author = newsistBean.getAuthor();
        String image = newsistBean.getImage();
        Picasso.get().load(image).into(holder.tu);
        holder.tx1.setText(title+"");
        holder.tx2.setText(content+"");
        holder.tx3.setText(author+"");
        holder.tx4.setText(time+"");
        return convertView;
    }
    public class ViewHolder{
        TextView tx1;
        TextView tx2;
        TextView tx3;
        TextView tx4;
        ImageView tu;
    }
}
