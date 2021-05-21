package android.example.com;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UsersInfoUpdate {
    @POST("/update")
    public Call<Boolean> update(@Body UsersUpdate urs);
}
