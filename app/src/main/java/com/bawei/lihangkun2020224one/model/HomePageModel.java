package com.bawei.lihangkun2020224one.model;

import com.bawei.lihangkun2020224one.contral.IHomePageContral;
import com.bawei.lihangkun2020224one.util.Util;
import com.bawei.lihangkun2020224one.util.VolleyUtils;

public class HomePageModel implements IHomePageContral.Model {
    @Override
    public void getBannerJson(final String str, final CallBackBanner callBackBanner) {
        VolleyUtils.getInstance().doGet(str, new VolleyUtils.CallBack() {
            @Override
            public void success(String json) {
                callBackBanner.getBannerSucc(json);
            }

            @Override
            public void falied(String msg) {
                callBackBanner.geBannertErr(msg);
            }
        });
    }

    @Override
    public void getListJson(String str, final CallBackList callBackList) {
        VolleyUtils.getInstance().doGet(str, new VolleyUtils.CallBack() {
            @Override
            public void success(String json) {
                callBackList.getListSucc(json);
            }

            @Override
            public void falied(String msg) {
                callBackList.getListErr(msg);
            }
        });
    }
   /* @Override
    public void getBannerJson(String str, final CallBackBanner callBackBanner) {
        VollyUtiles.getInstance().getDoGet(str, new VollyUtiles.BackJson() {
            @Override
            public void succ(String str) {
                callBackBanner.getBannerSucc(str);
            }

            @Override
            public void failed(String str) {
                callBackBanner.geBannertErr(str);
            }
        });
    }

    @Override
    public void getListJson(String str, final CallBackList callBackList) {
        VollyUtiles.getInstance().getDoGet(str, new VollyUtiles.BackJson() {
            @Override
            public void succ(String str) {
                callBackList.getListSucc(str);
            }

            @Override
            public void failed(String str) {
                callBackList.getListErr(str);
            }
        });
    }*/

    /*@Override
    public void getBannerJson(final String str, final CallBackBanner callBackBanner) {
        Util.getInstance().getJson(str, new Util.BackJson() {
            @Override
            public void Succ(String str) {
                callBackBanner.getBannerSucc(str);
            }

            @Override
            public void Err(String str) {
                callBackBanner.geBannertErr(str);
            }
        });
    }

    @Override
    public void getListJson(final String str, final CallBackList callBackList) {
        Util.getInstance().getJson(str, new Util.BackJson() {
            @Override
            public void Succ(String str) {
                callBackList.getListSucc(str);
            }

            @Override
            public void Err(String str) {
                callBackList.getListErr(str);
            }
        });
    }*/
}
