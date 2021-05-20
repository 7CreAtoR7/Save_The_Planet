package android.example.com;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersInfo {
    @POST("/add")
    public Call<Boolean> add(@Body Users urs);

}
