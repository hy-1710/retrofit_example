package in.gripxtech.retrofitexample;

import android.app.Application;

import in.gripxtech.retrofitexample.utils.Retrofit2Helper;

public class App extends Application {

    private Retrofit2Helper retrofit2Helper;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit2Helper = new Retrofit2Helper();
    }

    public Retrofit2Helper getRetrofit2Helper() {
        return retrofit2Helper;
    }
}
