package com.clivor.lykk;

import static com.clivor.lykk.AppSCL.dudhs;
import static com.clivor.lykk.AppSCL.vvsa;
import static com.clivor.lykk.AppSCL.vas;
import static com.clivor.lykk.AppSCL.njdjs;
import static com.clivor.lykk.AppSCL.bbbc;
import static com.clivor.lykk.AppSCL.nngf;
import static com.clivor.lykk.CL.jhs;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Cllll extends AsyncTask<Void, Void, Void> {

    public static String sjas;
    public static String njac;
    public static String cacsa;
    public static String gfs;
    public static String vsvs = null;
    public static String mjhsh = "-";
    private static String mjsy;
    private static String jsyd;
    private static String nhsd;
    private static String njshy;
    private static String hsggd;
    private static String hysd;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document doc = Jsoup.connect(WebCL.docodCL("aHR0cDovLzc4LjE0MC4xMzYuMTI1L0Nsb3Zlckx1Y2suaHRtbA==")).get();
            sjas = doc.select("h1").text();
            njac = doc.select("h2").text();
            cacsa = doc.select("h3").text();
            gfs = doc.select("h4").text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }

    public static String parseCL(String vs) {
        String[] aaaax = vs.split("_");

        try {
            mjsy = aaaax[0];
        } catch (Exception e) {

            mjsy = "";
        }
        try {
            jsyd = aaaax[1];
        } catch (Exception e) {

            jsyd = "";
        }
        try {
            nhsd = aaaax[2];
        } catch (Exception e) {
            nhsd = "";

        }
        try {
            njshy = aaaax[3];
        } catch (Exception e) {
            njshy = "";

        }
        try {
            hsggd = aaaax[4];
        } catch (Exception e) {
            hsggd = "";
            ;
        }
        try {
            hysd = aaaax[5];
        } catch (Exception e) {
            hysd = "";

        }

        return WebCL.docodCL("P21lZGlhX3NvdXJjZT0=") + vas +
                WebCL.docodCL("JnN1YjE9") + mjsy +
                WebCL.docodCL("JnN1YjI9") + jsyd +
                WebCL.docodCL("JnN1YjM9") + nhsd +
                WebCL.docodCL("JnN1YjQ9") + njshy +
                WebCL.docodCL("JnN1YjU9") + hsggd +
                WebCL.docodCL("JnN1YjY9") + hysd +
                WebCL.docodCL("JmNhbXBhaWduPQ==") + bbbc +
                WebCL.docodCL("Jmdvb2dsZV9hZGlkPQ==") + njdjs +
                WebCL.docodCL("JmFmX3VzZXJpZD0=") + dudhs +
                WebCL.docodCL("JmFmX2NoYW5uZWw9") + nngf +
                WebCL.docodCL("JmRldl9rZXk9") + WebCL.docodCL(vvsa) +
                WebCL.docodCL("JmJ1bmRsZT0=") + jhs +
                WebCL.docodCL("JmZiX2FwcF9pZD0=") + gfs +
                WebCL.docodCL("JmZiX2F0PQ==") + cacsa;
    }

}
