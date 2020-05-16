package thoughtnote.com.retro;

import thoughtnote.com.retro.base.BaseResponse;
import thoughtnote.com.utilz.Constants;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by root on 9/25/17.
 */

public interface GitHubService {


    @FormUrlEncoded
    @POST(Constants.URL.TokenGeneratorURL)
    Call<BaseResponse> TokenGenerator(@FieldMap Map<String, String> map);


    @Multipart
    @POST(Constants.URL.ProfileURL)
    Call<BaseResponse> ProfileCall(
            @PartMap() Map<String, RequestBody> partMap,
            @Part MultipartBody.Part file);

}
