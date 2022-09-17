package com.example.camera;

import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class str extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int cnt = 16;

    JSONObject mainobj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_str);


        new Thread(
                () -> get_url_test()
        ).start();

        while(mainobj == null) {
            System.out.println("Transmission...");
        }
        System.out.println("main obj: " + mainobj);

        //chk_st_ready(1): 모비우스 계속 보면서 st_ready가 1이라면 탈출함 그렇지 않을 시 현재 값 계속 보여줌
        chk_st_ready(1);
        
        //json 어떻게 받아오냐..모비우스 어렵눙..

//        int sta = Integer.parseInt(stage);

//        ImageView level_glide = findViewById(R.id.stretch_image);
//        countDownTimer = new CountDownTimer(17000, 1000) { //30초 동안 1초의 간격으로 메소드를 호출
////            @Override
////            public void onTick(long millisUntilFinished) {
////                // Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
////                int num = (int) (millisUntilFinished / 1000);
////                // Log.d("num", String.valueOf(num));
////                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
////
////                if (ready == 1) {
////                    cnt--;
////                    switch (sta) {
////                        case 1: case 2: case 3: case 4: case 5: case 6:
////                            Glide.with(str.this).load("res/drawable/" + "st_" + sta + "_" + cnt + ".png").into(level_glide);
////                            break;
////                        case 7:
////                            Glide.with(str.this).load("res/drawable/" + "st_" + sta + "_" + cnt + ".png").into(level_glide);
////                            if(cnt == 0) {
////
////                                //stage 7++될시 -> stage: {7 -> 1}, st_start:{1 -> 0}
////
////                            }
////                            break;
////                    }
////                }
////            }

//            @Override
//            public void onFinish() {
//                putdata();
//            }
//        };
    }

    public void chk_st_ready(int target) {
        while (mainobj == null) {
            System.out.println("Transmission...");
        }
        int st_ready = 0;
        try {
            st_ready = mainobj.getInt("st_ready");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        while (st_ready != target) {
            System.out.println("St_ready state not match current state: " +st_ready);
        }

    }







    public void get_url_test() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://203.253.128.177:7579/Mobius/SW_Hackaton/url_test/la")
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .addHeader("X-M2M-RI", "12345")
                .addHeader("X-M2M-Origin", "S")
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
//            JSONArray jsonArray = new JSONArray(response.body().string());


            JSONObject object = new JSONObject(response.body().string());
            System.out.println(object);

            JSONObject Jarray = object.getJSONObject("m2m:cin");
            JSONObject Target_json = Jarray.getJSONObject("con");
            System.out.println(Target_json);
            mainobj = Target_json;
            
//            return 0;

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
//        return null;
    }

    private void putdata() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json;ty=4");
        RequestBody body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": [{\"st_ready\":\"0\"}]\n    }\n}", mediaType);
        Request request = new Request.Builder()
                .url("http://203.253.128.177:7579/Mobius/SW_Hackaton/test")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("X-M2M-RI", "12345")
                .addHeader("X-M2M-Origin", "SOrigin")
                .addHeader("Content-Type", "application/json;ty=4")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject object = new JSONObject(response.body().string());
            System.out.println(object);

            JSONObject Jarray  = object.getJSONObject("m2m:cin");
            String temp  = Jarray.getString("con");


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}