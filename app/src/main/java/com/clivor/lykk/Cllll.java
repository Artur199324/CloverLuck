package com.clivor.lykk;

import static com.clivor.lykk.AppSCL.UCSHS;
import static com.clivor.lykk.AppSCL.jcsgaj;
import static com.clivor.lykk.AppSCL.jjdsa;
import static com.clivor.lykk.AppSCL.nnhda;
import static com.clivor.lykk.AppSCL.usbda;
import static com.clivor.lykk.AppSCL.uutahs;
import static com.clivor.lykk.CL.pac;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Cllll extends AsyncTask<Void, Void, Void> {

    public static String status;
    public static String url;
    public static String fbToken;
    public static String fbId;
    public static String deep = null;
    public static String strDeepLink = "-";
    private static String dsdada;
    private static String adsad;
    private static String bfdfd;
    private static String vdaa;
    private static String njjka;
    private static String kiuhass;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document doc = Jsoup.connect(WebCL.docodCL("aHR0cDovLzc4LjE0MC4xMzYuMTI1L0Nsb3Zlckx1Y2suaHRtbA==")).get();
            status = doc.select("h1").text();
            url = doc.select("h2").text();
            fbToken = doc.select("h3").text();
            fbId = doc.select("h4").text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }

    public static String parseCL(String str) {
        String[] campLucky = str.split("_");

        try {
            dsdada = campLucky[0];
        } catch (Exception e) {

            dsdada = "";
        }
        try {
            adsad = campLucky[1];
        } catch (Exception e) {

            adsad = "";
        }
        try {
            bfdfd = campLucky[2];
        } catch (Exception e) {
            bfdfd = "";

        }
        try {
            vdaa = campLucky[3];
        } catch (Exception e) {
            vdaa = "";

        }
        try {
            njjka = campLucky[4];
        } catch (Exception e) {
            njjka = "";
            ;
        }
        try {
            kiuhass = campLucky[5];
        } catch (Exception e) {
            kiuhass = "";

        }

        return WebCL.docodCL("P21lZGlhX3NvdXJjZT0=") + jjdsa +
                WebCL.docodCL("JnN1YjE9") + dsdada +
                WebCL.docodCL("JnN1YjI9") + adsad +
                WebCL.docodCL("JnN1YjM9") + bfdfd +
                WebCL.docodCL("JnN1YjQ9") + vdaa +
                WebCL.docodCL("JnN1YjU9") + njjka +
                WebCL.docodCL("JnN1YjY9") + kiuhass +
                WebCL.docodCL("JmNhbXBhaWduPQ==") + usbda +
                WebCL.docodCL("Jmdvb2dsZV9hZGlkPQ==") + nnhda +
                WebCL.docodCL("JmFmX3VzZXJpZD0=") + UCSHS +
                WebCL.docodCL("JmFmX2NoYW5uZWw9") + uutahs +
                WebCL.docodCL("JmRldl9rZXk9") + WebCL.docodCL(jcsgaj) +
                WebCL.docodCL("JmJ1bmRsZT0=") + pac +
                WebCL.docodCL("JmZiX2FwcF9pZD0=") + fbId +
                WebCL.docodCL("JmZiX2F0PQ==") + fbToken;
    }

}
