package com.clivor.lykk;

import static com.clivor.lykk.AppSCL.dudhs;
import static com.clivor.lykk.AppSCL.njsya;
import static com.clivor.lykk.AppSCL.ndjs;
import static com.clivor.lykk.AppSCL.vvsa;
import static com.clivor.lykk.AppSCL.njdjs;
import static com.clivor.lykk.Cllll.vsvs;
import static com.clivor.lykk.Cllll.mjhsh;
import static com.clivor.lykk.WebCL.cacv;
import static com.clivor.lykk.WebCL.sda;
import static com.clivor.lykk.WebCL.uhsd;
import static com.clivor.lykk.WebCL.vds;
import static com.clivor.lykk.WebCL.cabf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.clivor.lykk.db.EntityCL;
import com.clivor.lykk.db.SaveDataBase;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.onesignal.OneSignal;

import java.util.Random;


public class CL extends AppCompatActivity {

    ImageView dhs;
    Handler cshs;
    WebView webCL;
    Button jshsd;
    public static String jhs;
    int hsa = 0;
    SaveDataBase hsha;
    String hdgs;
    int saas;
    boolean ee = false;


    @Override
    protected void onStart() {
        super.onStart();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(WebCL.docodCL("Y2U3NTIwMTctYTkxZS00M2JiLThmYTktOTY4ODZjMmJkYTZj"));
        jhs = getPackageName();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cl);
        webCL = findViewById(R.id.webCL);
        AppSCL.appSl(CL.this);
        WebCL.cl = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                hsha = Room.databaseBuilder(getApplicationContext(),
                        SaveDataBase.class, "udus").build();

                try {
                    hdgs = hsha.daoTab().getLastDao().getSaveLinc();
                    Log.d("wwww", hdgs + "pppp");
                    saas = hsha.daoTab().gethowMuchWeHaveDao();
                } catch (Exception e) {
                    Log.d("wwww", "pppp");
                }
            }
        }).start();

        dhs = findViewById(R.id.imageViewLoad);
        jshsd = findViewById(R.id.buttonInter);
        jshsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CL.class));
                finishAffinity();
            }
        });
        cshs = new Handler();
        cshs.post(new Runnable() {
            @Override
            public void run() {
                dhs.setRotation(dhs.getRotation() + 500);
                Random random = new Random();
                int r = random.nextInt(7);
                switch (r) {
                    case 0:
                        dhs.setImageResource(R.drawable.slot1);
                        break;
                    case 1:
                        dhs.setImageResource(R.drawable.slot2);
                        break;
                    case 2:
                        dhs.setImageResource(R.drawable.slot3);
                        break;
                    case 3:
                        dhs.setImageResource(R.drawable.slot4);
                        break;
                    case 4:
                        dhs.setImageResource(R.drawable.slot5);
                        break;
                    case 5:
                        dhs.setImageResource(R.drawable.slot6);
                        break;
                    case 6:
                        dhs.setImageResource(R.drawable.slot7);
                        break;
                }

                cshs.postDelayed(this::run, 400);
            }
        });

        if (isaj()) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (saas > 0) {
                        Log.d("wwww", "uuuuu");
                        webCL.setVisibility(View.VISIBLE);
                        webCL.loadUrl(hdgs);
                    } else {

                        Cllll cllll = new Cllll();
                        cllll.execute();
                        cshs.post(new Runnable() {
                            @Override
                            public void run() {
                                if (Cllll.sjas != null) {
                                    Log.d("weq", Cllll.sjas);
                                    Log.d("weq", Cllll.njac);
                                    Log.d("weq", Cllll.cacsa);
                                    Log.d("weq", Cllll.gfs);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            FacebookSdk.setApplicationId(Cllll.gfs);
                                            FacebookSdk.setAdvertiserIDCollectionEnabled(true);
                                            FacebookSdk.sdkInitialize(getApplicationContext());
                                            FacebookSdk.fullyInitialize();
                                            FacebookSdk.setAutoInitEnabled(true);
                                            FacebookSdk.setAutoLogAppEventsEnabled(true);

                                            AppEventsLogger.activateApp(getApplication());
                                            AppLinkData.fetchDeferredAppLinkData(getApplicationContext(), new AppLinkData.CompletionHandler() {
                                                @Override
                                                public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {

                                                    if (appLinkData == null) {
                                                        appLinkData = AppLinkData.createFromActivity(CL.this);

                                                    }
                                                    if (appLinkData != null) {

                                                        String[] as = appLinkData.getTargetUri().toString().split("://");
                                                        vsvs = as[1];
                                                        mjhsh = Cllll.parseCL(vsvs);

                                                    } else {

                                                    }
                                                }
                                            });

                                            cshs.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    hsa++;
                                                    Log.d("rrrr", hsa + "");
                                                    if (!ndjs.equals("-") || !mjhsh.equals("-")) {
                                                        if (ndjs.equals(WebCL.docodCL("Tm9uLW9yZ2FuaWM="))) {
                                                            String load = Cllll.njac + njsya;
                                                            webCL.setVisibility(View.VISIBLE);
                                                            webCL.loadUrl(load);
                                                            Log.d("weq", "App" + load);
                                                            hsa = 5;
                                                            ee = true;
                                                            new Thread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    EntityCL entityCL = new EntityCL(load);
                                                                    hsha.daoTab().entity(entityCL);
                                                                }
                                                            }).start();
                                                        } else if (vsvs != null) {
                                                            String load = Cllll.njac + mjhsh;
                                                            webCL.setVisibility(View.VISIBLE);
                                                            webCL.loadUrl(load);
                                                            hsa = 5;
                                                            ee = true;
                                                            Log.d("weq", "Dipp" + load);
                                                            new Thread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    EntityCL entityCL = new EntityCL(load);
                                                                    hsha.daoTab().entity(entityCL);
                                                                }
                                                            }).start();
                                                        }else {
                                                            if (Cllll.sjas.equals("0")) {

                                                                startActivity(new Intent(getApplicationContext(), ButtAcCl.class));
                                                                finishAffinity();
                                                                hsa = 5;
                                                            } else {

                                                                String uyu = Cllll.njac + WebCL.docodCL("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                                                                        WebCL.docodCL("Jmdvb2dsZV9hZGlkPQ==") + njdjs +
                                                                        WebCL.docodCL("JmFmX3VzZXJpZD0=") + dudhs +
                                                                        WebCL.docodCL("JmRldl9rZXk9") + WebCL.docodCL(vvsa) +
                                                                        WebCL.docodCL("JmJ1bmRsZT0=") + getPackageName() +
                                                                        WebCL.docodCL("JmZiX2FwcF9pZD0=") + Cllll.gfs +
                                                                        WebCL.docodCL("JmZiX2F0PQ==") + Cllll.cacsa;
                                                                webCL.setVisibility(View.VISIBLE);
                                                                webCL.loadUrl(uyu);
                                                                Log.d("weq", "organic");
                                                                new Thread(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        EntityCL entityCL = new EntityCL(uyu);
                                                                        hsha.daoTab().entity(entityCL);
                                                                    }
                                                                }).start();
                                                                hsa = 5;
                                                            }

                                                        }
                                                    }

                                                    if (hsa != 5) {
                                                        cshs.postDelayed(this::run, 1000);
                                                        hsa = 0;
                                                    }

                                                }
                                            });

                                        }
                                    });

                                } else {
                                    cshs.postDelayed(this::run, 500);
                                }

                            }
                        });
                    }
                }
            }, 1000);


        } else {
            jshsd.setVisibility(View.VISIBLE);
            dhs.setVisibility(View.INVISIBLE);
        }


    }

    private boolean isaj() {
        String daasa = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(daasa);
        if (cm.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (webCL.isFocused() && webCL.canGoBack()) {
            webCL.goBack();
        }
    }

    @Override
    protected void onActivityResult(int sas, int bfd, @Nullable Intent saa) {
        if (sas != uhsd || vds == null) {
            super.onActivityResult(sas, bfd, saa);
            return;
        }
        Uri[] csa = null;
        if (bfd == Activity.RESULT_OK) {
            if (saa == null) {
                if (cabf != null) {
                    csa = new Uri[]{Uri.parse(cabf)};
                }
            } else {
                String dataString = saa.getDataString();
                if (dataString != null) {
                    csa = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        vds.onReceiveValue(csa);
        vds = null;
        if (sda == null) {
            super.onActivityResult(sas, bfd, saa);
            return;
        }
        Uri ajca = null;
        try {
            if (bfd != RESULT_OK) {
                ajca = null;
            } else {
                ajca = saa == null ? cacv : saa.getData();
            }
        } catch (Exception e) {
        }
        sda.onReceiveValue(ajca);
        sda = null;
    }
}
