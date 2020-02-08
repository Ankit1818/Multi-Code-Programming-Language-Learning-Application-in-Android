package com.example.openclass;

import android.content.Context;
import android.content.SharedPreferences;

public class Background
{
    SharedPreferences sharedPreferences;
    Context context;
    String name;

    public void removeuser()
    {
        sharedPreferences.edit().clear().commit();
    }
    public String getName() {
        name=sharedPreferences.getString("username","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        sharedPreferences.edit().putString("username",name).commit();
    }

    public Background(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences("com.example.openclass",Context.MODE_PRIVATE);
    }
}
