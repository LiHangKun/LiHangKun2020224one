package com.bawei.lihangkun2020224one.model;

import com.bawei.lihangkun2020224one.contral.IHomePageContral;
import com.bawei.lihangkun2020224one.util.Util;

public class HomePageModel implements IHomePageContral.Model {

    @Override
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
    }
}
