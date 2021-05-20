package android.example.com;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi2 {

    @GET("list_all")
    Call<List<Post2>> getPosts();
}
