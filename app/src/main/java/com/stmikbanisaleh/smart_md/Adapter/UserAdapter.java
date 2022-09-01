package com.stmikbanisaleh.smart_md.Adapter;

import android.content.Context;

import com.stmikbanisaleh.smart_md.Model_Ok.User.UserList;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    private Context context;
    List<UserList> list = new ArrayList<>();

    public  UserAdapter(List<UserList> list){
        this.list = list;
    }

    public static class userAdapterViewHolder{

    }

}
