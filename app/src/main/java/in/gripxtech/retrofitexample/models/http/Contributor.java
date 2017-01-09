package in.gripxtech.retrofitexample.models.http;

import com.google.gson.annotations.SerializedName;

public class Contributor {

    public static final String TAG;

    static {
        TAG = Contributor.class.getSimpleName();
    }

    // if you want different java variable name then key (JSON key/value) from response
    // use SerializedName("json_response_key")
    @SerializedName("login")
    private String username;

    // if you are using same variable name as key. no need to do anything.
    private int contributions;

    public Contributor(String login, int contributions) {
        this.username = login;
        this.contributions = contributions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return TAG + "(username=" + username + ", contributions=" + contributions + ")";
    }
}
