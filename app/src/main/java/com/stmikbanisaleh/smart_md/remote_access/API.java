package com.stmikbanisaleh.smart_md.remote_access;

import com.stmikbanisaleh.smart_md.Model.Audit.PagingRespon;
import com.stmikbanisaleh.smart_md.Model_Ok.History.ResponHistory;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.LoginReaquest;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.ResponLogin;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.AuthorizationRespon;
import com.stmikbanisaleh.smart_md.Model_Ok.Login2.Entity.UserRespon;
import com.stmikbanisaleh.smart_md.Model_Ok.Report.PostReport;
import com.stmikbanisaleh.smart_md.Model_Ok.Store.PagingResponProduct;
import com.stmikbanisaleh.smart_md.Model_Ok.User.ResponUser;
import com.stmikbanisaleh.smart_md.Model_Ok.Visit.PagingResponStore_v;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    //interface adalah deklarasi semacam kelas yang methodnya tidak memiliki content
    @Headers("Content-Type: application/json")
    @GET("API/jadwal")
    Call<PagingRespon> getlist(@Header("Authorization") String  Token);

    @Headers("Content-Type: application/json")
    @GET("API/store_visit")
    Call<PagingResponStore_v> getListStore_visit(@Query( PreferenceManager.EMAIL) String email,
                                                 @Header("Authorization") String  Token
                                                 );


    @GET("API/GetProductList")
    Call<PagingResponProduct>getProductList();


//    @Headers("Content-Type: application/json")
    @POST("API/Auth_api")
    Call<ResponLogin> auth(@Body LoginReaquest loginReaquest);

    @Headers("Accept : application/json")
    @GET("API/Auth_api")
    Call<AuthorizationRespon> login(@Header("Authorization") String authorization);

    @Headers("Content-Type: application/json")
    @GET("API/data_user_api/{id}")
    Call<UserRespon> getUser(@Header("Authorization") String authorization, @Path("id") String id);

    @GET("API/data_user_api")
    Call<UserRespon> getDataUser(@Query( PreferenceManager.EMAIL) String email);

    @Headers("Content-Type: application/json")
    @GET("API/history_api")
    Call<ResponHistory> getHistory(@Query( PreferenceManager.EMAIL) String email, @Header("Authorization") String  Token);
    
    @FormUrlEncoded
    @POST("API/Report_api")
    Call<ResponseBody>InsertDataReport(
                                @Field("user_id") String UserId,
                                @Field("store_id") String StoreId,
                                @Field("product_id") String ProductId,
                                @Field("category_id") String CategoryId,
                                @Field("qty") String Quantity,
                                @Field("facing") String Facing,
                                @Field("price_card") String PriceCard,
                                @Field("fifo_product") String fifo,
                                @Field("normal_price") String NormalPrice,
                                @Field("promo_price") String PromoPrice,
                                @Field("planogram") String Planogram,
                                @Field("promotion") String Promotion,
                                @Field("Verify_by") String Verify_by);
    @FormUrlEncoded
    @POST("API/Coba")
    Call<ResponseBody>insertdata(@Field("user_id")String nama,
            @Field("store_id")String email);

}
