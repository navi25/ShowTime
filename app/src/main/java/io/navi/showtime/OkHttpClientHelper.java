package io.navi.showtime;

import android.util.Log;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientHelper {

    public static final String TAG = OkHttpClientHelper.class.getSimpleName();

    public static OkHttpClient client;


    public static OkHttpClient getClient(){
        if(client==null){
            client = new OkHttpClient.Builder()
                    .addInterceptor(new AuthenticationInterceptor() )
                    .build();
        }
        return client;
    }


    static class AuthenticationInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException{

            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter(Constants.API_KEY_STRING, Constants.API_KEY_VALUE)
                    .build();

            Log.d(TAG,"The url is " + url.toString());

            Request.Builder requestBuilder = original.newBuilder()
                                                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }


}
