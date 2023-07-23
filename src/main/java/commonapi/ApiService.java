package commonapi;

import commonapi.models.User;

import retrofit2.Call;
import retrofit2.http.*;


public interface ApiService {

     @POST("posts")
     Call<User> createUser(@Body User user);

     @GET("posts/{id}")
     Call<User> getUser(@Path("id") Integer id);
}
