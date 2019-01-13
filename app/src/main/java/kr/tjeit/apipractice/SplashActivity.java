package kr.tjeit.apipractice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import kr.tjeit.apipractice.datas.User;
import kr.tjeit.apipractice.utils.ConnectSever;
import kr.tjeit.apipractice.utils.ContextUtil;
import kr.tjeit.apipractice.utils.GlobalData;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        토큰이 SharedPreference에 저장되어 있는지? 검사
//        저장되어 있다 ? => 자동로그인으로 간주하고 처리
//        저장이 안되어 있다 => 로그인을 하도록 유도.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (ContextUtil.getToken(mContext).equals(" ")){
//            토근 저장안됨 -> 로그인 필요

                    Intent intent = new Intent(mContext, LoginActivity.class);
                    startActivity(intent);
                    finish();

                }else {
//            자동로그인 처리 하면됨 (토큰 저장)
//                    받은 사용자 정보를 GlobalData.loginUser 에 대입
//                     GlobalData.token에 SharedPreference에 저장된 토큰값을 먼제 대입.

                    GlobalData.token = ContextUtil.getToken(mContext);



                    ConnectSever.getRequestMyInfo(mContext, new ConnectSever.JsonResponseHandler() {
                        @Override
                        public void onResponse(JSONObject json) {

                            Log.d("내정보응답",json.toString());
                            try {
                                JSONObject data = json.getJSONObject("data");
                                JSONObject user = data.getJSONObject("user");
//                                JSONOBJEct => user클래스로 파싱.


                                User userObject = User.getUserFromJson(user);
                                GlobalData.loginUser = userObject;

                                Intent intent = new Intent(mContext, MainActivity.class);
                                startActivity(intent);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });





                }


            }
        },1500);





    }

    @Override
    public void bindView() {

    }
}
