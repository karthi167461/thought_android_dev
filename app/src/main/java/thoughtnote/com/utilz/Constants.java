package thoughtnote.com.utilz;

/**
 * Created by root on 9/22/17.
 */

/**
 * Common used files
 */
public final class Constants {
    public static final int BOTTOMSHEETCALLBACK = 23123;
    public static final int BOTTOMSHEETRIDECALLBACK = 23124;
    public static final int CANCELTRIPCALLBACK = 23134;
    public static final int RIDE_PROMO_RESULT = 99;
    public static boolean ACTIVITY_OPENEND_ALRDY = false;
    public static String[] Array_permissions = new String[]{
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION};
    public static String[] storagePermission = new String[]{
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
    public static int SPLASH_TIME_OUT = 3000;
    public static final int REQUEST_PERMISSION = 9000;
    public static final int SELECT_FILE = 100;
    public static final int REQUEST_CAMERA = 200;
    public static final int GOOGLE_SIGN_IN = 300;
    public final static int PLAY_SERVICES_REQUEST = 1000;
    public final static int BRAINTREE_REQUEST_CODE = 500;
    public static final int REQUEST_CODE_AUTOCOMPLETE = 700;
    public static final int REQUEST_CODE_ENABLING_GOOGLE_LOCATION = 400;
    public static final int REQUEST_CODE_AUTOCOMPLETE_DROPADD_FROMRIDEFRG = 1100;
    public static final float ZOOMLEVELMAP = 18f;
    public static final int REQUEST_CODE_AUTOCOMPLETEINRIDE = 800;
    public static final int REQUEST_CHANGE_ADDRESS = 900;
    public final static int WALLETSETRESULT = 600;
    public final static int PROMOSETRESULT = 8100;
    public final static int HISTORYLISTSETRESULT = 9100;

    public static final int REQUESTCODE_QR = 49374;


    public static final String EXTRA_Data = "Data";
    public static final String EXTRA_RIDE_TYPE = "extra_ride_type";
    public static final String ourApp = "ourApp";
    public static final String googleMap = "googleMap";
    public static final String countryMap = "countryMap";
    public static final String EXTRA_IS_CORPORATE = "EXTRA_IS_CORPORATE";
    public static final String EXTRA_LAT_LNG = "EXTRA_LAT_LNG";
    public static final String EXTRA_SEARCH_TYPE = "extra_search_type";

    public static String Extra_identity = "identity";
    public static String RideNow = "RideNow";
    public static String RideLater = "RideLater";
    public static String PushWaitingorAcceptByDriver = "PushWaitingorAcceptByDriver";

    public static String pushRejected = "pushRejected";
    public static String driverChanged = "driverChanged";

    public static String PlaceApi_key = "AIzaSyB_oJC2B0Gpqq2obBLA-oUXw9HRBp7nDmQ";
    public static String ProfileBroastcast = "ProfileBroastcast";
    public static String PushTripCancelled = "PushTripCancelled";
    public static String PushTripCompleted = "PushTripCompleted";
    public static String Pushbillgenerated = "Pushbillgenerated";
    public static String DismissDialog = "DismissDialog";
    public static String EXTRA_Datastrn = "EXTRA_Datastrn";
    public static String COUNTRY_CODE = "IN";
    public static String text_default_country_codes = "+91";
    public static Integer PAY_CARD = 0;
    public static Integer PAY_CASH = 1;
    public static Integer PAY_WALLET = 2;
    public final static Integer IMAGE_COMPRESSION_QUALITY = 40;
    public static String isLogin = "isLogin";
    public static String CHOOSED_COUNTRYCODE = "IN";
    public static String WAKE_LOCK_TAG = "myapp:LIMO_WAKE_LOCK_TAG";
    public static String WAKE_LOCK_TAG2 = "myapp:LIMO_WAKE_LOCK_TAG2";
    public static String PhonewithCountry = "phoneWithCountry";

    /**
     * Api 500 Errorcode message.
     */
    public interface HttpErrorMessage {
        String INTERNAL_SERVER_ERROR = "Our server is under maintenance. We will reslove shortly!";
    }

    /**
     * Local broadcast receiever.
     */
    public interface BroadcastsActions {
        String B_REQUEST = "B_REQUEST";
        String LATER_NO_DRIVER = "LATER_NO_DRIVER";
        String RemoveWaitingDialog = "RemoveWaitingDialog";
    }

    /**
     * Error code from Api
     */
    public interface ErrorCode {
        Integer TOKEN_EXPIRED = 609;
        Integer EMPTY_FAV_LIST = 721;
        Integer TOKEN_MISMATCHED = 606;
        Integer INVALID_LOGIN = 603;
        Integer REQUEST_NOT_REGISTERED = 803;
        Integer REQUEST_ALREADY_CANCELLED = 808;
        Integer DRIVER_ALREADY_RATED = 904;
        int COMPANY_KEY_DATE_EXPIRED = 1101;
        int COMPANY_KEY_NOT_ACTIVE = 1102;
        int COMPANY_KEY_NOT_VALID = 1105;
        int COMPANY_CREDENTIALS_NOT_VALID = 1100;
    }

    /**
     * Api URL
     */
    public interface URL {
        String LoginURL = "v1/user/login";
        String TokenGeneratorURL = "v1/user/temptoken";
        String BaseURL = "https://www.nplustechnologies.com/taxi2.0/public/";
        String SOCKET_URL = "https://www.nplustechnologies.com:3005/driver/home";

        String CC_URL = "v1/country/list";
        String GooglBaseURL = "https://maps.googleapis.com/";
        String COUNTRY_CODE_URL = "http://ip-api.com/";//"/json";
        String ISRegistered = "v1/user/social_unique_id_check";
        String SignUpURL = "v1/user/signup";
        String LoginByOTPURL = "v1/user/login/otp";
        String ProfileURL = "v1/user/profile";
        String otpvalidate = "v1/user/otpvalidate";
        String carddefaultURL = "v1/user/carddefault";
        String deletecardURL = "v1/user/deletecard";
        String ETAURL = "v1/application/eta";
        String otpsendURL = "v1/user/sendotp";
        String createrequestURl = "v1/user/createrequest";
        String createrequestLaterURl = "v1/user/ridelater";
        String GetreferralURL = "v1/user/getreferral";
        String DeletefavURL = "v1/user/deletefav";
        String CompliantsURL = "v1/compliants/list";
        String PromoURL = "v1/user/promocode/check";
        String ridelatercancelURL = "v1/user/ridelatercancel";
        String CANCEL_REASON_LIST_URL = "v1/cancellation/list";
        String SendCompliantURL = "v1/compliants/user";
        String addwalletURL = "v1/user/addwallet";
        String addcardURL = "v1/user/addcard";
        String historySingleURL = "v1/user/historySingle";
        String cardlistURL = "v1/user/cardlist";
        String getwalletURL = "v1/user/getwallet";
        String ClienttokenURL = "v1/application/client_token";
        String otpResend = "v1/user/resendotp";
        String Forgoturl = "v1/user/forgotpassword";
        String referralcheckUrl = "v1/user/referralcheck";
        String requestInprogressURL = "v1/user/requestInprogress";
        String historyListURL = "v1/user/historyList";
        String AddFavurl = "v1/user/addfav";
        String Reviewurl = "v1/user/review";
        String DirectionURLreferralcheckUrl = "maps/api/directions/json?";
        String DirectionURL = "maps/api/directions/json?";
        String Requestcancelurl = "v1/user/request/cancel";
        String ListFavurl = "v1/user/listfav";
        String ZoneSOSUrl = "v1/user/zonesos";
        String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
        String TYPE_AUTOCOMPLETE = "/autocomplete";
        String TYPE_NEAR_BY = "/nearbysearch";
        String OUT_JSON = "/json";
        String TRANSLATIONS_DOC = "v1/lang/get";
        String PREFFERED_PAYMENT = "v1/user/preferred/payment";
        String FAQ_LIST = "v1/user/get/faqlist";
        String SUPPORT = "v1/Users/support/email";
        String DriverList = "v1/driver/top/list";
        String singleDriver = "v1/user/custom/driver/select";
        String walletHistory = "v1/user/wallet/history";
        String changeLocationInRide = "v1/user/pickup/change";
        String userProfileretrive = "v1/user/profile/retrive";
        String changeLocationInRideDrop = "v1/user/drop/change";
        String topratedConfirm = "v1/driver/top/confirm";
        String CANCELLATION_LIST = "v1/user/cancellation/list";
        String PROMOCODE_ETA = "v1/user/promocode/queue";
        String RESCHEDULE_TRIP = "v1/user/reschedule/later/trip";
        String USER_WALLET_HISTORY = "v1/user/wallet/history";
        String USER_CANCELLATION_HISTORY = "v1/user/cancellation/list";
        String USER_BLOCKED = "v1/user/decline";
        String CHECKOUTID = "v1/create/checkout";
        String REQUEST_COMPANY_KEY = "v1/client/request/token";
        String CHECK_COMPANY_KEY_STATUS = "v1/client/token/check";
    }
    //Intent Keys.
    public interface IntentExtras {
        String REQUEST_DATA = "request_data";
        String COUNTRY_LIST = "country_list";
        String WAITING_TIME = "waiting_time";
        String PREVAILING_WAITING_TIME = "PrevailingWAiting";
        String PREVAILING_WAITING_SEC = "prevailing_waiting_sec";
        String CANCEL_REASON = "cancel_reason";
        String ADD_CHARGE_VALUES = "ADD_CHARGE_VALUES";
        String RIDE_OTP = "ride_otp";
        String ACCEPT_REJECT_DATA = "accept_reject_data";
        String LOCATION_DATA = "location_data";
        String USER_PHONE = "USER_PHONE";
        String LOCATION_ID = "LOCATION_ID";
        String LOCATION_LAT = "LAT";
        String LOCATION_LNG = "LNG";
        String TRIP_LAT = "TRIP_LAT";
        String TRIP_LNG = "TRIP_LNG";
        String TRIP_BEARING = "TRIP_BEARING";
        String LOCATION_BEARING = "BEARING";
    }
    /**
     * Api paramater names
     */
    public interface NetworkParameters {
        String email = "email";
        String type = "type";
        String new_password = "new_password";
        String old_password = "old_password";
        String platitude = "platitude";
        String start_connect = "start_connect";
        String plongitude = "plongitude";
        String dlongitude = "dlongitude";
        String dlatitude = "dlatitude";
        String paymentOpt = "paymentOpt";
        String dlocation = "dlocation";
        String plocation = "plocation";
        String id = "id";
        String token = "token";
        String message = "message";
        String timezone = "timezone";
        String datetime = "datetime";
        String page = "page";
        String request_id = "request_id";
        String reason = "reason";
        String promo_code = "promo_code";
        String title = "title";
        String description = "description";
        String nickName = "nickName";
        String placeId = "placeId";
        String latitude = "latitude";
        String longitude = "longitude";
        String card_id = "card_id";
        String type_id = "type_id";
        String car_id = "car_id";
        String olat = "olat";
        String olng = "olng";
        String dlat = "dlat";
        String dlng = "dlng";
        String amount = "amount";
        String payment_id = "payment_id";
        String last_number = "last_number";
        String card_type = "card_type";
        String otp_key = "otp_key";
        String firstname = "firstname";
        String lastname = "lastname";
        String phonenumber = "phone_number";
        String CountryDummy = "CountryDummy";
        String profile_pic = "profile_pic";
        String username = "username";
        String android = "android";
        String manual = "manual";
        String Yes = "Yes";
        String facebook = "facebook";
        String google = "google";
        String password = "password";
        String device_token = "device_token";
        String login_by = "login_by";
        String login_method = "login_method";
        String country_code = "country_code";
        String country = "country";
        String IsEnabled = "IsEnabled";
        String social_unique_id = "social_unique_id";
        String favid = "favid";
        String comment = "comment";
        String rating = "rating";
        String timeZone = "time_zone";
        String is_share = "is_share";
        String is_signup = "is_signup";
        String no_of_seats = "no_of_seats";
        String admin_key = "admin_key";
        String payment_type = "payment_type";
        String cancel_other_reason = "cancel_other_reason";
        String phoneNumber = "phoneNumber";
        String driver_id = "driver_id";
        String privateKey = "private_key";
        String complaint_type = "complaint_type";
        String request_type = "request_type";
        String user_type = "user_type";
        String promo_booked_id = "promo_booked_id";
        String new_flow = "new_flow";
        String CardHolderName = "card_holder_name";
        String EXP_DATE = "expiry_date";
        String CARD_NUM = "card_number";
        String CVV_NUM = "cvv";
        String TIME_TAKES = "time_takes";
        String url = "url";
        String name = "name";
        String client_id = "client_id";
        String client_token = "client_token";
        String dialcode = "dialcode";
        String company_token = "company_token";
        String gender = "gender";

    }

}
