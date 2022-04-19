package com.clivor.lykk;

import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;
import java.util.Map;

public class AppSCL {

    public static String UCSHS;
    public static String ihhds = "-";
    public static String nnhda;
    public static String bbfkd;
    public static String jcsgaj = "QUZpUVpGY2N3VzNBQTk0NmhWMjQ4WQ==";
    public static String usbda;
    public static String jjdsa;
    public static String uutahs;

    public static void appSl(CL cl) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nnhda = AdvertisingIdClient.getAdvertisingIdInfo(cl.getApplicationContext()).getId();
                    Log.d("weq", nnhda);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        UCSHS = AppsFlyerLib.getInstance().getAppsFlyerUID(cl.getApplicationContext());
        Log.d("weq", UCSHS);

        AppsFlyerLib.getInstance().init(WebCL.docodCL(jcsgaj), new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                ihhds = map.get(WebCL.docodCL("YWZfc3RhdHVz")).toString();

                if (ihhds.equals(WebCL.docodCL("Tm9uLW9yZ2FuaWM="))) {

                    try {
                        usbda = map.get(WebCL.docodCL("Y2FtcGFpZ24=")).toString();
                    } catch (Exception e) {

                    }

                    try {
                        jjdsa = map.get(WebCL.docodCL("bWVkaWFfc291cmNl")).toString();
                    } catch (Exception e) {

                    }

                    try {
                        uutahs = map.get(WebCL.docodCL("YWZfY2hhbm5lbA==")).toString();
                    } catch (Exception e) {

                    }

                    bbfkd = Cllll.parseCL(usbda);

                }

            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        }, cl.getApplicationContext());
        AppsFlyerLib.getInstance().start(cl.getApplicationContext());
    }
}
