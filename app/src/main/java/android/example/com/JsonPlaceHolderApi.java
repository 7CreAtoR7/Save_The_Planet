package android.example.com;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("list_top")
    Call<List<Post>> getPosts();
}
