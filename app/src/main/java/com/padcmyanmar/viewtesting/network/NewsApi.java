package com.padcmyanmar.viewtesting.network;

import com.padcmyanmar.viewtesting.data.vo.NewsVO;
import com.padcmyanmar.viewtesting.network.reponses.GetNewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ICE on 06-01-2018.
 */

public interface NewsApi {

    @FormUrlEncoded
    @POST("getMMNews.php")//used to call api
    Call<GetNewsResponse> loadNews(@Field("page") int page,                     //field used to return form-data
                                   @Field("access_token") String accessToken);//field bae parameter nae associated loat tar lae so tar yae pay


}
