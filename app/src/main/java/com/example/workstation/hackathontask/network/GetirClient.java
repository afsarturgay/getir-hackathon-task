package com.example.workstation.hackathontask.network;


import com.example.workstation.hackathontask.model.ResponseAPI;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by workstation on 03/02/2018.
 */

public interface GetirClient {
    @POST("searchRecords")
    Call<ResponseAPI> searchRecords(@Query("startDate") String startDate,
                                    @Query("endDate") String endDate,
                                    @Query("minCount") int minCount,
                                    @Query("maxCount") int maxCount);
}
