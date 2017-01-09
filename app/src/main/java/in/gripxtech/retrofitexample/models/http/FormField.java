package in.gripxtech.retrofitexample.models.http;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FormField {
    @FormUrlEncoded
    @POST("newfile.php")
    Call<User> createUser(
            @Field("name") String name,
            @Field("birth_date") String birthDate
    );
}
