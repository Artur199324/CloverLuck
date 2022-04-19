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

    public static String dudhs;
    public static String ndjs = "-";
    public static String njdjs;
    public static String njsya;
    public static String vvsa = "QUZpUVpGY2N3VzNBQTk0NmhWMjQ4WQ==";
    public static String bbbc;
    public static String vas;
    public static String nngf;

    public static void appSl(CL cl) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    njdjs = AdvertisingIdClient.getAdvertisingIdInfo(cl.getApplicationContext()).getId();
                    Log.d("weq", njdjs);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        dudhs = AppsFlyerLib.getInstance().getAppsFlyerUID(cl.getApplicationContext());
        Log.d("weq", dudhs);

        AppsFlyerLib.getInstance().init(WebCL.docodCL(vvsa), new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                ndjs = map.get(WebCL.docodCL("YWZfc3RhdHVz")).toString();
                Log.d("rrrr", ndjs + "");

                if (ndjs.equals(WebCL.docodCL("Tm9uLW9yZ2FuaWM="))) {

                    try {
                        bbbc = map.get(WebCL.docodCL("Y2FtcGFpZ24=")).toString();
                    } catch (Exception e) {

                    }

                    try {
                        vas = map.get(WebCL.docodCL("bWVkaWFfc291cmNl")).toString();
                    } catch (Exception e) {

                    }

                    try {
                        nngf = map.get(WebCL.docodCL("YWZfY2hhbm5lbA==")).toString();
                    } catch (Exception e) {

                    }

                    njsya = Cllll.parseCL(bbbc);

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
