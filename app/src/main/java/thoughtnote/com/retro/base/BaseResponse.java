package thoughtnote.com.retro.base;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import thoughtnote.com.retro.responsemodel.TranslationModel;
import thoughtnote.com.utilz.SharedPrefence;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by root on 9/27/17.
 */

/** contains commonly used API response parameters **/

public class BaseResponse implements Serializable {


    @SerializedName("success")
    @Expose
    public boolean success;
    @SerializedName("error_code")
    @Expose
    public Integer errorCode;

    @SerializedName("request_id")
    @Expose
    public int request_id;

    @SerializedName("error_message")
    @Expose
    public String errorMessage;
    @SerializedName("success_message")
    @Expose
    public String successMessage;

    @SerializedName("message")
    @Expose
    public String message;

    public static class ReasonCancel {
        @Expose
        public String id;
        @Expose
        public String cancellation_fee_name;

        public ReasonCancel(String s, String others) {
            id = s;
            cancellation_fee_name = others;
        }
    }

    /*public static class OptionsDeserilizer implements JsonDeserializer<BaseResponse> {
        @Override
        public BaseResponse deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            BaseResponse options = new Gson().fromJson(json, BaseResponse.class);
            JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject.has("request")) {
                JsonElement elem = jsonObject.get("request");
                if (elem != null && !elem.isJsonNull()) {
                    String valuesString = elem.getAsJsonObject().toString();
                    if (!TextUtils.isEmpty(valuesString)) {
                        Request values = new Gson().fromJson(valuesString, new TypeToken<Request>() {
                        }.getType());
                        options.setRequest(values);
                    }
                }
            }


            return options;
        }
    }*/

    public class DataObject {
        @Expose
        public TranslationModel en;
        @Expose
        public TranslationModel es;
        @Expose
        public TranslationModel fr;
        @Expose
        public TranslationModel ar;
        @Expose
        public TranslationModel ja;
        @Expose
        public TranslationModel ko;
        @Expose
        public TranslationModel pt;
        @Expose
        public TranslationModel zh;

    }

    public void saveLanguageTranslations(SharedPrefence sharedPrefence, Gson gson, DataObject dataObject) {
        JSONObject map = null;
        List<String> languages = new ArrayList<>();
        try {
            map = new JSONObject(gson.toJson(dataObject));
            Iterator<String> iterator = map.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                sharedPrefence.savevalue(key, map.get(key).toString());
                languages.add(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sharedPrefence.savevalue(SharedPrefence.LANGUAGES, gson.toJson(languages) + "");
    }
}
