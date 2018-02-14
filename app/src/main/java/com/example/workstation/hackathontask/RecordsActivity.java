package com.example.workstation.hackathontask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.workstation.hackathontask.model.Record;
import com.example.workstation.hackathontask.model.ResponseAPI;
import com.example.workstation.hackathontask.network.GetirAPI;
import com.example.workstation.hackathontask.network.GetirClient;
import com.paginate.Paginate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class RecordsActivity extends AppCompatActivity {

    private ListView recordsListView;
    List<Record> records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        recordsListView = findViewById(R.id.recordsListView);

        Bundle extras = getIntent().getExtras();
        String startDate = extras.getString("startDate");
        String endDate = extras.getString("endDate");
        int minCount = extras.getInt("minCount");
        int maxCount = extras.getInt("maxCount");


        GetirClient client = GetirAPI.getApi().create(GetirClient.class);
        retrofit2.Call<ResponseAPI> call = client.searchRecords(startDate,endDate,minCount,maxCount);
        call.enqueue(new Callback<ResponseAPI>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseAPI> call, Response<ResponseAPI> response) {
                if (response.isSuccessful()){
                    ResponseAPI responseAPI = response.body();
                    records = responseAPI.getRecords();
                    Toast.makeText(RecordsActivity.this, String.valueOf(records.size()), Toast.LENGTH_SHORT).show();
                    List<String> stringRecords = new ArrayList<>();
                    for (int i = 0; i < 10 ; i++){
                        Record record = records.get(i);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(record.getId().getId().toString()).append("/n")
                                .append(record.getId().getKey().toString()).append("/n")
                                .append(record.getId().getValue().toString()).append("/n")
                                .append(record.getId().getCreatedAt()).append("/n");
                        stringRecords.add(stringBuilder.toString());
                    }
                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,stringRecords);
                    recordsListView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseAPI> call, Throwable t) {

            }
        });
    }
}
