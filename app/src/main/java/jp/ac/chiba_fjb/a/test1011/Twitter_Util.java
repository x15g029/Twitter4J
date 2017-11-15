package jp.ac.chiba_fjb.a.test1011;


import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Twitter_Util {
    // アプリケーションキーコード
    private static final String PREFNAME = "AccessData";// ダミーデータ
    private static final String TOKEN = "930718975138308097-UnoLGYvKcOjpaggN7D50JG0d6dcJi72";// ダミーデータ
    private static final String TOKEN_SECRET = "1QxypgGxVF2sXD9nmQt7ybp2j2sJCduRHM2bOlji7nZIf";
    private static final String APIKEY = "a6KKV64vveAHOSfIFCDozqjet";
    private static final String APIKEY_SECRET = "783lskEMpYurA3e795uaJoUQjaMnieLHPcppELpodfNuDkAB29";
    private static Context context = null;
    private static Twitter mTwitter;

    // setter getter
    public static Context getContext() {
        return context;

    }

    public static void setContext(Context con) {
        context = con;

    }

    // Twitterの取得
    public static Twitter getTwitter() {
        mTwitter = new TwitterFactory().getInstance();
        mTwitter.setOAuthConsumer(APIKEY, APIKEY_SECRET);
        if (serchAccessToken()) {
            mTwitter.setOAuthAccessToken(getAccessToken());
        }
        return mTwitter;
    }

    // Store accessToken
    public static void setAccessToken(AccessToken accessToken) {
        SharedPreferences preferences = getContext().getSharedPreferences(
                PREFNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TOKEN, accessToken.getToken());
        editor.putString(TOKEN_SECRET, accessToken.getTokenSecret());
        editor.commit();
    }

    // getAccessToken
    public static AccessToken getAccessToken() {
        SharedPreferences preferences = getContext().getSharedPreferences(
                PREFNAME, Context.MODE_PRIVATE);

        String AccessToken = preferences.getString(TOKEN, null);
        String AccessTokenSecret = preferences.getString(TOKEN_SECRET, null);
        if (AccessToken != null && AccessTokenSecret != null) {
            return new AccessToken(AccessToken, AccessTokenSecret);
        } else {
            return null;
        }

    }// アクセストークンが存在すればTrue

    public static boolean serchAccessToken() {

        return getAccessToken() != null;
    }

    public static void keyDestroy() {
        SharedPreferences preferences = getContext().getSharedPreferences(
                PREFNAME, Context.MODE_PRIVATE);
        preferences.edit().clear().commit();
        Toast.makeText(getContext(), "解除しました", Toast.LENGTH_SHORT).show();
    }

}
