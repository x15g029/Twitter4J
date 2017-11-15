package jp.ac.chiba_fjb.a.test1011;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.File;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterSend extends AsyncTask<Object, Void, Void> {
    private final String APIKEY = "a6KKV64vveAHOSfIFCDozqjet";
    private final String APIKEY_SECRET = "783lskEMpYurA3e795uaJoUQjaMnieLHPcppELpodfNuDkAB29";
    private final String ACCESSTOKEN = "930718975138308097-UnoLGYvKcOjpaggN7D50JG0d6dcJi72";
    private final String ACCESSTOKEN_SECRET = "1QxypgGxVF2sXD9nmQt7ybp2j2sJCduRHM2bOlji7nZIf";
    private Twitter mTwitter;
    private String msg;
    private String count;
    private ProgressDialog dialog;
    private Context con;

    public TwitterSend(Context context) {
        con = context;
    }

    @Override
    protected void onPreExecute() {
        // TODO 自動生成されたメソッド・スタブ
        super.onPreExecute();
        dialog = new ProgressDialog(con);
        dialog.setTitle("pleas wait...");
        dialog.setMessage("Twitter update now");
        dialog.show();
    }

    @Override
    protected Void doInBackground(Object... params) {
        try {
            Log.v("log", "twittersend(log)");
            msg = String.valueOf(params[1]);
            File imgfile = new File(String.valueOf(params[2]));
            System.out.println("画像取得");
            mTwitter = Twitter_Util.getTwitter();
            StatusUpdate status = new StatusUpdate(msg + "\nうまい点数は：" + "です！！！！！");
            status.media(imgfile);
            mTwitter.updateStatus(status);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);
        dialog.dismiss();
        System.out.println("ぽすと");
    }

}