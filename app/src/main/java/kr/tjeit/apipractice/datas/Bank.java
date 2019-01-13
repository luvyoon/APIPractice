package kr.tjeit.apipractice.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Bank implements Serializable {

    private int id;
    private String code;
    private String bankName;
    private String logoUrl;




    public static Bank getBankFromJson(JSONObject bankJson){

        Bank bank = new Bank();

        try {
            bank.setId(bankJson.getInt("id"));
            bank.setCode(bankJson.getString("code"));
            bank.setBankName(bankJson.getString("Name"));
            bank.setLogoUrl(bankJson.getString("logo"));

        } catch (JSONException e) {
            e.printStackTrace();
        }



        return bank;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
