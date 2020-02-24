package com.bawei.lihangkun2020224one.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.lihangkun2020224one.R;
import com.bawei.lihangkun2020224one.adapter.MyAdapter;
import com.bawei.lihangkun2020224one.base.BaseActivity;
import com.bawei.lihangkun2020224one.bean.BeanBanner;
import com.bawei.lihangkun2020224one.bean.BeanClass;
import com.bawei.lihangkun2020224one.contral.IHomePageContral;
import com.bawei.lihangkun2020224one.presenter.IhomePagePresenter;
import com.bawei.lihangkun2020224one.util.Util;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IHomePageContral.Ivew {


    private XBanner xb;
    String bannerJson="http://blog.zhaoliang5156.cn/api/news/news_data.json";
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
        banner = resultsBean.getBanner();
        xb.setBannerData(banner);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner aa, Object model, View view, int position) {
                Picasso.get().load(banner.get(position).getImageurl()).into((ImageView)view);
            }
        });

        List<BeanClass.ResultsBean.NewsistBean> newsist = resultsBean.getNewsist();
        Log.i("ss",newsist.size()+"");
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,newsist);
        lv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void geBannertErr(String str) {

    }

    @Override
    public void getListSucc(String str) {

    }

    @Override
    public void getListErr(String str) {

    }
}
