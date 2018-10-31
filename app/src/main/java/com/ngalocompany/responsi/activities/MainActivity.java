package com.ngalocompany.responsi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.ngalocompany.responsi.R;
import com.ngalocompany.responsi.adapter.RecyclerViewAdapter;
import com.ngalocompany.responsi.model.TayangSekarang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "api.themoviedb.org/3/movie/now_playing?api_key=dd4d33b25af6f3772594734733758e93";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<TayangSekarang> lsttayangsekarang;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsttayangsekarang = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++){

                    try {
                        jsonObject = response.getJSONObject(i);
                        TayangSekarang tayangSekarang = new TayangSekarang();
                        tayangSekarang.setTitle(jsonObject.getString("title"));
                        tayangSekarang.setVote_count(jsonObject.getString("vote_count"));
                        tayangSekarang.setVote_average(jsonObject.getString("vote_average"));
                        tayangSekarang.setId(jsonObject.getString("id"));
                        tayangSekarang.setOverview(jsonObject.getString("overview"));
                        tayangSekarang.setPoster_path(jsonObject.getString("poster_path"));
                        lsttayangsekarang.add(tayangSekarang);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lsttayangsekarang);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<TayangSekarang> lsttayangsekarang) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lsttayangsekarang);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.icon_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "sub item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aa_subitem1:
                Toast.makeText(this, "aa sub item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aa_subitem2:
                Toast.makeText(this, "aa sub item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }
}