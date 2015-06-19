package com.huwei.sweetmusicplayer.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * @author jayce
 * @date 2015/05/24
 */
public abstract class HttpHandler implements Response.Listener<String>,Response.ErrorListener{

    public static final String TAG="HttpHandler";

    private Context context;

    public HttpHandler(Context context) {
        this.context = context;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
        Log.i(TAG,error.getLocalizedMessage()+error.getMessage());
        if(error instanceof NoConnectionError) {
            Toast.makeText(context,"网络连接异常",Toast.LENGTH_LONG).show();
        }
        onFinish();
    }

    @Override
    public void onResponse(String response) {
        Log.i(TAG,"response:"+response);

        onFinish();
        onSuccess(response);
    }

    public abstract void onSuccess(String response);

    public void onStart(){};

    public void onFinish(){};
}