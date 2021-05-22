package android.example.com;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface UsersInfoUpdate {
    @PUT("/update")
    public Call<Boolean> update(@Body UsersUpdate urs);
}
