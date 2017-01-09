package in.gripxtech.retrofitexample.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Helper {

    public static final String TAG;
    private static final Retrofit gitHubRetrofit;
    private static final Retrofit formFieldRetrofit;

    static {
        TAG = Retrofit2Helper.class.getSimpleName();
        gitHubRetrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        formFieldRetrofit = new Retrofit.Builder().baseUrl("https://orgasmic-threshold.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getGitHubRetrofit() {
        return gitHubRetrofit;
    }

    public Retrofit getFormFieldRetrofit() {
        return formFieldRetrofit;
    }
}
