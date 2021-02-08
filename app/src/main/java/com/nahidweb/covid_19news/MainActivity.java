package com.nahidweb.covid_19news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{

    String api="https://disease.sh/v3/covid-19/countries/Bangladesh";

    TextView todaydeath1,totaldeath2,todayRecovered;
    TextView total_case,today_case,total_death,today_death,recovered,critical,activ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todaydeath1=findViewById(R.id.todaydathid);
        totaldeath2=findViewById(R.id.totaldathid);
        todayRecovered=findViewById(R.id.todayRecoveredid);



        total_case=findViewById(R.id.total_cases_homeid);
        today_case=findViewById(R.id.today_cases_homeid);
        total_death=findViewById(R.id.total_death_homeid);
        today_death=findViewById(R.id.today_death_homeid);
        recovered=findViewById(R.id.recovered_homeid);
        critical=findViewById(R.id.critical_homeid);
        activ=findViewById(R.id.activ_homeid);



        StringRequest request = new StringRequest(api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    todaydeath1.setText(jsonObject.getString("todayDeaths"));
                    totaldeath2.setText(jsonObject.getString("deaths"));
                    todayRecovered.setText(jsonObject.getString("todayRecovered"));

                    total_case.setText(jsonObject.getString("cases"));
                    today_case.setText(jsonObject.getString("todayCases"));
                    total_death.setText(jsonObject.getString("deaths"));
                    today_death.setText(jsonObject.getString("todayDeaths"));
                    recovered.setText(jsonObject.getString("recovered"));
                    critical.setText(jsonObject.getString("critical"));
                    activ.setText(jsonObject.getString("active"));






                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }
}