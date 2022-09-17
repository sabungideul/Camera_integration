package com.example.camera;

public class character {

    JSONObject jsonObject = new JSONObject(jsonData);
    String point = jsonObject.getString("point");
    String level = jsonObject.getString("level");

            data.setText("point : "+point+"\n"+"level : "+level);

    int lv = Integer.parseInt(level);
    ImageView level_glide = findViewById(R.id.level_image);
    //이미지 glide
            if (lv == 1) {
        Glide.with(this).load(R.drawable.level_1).into(level_glide);
    }
            if (lv == 2) {
        Glide.with(this).load(R.drawable.level_2).into(level_glide);
    }
            if (lv == 3) {
        Glide.with(this).load(R.drawable.level_3).into(level_glide);
    }
            if (lv == 4) {
        Glide.with(this).load(R.drawable.level_4).into(level_glide);
    }
            if (lv == 5) {
        Glide.with(this).load(R.drawable.level_5).into(level_glide);
    }
            if (lv == 6) {
        Glide.with(this).load(R.drawable.level_6).into(level_glide);
    }
            if (lv == 7) {
        Glide.with(this).load(R.drawable.level_7).into(level_glide);
    }
            if (lv == 8) {
        Glide.with(this).load(R.drawable.level_8).into(level_glide);
    }
            if (lv == 9) {
        Glide.with(this).load(R.drawable.level_9).into(level_glide);
    }
            if (lv == 10) {
        Glide.with(this).load(R.drawable.level_10).into(level_glide);
    }


} catch (IOException | JSONException e) {
        e.printStackTrace();
        }


        }
}
