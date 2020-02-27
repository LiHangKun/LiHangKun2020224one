package com.bawei.lihangkun2020224one.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.lihangkun2020224one.R;
import com.bawei.lihangkun2020224one.adapter.MyAdapter;
import com.bawei.lihangkun2020224one.base.BaseActivity;
import com.bawei.lihangkun2020224one.bean.BeanBanner;
import com.bawei.lihangkun2020224one.bean.BeanBannerTwo;
import com.bawei.lihangkun2020224one.bean.BeanClass;
import com.bawei.lihangkun2020224one.bean.BenanBannerSt;
import com.bawei.lihangkun2020224one.contral.IHomePageContral;
import com.bawei.lihangkun2020224one.presenter.IhomePagePresenter;
import com.bawei.lihangkun2020224one.util.Util;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IHomePageContral.Ivew {


    private XBanner xb;
    String bannerJson="http://blog.zhaoliang5156.cn/api/news/news_data.json";
    String bannerJsonTwo="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
    private ArrayList<BeanBanner> beanBanners;
    private List<BeanClass.ResultsBean.BannerBean> banner;
    private ListView lv;

    @Override
    protected void findViewId() {
        boolean b = Util.getInstance().BackNetWork(this);
        if(b){
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
            IhomePagePresenter ihomePagePresenter = new IhomePagePresenter(this);
            ihomePagePresenter.getBannerJson(bannerJson);
            ihomePagePresenter.getListJson(bannerJsonTwo);

        }
    }

    @Override
    protected void inItData() {
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);

    }

    @Override
    protected int findLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void getBannerSucc(String str) {
        Log.i("aaa","aaa");
        Gson gson = new Gson();
      BeanClass bannerBean = gson.fromJson(str, BeanClass.class);
        BeanClass.ResultsBean resultsBean = bannerBean.getResults().get(0);
        Log.i("aaa",""+resultsBean);
        banner = resultsBean.getBanner();
        Log.i("aaa",""+banner);
        /*xb.setBannerData(banner);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner aa, Object model, View view, int position) {
                Picasso.get().load(banner.get(position).getImageurl()).into((ImageView)view);
            }
        });*/





        final List<BeanClass.ResultsBean.NewsistBean> newsist = resultsBean.getNewsist();
        Log.i("ss",newsist.size()+"");
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,newsist);
        lv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BeanClass.ResultsBean.NewsistBean newsistBean = newsist.get(position);
                String title = newsistBean.getTitle();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("title",title+"");
                startActivity(intent);


            }
        });
    }

    @Override
    public void geBannertErr(String str) {

    }

    @Override
    public void getListSucc(String str) {
        Gson gson = new Gson();
        BeanBannerTwo beanBannerTwo = gson.fromJson(str, BeanBannerTwo.class);
        List<BeanBannerTwo.ResultBean> result = beanBannerTwo.getResult();
        final ArrayList<BenanBannerSt> list = new ArrayList<>();
        for(int i=0;i<result.size();i++){
            list.add(new BenanBannerSt(result.get(i).getImageUrl()));
        }
        xb.setBannerData(list);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner aa, Object model, View view, int position) {
                Glide.with(MainActivity.this).load(list.get(position).getUrl()).into((ImageView)view);
            }
        });
    }

    @Override
    public void getListErr(String str) {

    }
}
