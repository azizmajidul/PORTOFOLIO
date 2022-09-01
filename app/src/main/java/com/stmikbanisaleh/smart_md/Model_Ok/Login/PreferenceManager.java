package com.stmikbanisaleh.smart_md.Model_Ok.Login;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class PreferenceManager {

    private SharedPreferences.Editor editor;

    private static final String TOKEN = "token";
    private static  final  String ID = "id";
    public static final String USER_NAME = "name";
    public static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String AREA_COVERAGE = "area_coverage";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String ROLE_ID = "role_id";
    private static final String IS_LOGIN = "islogin";
    private static  final String REMEMBER_ME = "remember_me";

    private String token;
    private String id;
    private String name;
    private String email;
    private String password;
    private String area_coverage;
    private String address;
    private String city;
    private String role_id;
    private String date_created;
    private boolean isLogin;
    private  boolean remember_me;
    private Context context;
    private SharedPreferences preferences;


    public PreferenceManager(Context context){
        this.context= context;
        preferences = context.getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE);
        editor = preferences.edit();

    }
    public void logoutUser(){
    editor.clear();
    editor.commit();
    }




    public  String getToken() {
        token = preferences.getString(TOKEN,"");
        return token;
    }

    public void setToken(String token){
        this.token = token;
        preferences.edit().putString(TOKEN,token).apply();
    }


    public String getDate_created() {
        return date_created;
    }

    public void setCurrentTime(String currentTime) {
        this.date_created = currentTime;
    }

    public String getUserName(){
        name = preferences.getString(USER_NAME,"");
        return name;
    }

    public  void setUserName(String userName){
        this.name = userName;
        preferences.edit().putString(USER_NAME, userName).apply();
    }


    public String getAddress(){
        address = preferences.getString(ADDRESS,"");
        return  ADDRESS;
    }

    public  void setAddress(String address){
        this.address = address;
        preferences.edit().putString(USER_NAME, address).apply();
    }

    public String getEmail(){
        email = preferences.getString(EMAIL,"");
        return  email;
    }

    public  void setEmail(String email){
        this.email = email;
        preferences.edit().putString(EMAIL, email).apply();
    }


    public String getPassword(){
        password = preferences.getString(PASSWORD,"");
        return  password;
    }

    public  void setPassword(String password){
        this.password = password;
        preferences.edit().putString(PASSWORD, password).apply();
    }



    public String getId_user(){
        id = preferences.getString(ID,"");
        return  id;
    }
    public  void setId_user(String id){
        this.id = id;
        preferences.edit().putString(ID, id).apply();
    }


    public String getAreaCoverage(){
        area_coverage = preferences.getString(AREA_COVERAGE,"");
        return  AREA_COVERAGE;
    }
    public  void setArea_coverage(String area_coverage){
        this.area_coverage = area_coverage;
        preferences.edit().putString(AREA_COVERAGE, area_coverage).apply();
    }


    public String getCity(){
        city = preferences.getString(CITY,"");
        return  city;
    }
    public  void setCity(String city){
        this.city = city;
        preferences.edit().putString(CITY, city).apply();
    }


    public String getRoleId(){
        role_id = preferences.getString(ROLE_ID,"");
        return  role_id;
    }
    public  void setRoleId(String role_id){
        this.role_id = role_id;
        preferences.edit().putString(ROLE_ID, role_id).apply();
    }



    public boolean isLogin() {
        isLogin= preferences.getBoolean(IS_LOGIN, false);
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
        preferences.edit().putBoolean(IS_LOGIN, isLogin).apply();
    }


    public boolean Remember_me(){
        remember_me  = preferences.getBoolean(REMEMBER_ME,false);
        return remember_me;
    }

    public void setRememberMe(boolean remember_me){
        remember_me = remember_me;
        preferences.edit().putBoolean(REMEMBER_ME, remember_me).apply();
    }
    public HashMap<String, String>getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(USER_NAME, preferences.getString(USER_NAME, null));
        user.put(EMAIL, preferences.getString(EMAIL, null));

        return user;
    }

}
