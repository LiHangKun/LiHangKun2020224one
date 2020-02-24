package com.bawei.lihangkun2020224one.contral;

public interface IHomePageContral {
    interface Ivew{
        void getBannerSucc(String str);
        void geBannertErr(String str);

        void getListSucc(String str);
        void getListErr(String str);
    }
    interface Prenenter{
        void getBannerJson(String str);
        void getListJson(String str);
    }
    interface Model{
        void getBannerJson(String str,CallBackBanner callBackBanner);
        interface CallBackBanner{
            void getBannerSucc(String str);
            void geBannertErr(String str);
        }
        void getListJson(String str,CallBackList callBackList);
        interface CallBackList{
            void getListSucc(String str);
            void getListErr(String str);
        }
    }
}
