package api;

import api.models.User;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;


public class RequestUtils {

    private static final ApiService apiService = RequestSpecUtils.createService(ApiClient.getClient());

    private RequestUtils(){}

    public static Response<User> sendPost(User user) {
        Call<User> call = apiService.createUser(user);
        try {
            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response<User> sendGet(Integer id) {
        Call<User> call = apiService.getUser(id);
        try {
            return call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

