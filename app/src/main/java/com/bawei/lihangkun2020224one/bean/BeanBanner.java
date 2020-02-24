package com.bawei.lihangkun2020224one.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

public class BeanBanner extends SimpleBannerInfo {
    BeanClass.ResultsBean.BannerBean url;

    public BeanBanner(BeanClass.ResultsBean.BannerBean url) {
        this.url = url;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
