package thoughtnote.com.ui.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import thoughtnote.com.R;
import thoughtnote.com.retro.base.BaseResponse;
import thoughtnote.com.ui.drawerscreen.DrawerAct;
import thoughtnote.com.utilz.CommonUtils;
import thoughtnote.com.utilz.Constants;

import org.json.JSONException;
import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "DATA: " + remoteMessage.getData());
        Log.d(TAG, "Id: " + remoteMessage.getMessageId());


        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            if (CommonUtils.IsEmpty(remoteMessage.getData().get("message")))
                return;
            try {
                JSONObject json = new JSONObject(remoteMessage.getData().get("message"));
                BaseResponse model = CommonUtils.getSingleObject(json.toString(), BaseResponse.class);

                if (remoteMessage.getData().get("title") != null && remoteMessage.getData().get("title").equalsIgnoreCase("general notification")) {
                    sendNotification(remoteMessage.getData().get("message"), 1);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(String messageBody, int mesgid) {
        Intent intent = new Intent(this, DrawerAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "fcm_default_channel";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, getString(R.string.default_notification_channel_id))
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                        .setContentTitle(getString(R.string.app_name))
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(messageBody))
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, getString(R.string.default_notification_channel_id), importance);
            notificationManager.createNotificationChannel(mChannel);

        }
        notificationManager.notify(mesgid, notificationBuilder.build());
        wakupScreen();
    }

    /**
     * {@link android.os.PowerManager.WakeLock} is used to bring device from sleep mode
     **/
    private void wakupScreen() {
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = pm.isScreenOn();
        if (isScreenOn == false) {
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE, Constants.WAKE_LOCK_TAG);
            wl.acquire(10000);
            PowerManager.WakeLock wl_cpu = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, Constants.WAKE_LOCK_TAG2);
            wl_cpu.acquire(10000);
        }
    }
}