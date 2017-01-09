package in.gripxtech.retrofitexample.models.http;

import com.google.gson.annotations.SerializedName;

public class User {

    public static final String TAG;

    static {
        TAG = User.class.getSimpleName();
    }

    // if you want different java variable name then key (JSON key/value) from response
    // use SerializedName("json_response_key")
    @SerializedName("name")
    private String firstName;

    @SerializedName("birth_date")
    private String birthDate;

    public User(String firstName, String birthDate) {
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return TAG + "(firstName=" + firstName + ", birthDate=" + birthDate + ")";
    }
}
