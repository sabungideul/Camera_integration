package com.example.camera;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class str extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int cnt = 16;
    int st_ready = 1;
    int stage = 1;
    int point = 0;
    int level;

    JSONObject mainobj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_str);

//        chk_st_ready(1): 모비우스 계속 보면서 st_ready가 1이라면 탈출함 그렇지 않을 시 현재 값 계속 보여줌
//        chk_st_ready(1);

//        try {
//            st_ready = mainobj.getInt("st_ready");
//            stage = mainobj.getInt("stage");
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+stage);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Dont");


        ImageView level_glide = findViewById(R.id.stretch_image);

        if (st_ready == 0) {
            System.out.println("READY=0");

//            switch (stage) {
//                case 0:
//                    System.out.println("!!!!!!!!CASE)))))0");
////                    Glide.with(str.this).load(R.drawable.st_1_0).into(level_glide);
////                    캐릭터 화면 나와야 함
////                    캐릭터 레벨에 따른 이미지가 나오도록 해야 함
////                    break;
//
//                case 1:
//                    System.out.println("!!!!!!!!CASE)))))1");
//                    Glide.with(str.this).load(R.drawable.st_1_zero).into(level_glide);
//                    // 각 R.drawable에서 st 0에 관한 사진 재설정 필요
//                    System.out.println("!!!!!!!!RRRRRRRRR)))))1");
//                    if (st_ready == 1) {
//                        System.out.println("!!!!!!!!RRRRRRRRR)))))1");
//
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.st_1_16).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.st_1_15).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.st_1_14).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.st_1_13).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.st_1_12).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.st_1_11).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.st_1_10).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.st_1_9).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.st_1_8).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.st_1_7).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.st_1_6).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.st_1_5).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.st_1_4).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.st_1_3).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.st_1_2).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.st_1_1).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.st_2_0).into(level_glide);
//                                }
//                            }
//
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                        System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    } // ready1 stage1 end
////                    break;
//
//                case 2:
//
//                    if (st_ready == 1) {
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.st_2_1).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.st_2_2).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.st_2_3).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.st_2_4).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.st_2_5).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.st_2_6).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.st_2_7).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.st_2_8).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.st_2_9).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.st_2_10).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.st_2_11).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.st_2_12).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.st_2_13).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.st_2_14).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.st_2_15).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.st_2_16).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.str_3_0).into(level_glide);
//                                }
//                            }
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                    System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    }// ready1 stage2 end
////                    break;
//
//                case 3:
//                  //  Glide.with(str.this).load(R.drawable.str_3_0).into(level_glide);
//                    if (st_ready == 1) {
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.str_3_1).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.str_3_2).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.str_3_3).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.str_3_4).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.str_3_5).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.str_3_6).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.str_3_7).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.str_3_8).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.str_3_9).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.str_3_10).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.str_3_11).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.str_3_12).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.str_3_13).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.str_3_14).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.str_3_15).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.str_3_16).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.str_4_0).into(level_glide);
//                                }
//                            }
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                    System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    }// ready1 stage3 end
////                    break;
//
//                case 4:
//                    //Glide.with(str.this).load(R.drawable.st_4_0).into(level_glide);
//                    if (st_ready == 1) {
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.str_4_1).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.str_4_2).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.str_4_3).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.str_4_4).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.str_4_5).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.str_4_6).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.str_4_7).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.str_4_8).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.str_4_9).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.str_4_10).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.str_4_11).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.str_4_12).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.str_4_13).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.str_4_14).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.str_4_15).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.str_4_16).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.str_5_0).into(level_glide);
//                                }
//                            }
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                    System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    }// ready1 stage4 end
////                    break;
//
//                case 5:
//                    //Glide.with(str.this).load(R.drawable.st_5_0).into(level_glide);
//                    if (st_ready == 1) {
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.str_5_1).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.str_5_2).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.str_5_3).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.str_5_4).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.str_5_5).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.str_5_6).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.str_5_7).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.str_5_8).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.str_5_9).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.str_5_10).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.str_5_11).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.str_5_12).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.str_5_13).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.str_5_14).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.str_5_15).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.str_5_16).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.str_6_0).into(level_glide);
//                                }
//                            }
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                    System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    }//5
////                    break;
//
//                case 6:
//                    //Glide.with(str.this).load(R.drawable.st_6_0).into(level_glide);
//                    if (st_ready == 1) {
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.str_6_1).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.str_6_2).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.str_6_3).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.str_6_4).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.str_6_5).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.str_6_6).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.str_6_7).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.str_6_8).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.str_6_9).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.str_6_10).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.str_6_11).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.str_6_12).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.str_6_13).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.str_6_14).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.str_6_15).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.str_6_16).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.str_7_0).into(level_glide);
//                                }
//
//                            }
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                    System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    }//6
////                    break;
//
//                case 7:
//                    //Glide.with(str.this).load(R.drawable.st_7_0).into(level_glide);
//                    if (st_ready == 1) {
//                        countDownTimer = new CountDownTimer(18000, 1000) { // 15초 동안 1초의 간격으로 메소드를 호출
//                            @Override
//                            public void onTick(long millisUntilFinished) {
//                                Log.d("stretch test ==>", String.valueOf(+millisUntilFinished / 1000));
//                                int num = (int) (millisUntilFinished / 1000);
//                                Log.d("num", String.valueOf(num));
//                                //1초마다 호출되면서 남은 시간을 초 단위로 보여줌
//
//                                if (num == 17) {
//                                    Glide.with(str.this).load(R.drawable.str_7_1).into(level_glide);
//                                }
//                                if (num == 16) {
//                                    Glide.with(str.this).load(R.drawable.str_7_2).into(level_glide);
//                                }
//                                if (num == 15) {
//                                    Glide.with(str.this).load(R.drawable.str_7_3).into(level_glide);
//                                }
//                                if (num == 14) {
//                                    Glide.with(str.this).load(R.drawable.str_7_4).into(level_glide);
//                                }
//                                if (num == 13) {
//                                    Glide.with(str.this).load(R.drawable.str_7_5).into(level_glide);
//                                }
//                                if (num == 12) {
//                                    Glide.with(str.this).load(R.drawable.str_7_6).into(level_glide);
//                                }
//                                if (num == 11) {
//                                    Glide.with(str.this).load(R.drawable.str_7_7).into(level_glide);
//                                }
//                                if (num == 10) {
//                                    Glide.with(str.this).load(R.drawable.str_7_8).into(level_glide);
//                                }
//                                if (num == 9) {
//                                    Glide.with(str.this).load(R.drawable.str_7_9).into(level_glide);
//                                }
//                                if (num == 8) {
//                                    Glide.with(str.this).load(R.drawable.str_7_10).into(level_glide);
//                                }
//                                if (num == 7) {
//                                    Glide.with(str.this).load(R.drawable.str_7_11).into(level_glide);
//                                }
//                                if (num == 6) {
//                                    Glide.with(str.this).load(R.drawable.str_7_12).into(level_glide);
//                                }
//                                if (num == 5) {
//                                    Glide.with(str.this).load(R.drawable.str_7_13).into(level_glide);
//                                }
//                                if (num == 4) {
//                                    Glide.with(str.this).load(R.drawable.str_7_14).into(level_glide);
//                                }
//                                if (num == 3) {
//                                    Glide.with(str.this).load(R.drawable.str_7_15).into(level_glide);
//                                }
//                                if (num == 2) {
//                                    Glide.with(str.this).load(R.drawable.str_7_16).into(level_glide);
//                                }
//                                if (num == 1) {
//                                    Glide.with(str.this).load(R.drawable.str_5_0).into(level_glide);
//                                    //캐릭터화면으로 화면전환
////                                    Intent intent = new Intent(getApplicationContext(),character.class);
////                                    startActivity(intent);//액티비티 띄우기
//                                }
//                            }
//                            @Override
//                            public void onFinish() {
//                                Log.d("exit", "finish");
//                                Intent intent = new Intent(str.this, MainActivity.class);
//                                startActivity(intent);
//
//                                try {
//                                    System.out.println("Ready:\t"+st_ready);
//                                    stage += 1;
//                                    System.out.println("Next Stage:\t"+stage);
//
//                                    new Thread(
//                                            () -> POST_JSON(stage,point,level,st_ready)
//                                    ).start();
//
//                                } catch (Exception e) {
//                                    System.out.println(e);
//                                }
//
//                            } //종료 되었을 때 문자열을 보여줍니다
//                        }.start(); //카운트 시작
//                    }//7
////                    break;
//
//            }
        }


    }
            public void chk_st_ready(int target) {
                int st_ready = 2;
                while (st_ready != target) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        new Thread(
                                () -> get_url_test()
                        ).start();
                        if (mainobj == null) {
                            System.out.println("Transmission...");
                            continue;
                        }
                        st_ready = mainobj.getInt("st_ready");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    System.out.println("St_ready state not match current state: " + st_ready);
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
                    JSONObject object = new JSONObject(response.body().string());
                    JSONObject Jarray = object.getJSONObject("m2m:cin");
                    JSONObject Target_json = Jarray.getJSONObject("con");
//            System.out.println(Target_json);
                    mainobj = Target_json;

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
//        return null;
            }

            private void POST_JSON(int stage, int point, int level, int st_ready) {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json;ty=4");
                RequestBody body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": {\"point\": "+point+", \"level\": "+level+", \"st_ready\": "+st_ready+", \"st_start\": 0, \"stage\":"+stage+"}\n    }\n}", mediaType);
                Request request = new Request.Builder()
                        .url("http://203.253.128.177:7579/Mobius/SW_Hackaton/url_test")
                        .method("POST", body)
                        .addHeader("Accept", "application/json")
                        .addHeader("X-M2M-RI", "12345")
                        .addHeader("X-M2M-Origin", "SOrigin")
                        .addHeader("Content-Type", "application/json;ty=4")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    JSONObject object = new JSONObject(response.body().string());
//            System.out.println(object);

                    JSONObject Jarray = object.getJSONObject("m2m:cin");
                    String temp = Jarray.getString("con");

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

        }
