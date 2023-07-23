package commonapi;

import retrofit2.Retrofit;


public class RequestSpecUtils {
    private RequestSpecUtils() {
    }

    public static ApiService createService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}

