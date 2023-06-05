package com.example.atm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.atm.arxan.Invocation;
import com.example.atm.arxan.TamperAction;

import java.util.ArrayList;

public class GuardActivity extends AppCompatActivity {
    TextView showCheckResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guard);

//        atm.getInstance().setCurrentActivity(this);//???
//        Context context=atm.getInstance().getCurrentActivity();
        showCheckResult=findViewById(R.id.showCheckResult);

        Button check=findViewById(R.id.checkcheck);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //建立一個陣列存放所有checkbox 的id
                int[] checkList={R.id.rdg,R.id.fdg,R.id.vdg,R.id.vcdg,R.id.hdg,R.id.csg,R.id.edg,R.id.scg,R.id.ddg};
                //建立一個存放勾選結果的陣列
                ArrayList<Integer> checkResult = new ArrayList<Integer>() {{
                }};
                //for迴圈 去跑這個陣列，確認這些checkbox有沒有被勾選
                //如果有被勾選，將被勾選的chekcbox id存進大小為9的陣列
                for(int i=0;i<checkList.length;i++){
                    CheckBox checkbox=findViewById(checkList[i]);
                    if(checkbox.isChecked())
                        checkResult.add(checkList[i]);
                }

                ScrollView scrollView=findViewById(R.id.scrollView2);//不能放在onCreate外面
                //去執行Invocation中的對應fuctnion
                for(int i=0;i<checkResult.size();i++){
                    int id= checkResult.get(i);
                    switch (id){
                        case R.id.rdg:
                            Invocation.invoRdg();
                            TamperAction.rdgTamper();
                            break;
                        case R.id.fdg:
                            Invocation.invoFdg();
                            break;
                        case R.id.vdg:
                            Invocation.invoVdg();
                            break;
                        case R.id.vcdg:
                            Invocation.invoVcdg();
                            break;
                        case R.id.hdg:
                            Invocation.invoHdg();
                            break;
                        case R.id.csg:
                            Invocation.invoCsg();
                            break;
                        case R.id.edg:
                            Invocation.invoEdg();
                            break;
                        case R.id.scg:
                            Invocation.invoScg();
                            break;
                        default: //R.id.ddg:
                            Invocation.invoDdg();
                            break;
                    }
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }


            }
        });

    }



//    guard頁中的偵測結果文字
    //此activity中的反應動作
    //由arxan來呼叫
    public void hdgNonTamper(){
        showCheckResult.append("Hdg Non Tamper Lah");
    }

    public void fdgNonTamper(){
        showCheckResult.append("fdg Non Tamper Lah");
    }
    public void scgNonTamper(){
        showCheckResult.append("scg Non Tamper Lah");
    }
    public void vdgNonTamper(){
        showCheckResult.append("vdg Non Tamper Lah");
    }
    public void vcdgNonTamper(){
        showCheckResult.setText("vcdg Non Tamper Lah");
    }
    public void ddgNonTamper(){
        showCheckResult.setText("ddg Non Tamper Lah");
    }
    public void edgNonTamper(){
        showCheckResult.setText("edg Non Tamper Lah");
    }

    public void hdgTamper(){
        showCheckResult.append("Hdg Tamper Lah");
    }

    public void fdgTamper(){
        showCheckResult.append("fdg Tamper Lah");
    }
    public void scgTamper(){
        showCheckResult.append("scg Tamper Lah");
    }
    public void vdgTamper(){
        showCheckResult.append("vdg Tamper Lah");
    }
    public void vcdgTamper(){
        showCheckResult.setText("vcdg Tamper Lah");
    }
    public void ddgTamper(){
        showCheckResult.setText("ddg Tamper Lah");
    }
    public void edgTamper(){
        showCheckResult.setText("edg Tamper Lah");
    }

}