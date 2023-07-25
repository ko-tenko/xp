package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import utils.ConfigManager;
import java.util.Objects;


public abstract class ApiClient {

    private ApiClient(){}

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(Objects.requireNonNull(ConfigManager.getValue("urlApi")))
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}