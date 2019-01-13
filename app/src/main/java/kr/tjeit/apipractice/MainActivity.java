package kr.tjeit.apipractice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.tjeit.apipractice.datas.Bank;
import kr.tjeit.apipractice.utils.ContextUtil;
import kr.tjeit.apipractice.utils.GlobalData;

public class MainActivity extends BaseActivity {


    private android.widget.TextView welcomeMsgTxt;
    private de.hdodenhof.circleimageview.CircleImageView userProfileImgView;
    private android.widget.TextView userEmailTxt;
    private android.widget.TextView userPhoneTxt;
    private android.widget.Button logoutBtn;
    private Button showBankListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        showBankListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(mContext, BankListActivity.class);
                startActivity(intent);

            }
        });



        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                android.support.v7.app.AlertDialog.Builder logoutAlert = new android.support.v7.app.AlertDialog.Builder(mContext);
                logoutAlert.setTitle("로그아웃");
                logoutAlert.setMessage("정말 로그아웃 하시겠습니까?");
                logoutAlert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


//                        저장된 토큰을 빈칸으로 바꿔서 로그아웃 되었음을 처리.
                        ContextUtil.setToken(mContext, "");

                        Intent intent = new Intent(mContext, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                logoutAlert.setNegativeButton("취소", null);
                logoutAlert.show();

            }
        });


    }

    @Override
    public void setValues() {

        String welcomeMessage = String.format("%s님 환영합니다 !", GlobalData.loginUser.getName());
        welcomeMsgTxt.setText(welcomeMessage);

        userEmailTxt.setText(GlobalData.loginUser.getEmail());

        Log.d("프로필이미지",GlobalData.loginUser.getProfile_image());

        Glide.with(mContext).load(GlobalData.loginUser.getProfile_image()).into(userProfileImgView);



    }

    @Override
    public void bindView() {


        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);
        this.showBankListBtn = (Button) findViewById(R.id.showBankListBtn);
        this.userPhoneTxt = (TextView) findViewById(R.id.userPhoneTxt);
        this.userEmailTxt = (TextView) findViewById(R.id.userEmailTxt);
        this.userProfileImgView = (CircleImageView) findViewById(R.id.userProfileImgView);
        this.welcomeMsgTxt = (TextView) findViewById(R.id.welcomeMsgTxt);
    }
}
