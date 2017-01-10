package in.gripxtech.retrofitexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import in.gripxtech.retrofitexample.databinding.ActivityMainBinding;
import in.gripxtech.retrofitexample.models.http.Contributor;
import in.gripxtech.retrofitexample.models.http.FormField;
import in.gripxtech.retrofitexample.models.http.FormField2;
import in.gripxtech.retrofitexample.models.http.GitHub;
import in.gripxtech.retrofitexample.models.http.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String TAG;

    static {
        TAG = MainActivity.class.getSimpleName();
    }

    private App app;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        app = (App) getApplication();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        gitHubTask();
        formFieldTask();
        formFieldTask2();
    }

    private void gitHubTask() {
        Retrofit retrofit = app.getRetrofit2Helper().getGitHubRetrofit();

        GitHub gitHub = retrofit.create(GitHub.class);
        Call<List<Contributor>> call = gitHub.contributors("hy-1710", "retrofit_example");

        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                if (response.isSuccessful()) {
                    for (Contributor contributor : response.body()) {
                        Log.i(TAG, "onResponse: contributor: " + contributor);
                        binding.tv1.setText(binding.tv1.getText() + "\n" + contributor);
                    }
                } else {
                    Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void formFieldTask() {
        Retrofit retrofit = app.getRetrofit2Helper().getFormFieldRetrofit();

        FormField formField = retrofit.create(FormField.class);
        Call<User> call = formField.createUser("Barbie Girl", "17th Oct");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    Log.i(TAG, "onResponse: user: " + user);
                    binding.tv2.setText(user.toString());
                } else {
                    Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void formFieldTask2() {
        Retrofit retrofit = app.getRetrofit2Helper().getFormFieldRetrofit();

        FormField2 formField2 = retrofit.create(FormField2.class);
        Call<User> call = formField2.createUser(new ArrayMap<String, String>() {{
            put("name", "Android Developer");
            put("birth_date", "10th Nov");
        }});

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    Log.i(TAG, "onResponse: user: " + user);
                    binding.tv3.setText(user.toString());
                } else {
                    Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
