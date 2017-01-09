package in.gripxtech.retrofitexample.models.http;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FormField2 {
    @FormUrlEncoded
    @POST("newfile.php")
    Call<User> createUser(
            @FieldMap Map<String, String> field
    );
}
