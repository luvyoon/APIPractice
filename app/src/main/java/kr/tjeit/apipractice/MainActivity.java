package kr.tjeit.apipractice;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.tjeit.apipractice.utils.GlobalData;

public class MainActivity extends BaseActivity {


    private android.widget.TextView welcomeMsgTxt;
    private de.hdodenhof.circleimageview.CircleImageView userProfileImgView;
    private android.widget.TextView userEmailTxt;
    private android.widget.TextView userPhoneTxt;

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

    }

    @Override
    public void setValues() {

        String welcomeMessage = String.format("%s님 환영합니다 !", GlobalData.loginUser.getName());
        welcomeMsgTxt.setText(welcomeMessage);


    }

    @Override
    public void bindView() {


        this.userPhoneTxt = (TextView) findViewById(R.id.userPhoneTxt);
        this.userEmailTxt = (TextView) findViewById(R.id.userEmailTxt);
        this.userProfileImgView = (CircleImageView) findViewById(R.id.userProfileImgView);
        this.welcomeMsgTxt = (TextView) findViewById(R.id.welcomeMsgTxt);

    }
}
