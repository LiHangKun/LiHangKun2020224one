package com.bawei.lihangkun2020224one.presenter;

import com.bawei.lihangkun2020224one.contral.IHomePageContral;
import com.bawei.lihangkun2020224one.model.HomePageModel;

public class IhomePagePresenter implements IHomePageContral.Prenenter {

    IHomePageContral.Ivew ivew;
    HomePageModel model;

    public IhomePagePresenter(IHomePageContral.Ivew ivew) {
        this.ivew = ivew;
        model=new HomePageModel();
    }

    @Override
    public void getBannerJson(String str) {
       model.getBannerJson(str, new IHomePageContral.Model.CallBackBanner() {
           @Override
           public void getBannerSucc(String str) {
                ivew.getBannerSucc(str);
           }

           @Override
           public void geBannertErr(String str) {
                ivew.geBannertErr(str);
           }
       });
    }

    @Override
    public void getListJson(String str) {
            model.getListJson(str, new IHomePageContral.Model.CallBackList() {
                @Override
                public void getListSucc(String str) {
                    ivew.getListSucc(str);
                }

                @Override
                public void getListErr(String str) {
                    ivew.getListErr(str);
                }
            });
    }
}
