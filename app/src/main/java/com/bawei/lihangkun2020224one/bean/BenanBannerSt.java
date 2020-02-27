package com.bawei.lihangkun2020224one.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

public class BenanBannerSt extends SimpleBannerInfo {
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BenanBannerSt(String url) {
        this.url = url;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
