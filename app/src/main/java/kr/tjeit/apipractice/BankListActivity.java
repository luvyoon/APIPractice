package kr.tjeit.apipractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.tjeit.apipractice.datas.Bank;
import kr.tjeit.apipractice.utils.ConnectSever;

public class BankListActivity extends BaseActivity {

    List<Bank> bankList = new ArrayList<Bank>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);

        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
//        코드가 setValues안에서 길어지는걸 막기 위해
//        서버에서 은행목록 받아오는 코드는 별개 메쏘드로 작성.

        getBanksFromServer();

    }
    void  getBanksFromServer(){

        ConnectSever.getRequestBanks(mContext, new ConnectSever.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

                Log.d("은행목록", json.toString());

                try {
                    int code = json.getInt("code");

                    if (code == 200) {

                    JSONObject data = json.getJSONObject("data");
                        JSONArray banks = data.getJSONArray("banks");

                        for (int i=0 ; i <banks.length(); i++){

                            JSONObject bankJson = banks.getJSONObject(i);

                            Bank bankObject = Bank.getBankFromJson(bankJson);
                            bankList.add(bankObject);


                        }


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    @Override
    public void bindView() {

    }
}
