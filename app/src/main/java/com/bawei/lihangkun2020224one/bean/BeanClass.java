package com.bawei.lihangkun2020224one.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

public class BeanClass {

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private List<BannerBean> banner;
        private List<NewsistBean> newsist;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<NewsistBean> getNewsist() {
            return newsist;
        }

        public void setNewsist(List<NewsistBean> newsist) {
            this.newsist = newsist;
        }

        public static class BannerBean extends SimpleBannerInfo {
            /**
             * imageurl : http://blog.zhaoliang5156.cn/api/images/banner_01.jpg
             */

            private String imageurl;

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }

            @Override
            public Object getXBannerUrl() {
                return null;
            }
        }

        public static class NewsistBean {
            /**
             * title : 濡備綍杈ㄥ埆鍎跨鏄惁鎰熸煋鏂板瀷鍐犵姸鐥呮瘨
             * content : 濡備綍杈ㄥ埆鍎跨鍑虹幇鐨勫彂鐑棁鐘舵槸鏅€氭劅鍐掋€佽繕鏄祦鎰熸垨鏂板瀷鍐犵姸鐥呮瘨锛熷寳浜効绔ュ尰闄㈡€ヨ瘖绉戜富浠荤帇鑽冭锛屾櫘閫氭劅鍐掋€佹祦鎰熴€佹柊鍨嬪啝鐘剁梾姣掍笁鑰呯殑鑷寸梾婧愩€佸彂鐥呮椂闂淬€佺棁鐘跺拰涓ラ噸绋嬪害閮戒笉涓€鏍枫€傛柊鍨嬪啝鐘剁梾姣掓劅鏌撴槸浜虹兢鏅亶鏄撴劅锛屽挨鍏舵槸鑰佲€�
             * author : LIFECARE蹇冨仴搴峰钩鍙�
             * time : 3灏忔椂鍓�
             * image : http://5b0988e595225.cdn.sohucs.com/q_70,c_lfill,w_180,h_120,g_faces/images/20200219/a53e7a852c02439b83aa8a2e270632c8.jpeg
             */

            private String title;
            private String content;
            private String author;
            private String time;
            private String image;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
