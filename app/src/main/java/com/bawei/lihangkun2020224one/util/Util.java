package com.bawei.lihangkun2020224one.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Util {
    private static Util util=new Util();
    private Util(){

    }
    public static Util getInstance(){
        return util;
    }
    private Handler handler=new Handler();
    public interface BackJson{
        void Succ(String str);
        void Err(String str);
    }
    public boolean BackNetWork(Context context){
         ConnectivityManager con = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = con.getActiveNetworkInfo();
        if(activeNetworkInfo!=null){
            return true;
        }else{
            return false;
        }
    }
    public void getJson(final String json, final BackJson backJson){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(json);
                     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                     conn.setRequestMethod("GET");
                     conn.setReadTimeout(5000);
                     conn.setConnectTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] bytes = new byte[1024];
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((len=inputStream.read(bytes))!=-1){
                            String s = new String(bytes, 0, len);
                            stringBuilder.append(s);
                        }
                        inputStream.close();
                        final String s = stringBuilder.toString();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if(backJson!=null){
                                        backJson.Succ(s);
                                    }
                                }
                            });
                    }else{
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(backJson!=null){
                                    backJson.Err("失败");
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
