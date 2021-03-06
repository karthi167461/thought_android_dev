/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package thoughtnote.com.utilz;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.google.android.gms.common.util.Base64Utils;
import com.google.gson.Gson;
import thoughtnote.com.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by amitshekhar on 07/07/17.
 */

public final class CommonUtils {
    private static final double EARTHRADIUS = 6366198;

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    /**
     * @param context reference of the Class
     * @return the progress dialog instance.
     */
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * @param email user entered email
     * @return true or false whether valid or inValid email.
     */
    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    /**
     * Method checks if the app is in background or not
     */
    public static boolean isAppIsInBackground(Context context) {
        boolean isInBackground = true;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (String activeProcess : processInfo.pkgList) {
                        if (activeProcess.equals(context.getPackageName())) {
                            isInBackground = false;
                        }
                    }
                }
            }
        } else {
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
            ComponentName componentInfo = taskInfo.get(0).topActivity;
            if (componentInfo.getPackageName().equals(context.getPackageName())) {
                isInBackground = false;
            }
        }

        return isInBackground;
    }

    /**
     * @param s user entered string on UI
     * @return true or false whether the entered string is empty or not.
     */
    public static boolean IsEmpty(String s) {
        return s == null || s.isEmpty() || s.equalsIgnoreCase("null") || s.length() == 0;
    }

   /* public static String getTimeStamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
    }*/

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {
        //    Glide.with(view.getContext()).load(url).centerCrop().into(view);
    }

    /*  */

    /**
     * Helper method to format information about a place nicely.
     *//*
    private static Spanned formatPlaceDetails(Resources res, CharSequence name, String id,
                                              CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
     *//*   Log.e(TAG, res.getString(R.string.place_details, name, id, address, phoneNumber,
                websiteUri));*//*
        return Html.fromHtml(res.getString(R.string.place_details, name, id, address, phoneNumber,
                websiteUri));

    }*/

    /**
     * @param bytes Value of ByteArrayOutPutStream.
     * @return null
     */
    public static String WriteImage(ByteArrayOutputStream bytes) {
        File ExternalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(ExternalStorageDirectory + File.separator + "profile.jpg");
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes.toByteArray());

            return file.getAbsolutePath();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static int GetScreenwidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        return displayMetrics.widthPixels;
    }


    //NOt used
    private static double meterToLongitude(double meterToEast, double latitude) {
        double latArc = Math.toRadians(latitude);
        double radius = Math.cos(latArc) * EARTHRADIUS;
        double rad = meterToEast / radius;
        return Math.toDegrees(rad);
    }

    //Not used.
    private static double meterToLatitude(double meterToNorth) {
        double rad = meterToNorth / EARTHRADIUS;
        return Math.toDegrees(rad);
    }

    /**
     * @param context    instance of particular class or fragment
     * @param drawableId
     * @return bitmap image
     */
    public static Bitmap getBitmapFromDrawable(Context context, @DrawableRes int drawableId) {
        Drawable drawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (context != null)
                drawable = ContextCompat.getDrawable(context, drawableId);
        } else
            drawable = VectorDrawableCompat.create(context.getResources(), drawableId, context.getTheme());
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof VectorDrawableCompat || drawable instanceof VectorDrawable) {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);

            return bitmap;
        } else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }


    /**
     * @param value is a Double instance
     * @return a double value with doubleDecimalformat.
     */
    public static String doubleDecimalFromat(Double value) {
        String result = value + "";
        try {
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
            otherSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            decimalFormat.setDecimalFormatSymbols(otherSymbols);
            result = decimalFormat.format(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Not used
     *
     * @param value is a Double instance
     * @return a double value with trippleDecimalFromat.
     */
    public static String trippleDecimalFromat(Double value) {
        if (value == null)
            return value + "";
        String result = value + "";
        try {
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
            otherSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("0.000", otherSymbols);
            result = decimalFormat.format(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param phoneNumber is string from user entered.
     * @return a string value of remove first zero.
     */
    public static String removeFirstZeros(String phoneNumber) {
        String resolvedPhoeNumber = phoneNumber;
        do {
            if (resolvedPhoeNumber.startsWith("0"))
                resolvedPhoeNumber = resolvedPhoeNumber.substring(1, resolvedPhoeNumber.length() == 1 ? resolvedPhoeNumber.length() : resolvedPhoeNumber.length());
        } while (resolvedPhoeNumber.startsWith("0"));
        return resolvedPhoeNumber;
    }

    /**
     * @param context is instance of particular class.
     * @return a boolean value whether Gps is on or not
     */
    public static boolean isGpscheck(Context context) {
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void ShowGpsDialog(final Activity context) {

//        android.app.AlertDialog.Builder gpsBuilder = new android.app.AlertDialog.Builder(context);
//        gpsBuilder.setCancelable(false);
//        gpsBuilder.setTitle(context.getString(R.string.dialog_no_gps))
//                .setMessage(context.getString(R.string.dialog_no_gps_messgae))
//                .setPositiveButton(context.getString(R.string.dialog_enable_gps), new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        context.startActivityForResult(intent, BaseActivity.REQUEST_ENABEL_LOCATION);
//
//                     /*   Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
//                        intent.putExtra("enabled", true);
//                        context.sendBroadcast(intent);*/
//                        dialog.dismiss();
//
//
//                    }
//                })
//                .setNegativeButton(context.getString(R.string.Txt_Exit), new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        context.finish();
//                        dialog.dismiss();
//                    }
//                });
//        AlertDialog gpsAlertDialog = gpsBuilder.create();
//        gpsAlertDialog.show();
    }


    /**
     * @param json       is a string value of Api response.
     * @param modelclass is pojo class which the response depends.
     * @param <T>        is Any dataType.
     * @return nothing
     */
    public static <T> T getSingleObject(String json, Class<T> modelclass) {
        try {
            return new Gson().fromJson(json, modelclass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param inputValue is a string contains CVV number of Added card.
     * @return the ReOrdered cvv number.
     */
    public static String getReOrdered(String inputValue) {
        String result = inputValue;
        try {
            if (inputValue != null && inputValue.length() > 0) {
                char[] arrayChar = inputValue.toCharArray();
                result = arrayChar[arrayChar.length - 1] + "";
                if (arrayChar.length > 1)
                    for (int i = 0; i < (arrayChar.length - 1); i++) {
                        result += arrayChar[i];
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param inputValue is a string value CVV.
     * @return the Random number instead of CVV.
     */
    public static String addRandomNumber(String inputValue) {
        String result = inputValue;
        try {
            result = (10 + new Random().nextInt(90)) + inputValue;
            result = result + (100 + new Random().nextInt(900));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param inputValue is a string of CVV number
     * @return the encrypted CVV number.
     */
    public static String convertBase64(String inputValue) {
        String result = inputValue;
        try {
            byte[] data = inputValue.getBytes(StandardCharsets.UTF_8);

            result = Base64Utils.encode(data).trim();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
