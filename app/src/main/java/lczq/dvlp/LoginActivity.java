package lczq.dvlp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by liubaba on 2017/3/7.
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    private TextView mExit,mSendCode;
    private EditText mName,mCode;

    private Button mGoMain;
    private LinearLayout dialogId;

    private ImageView mImg_name,mImg_code,mClose;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mExit= (TextView) findViewById(R.id.btnCallBack);
        mSendCode= (TextView) findViewById(R.id.tv_send_code);
        mSendCode.setOnClickListener(this);
        mGoMain= (Button) findViewById(R.id.tv_exec_register);
        mGoMain.setOnClickListener(this);
        dialogId= (LinearLayout) findViewById(R.id.dialogId);
        mImg_name= (ImageView) findViewById(R.id.iv_phone_num);
        mImg_code= (ImageView) findViewById(R.id.iv_verify);
        mClose= (ImageView) findViewById(R.id.close_btn);
        mClose.setOnClickListener(this);
        mName= (EditText) findViewById(R.id.ed_phone_num);
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>=4){
                    setSendBG(true);
                    mSendCode.setEnabled(true);
                    mSendCode.setClickable(true);
                    mImg_name.setImageResource(R.mipmap.dvlp_code_valid);
                }else {
                    setSendBG(false);
                    mSendCode.setEnabled(false);
                    mImg_name.setImageResource(R.mipmap.dvlp_code_invalid);
                }
            }
        });
        mCode= (EditText) findViewById(R.id.et_verify_code);
        mCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>=4){
                    setGoBG(true);
                    mGoMain.setEnabled(true);
                    mImg_code.setImageResource(R.mipmap.dvlp_register_pwd_valid);
                }else {
                    setGoBG(false);
                    mGoMain.setEnabled(true);
                    mImg_code.setImageResource(R.mipmap.dvlp_register_pwd_invalid);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCallBack:
                finish();
                break;
            case R.id.tv_send_code:
                dialogId.setVisibility(View.VISIBLE);
                break;
            case R.id.ed_phone_num:

                break;
            case R.id.et_verify_code:

                break;
            case R.id.tv_exec_register:
                if(mName.getText().toString().length()<4){
                    Toast.makeText(LoginActivity.this,"昵称格式不对"+mName.getText(),Toast.LENGTH_LONG).show();
                }else if(mCode.getText().toString().equals("0912")) {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
//                    ApiFactory.getApi().init(this,"666","股神","恒泰","#ff481b","#ffffff","http://img2.imgtn.bdimg.com/it/u=3473436880,1615664498&fm=26&gp=0.jpg","http://img4.imgtn.bdimg.com/it/u=4040485343,984913815&fm=26&gp=0.jpg");
                }else  {
                    Toast.makeText(LoginActivity.this,"验证码错误",Toast.LENGTH_LONG).show();
                    dialogId.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.close_btn:
                dialogId.setVisibility(View.GONE);
                break;

        }
    }

    private void setSendBG(boolean enable){
        if (enable) {
            mSendCode.setBackgroundResource(R.drawable.shape_activity_activate_get_background_true);
        } else {
            mSendCode.setBackgroundResource(R.drawable.shape_activity_activate_get_background_false);
        }
    }

    private void setGoBG(boolean enable){
        if (enable) {
            mGoMain.setBackgroundResource(R.drawable.shape_activity_activate_get_background_true);
        } else {
            mGoMain.setBackgroundResource(R.drawable.shape_activity_activate_get_background_false);
        }
    }
}
