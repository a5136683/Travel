package com.phone1000.admin.travel;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.phone1000.admin.travel.myview.MyScrollView;
import com.phone1000.admin.travel.myview.ScrollViewListener;

public class CutmRelease1Activity extends AppCompatActivity implements ScrollViewListener {
    private MyScrollView scrollView1 = null;
    private EditText release_ed_Xing;
    private EditText release_ed_Name;
    private EditText release_ed_PhonNumber;
    private TextView city;
    private EditText date;
    private EditText yusaun;

    private Button nextOclik;
    public static SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutm_release1);
        scrollView1 = (MyScrollView) findViewById(R.id.view1);
        scrollView1.setScrollViewListener(this);
        scrollView1.setScrollViewListener(this);
        initView();
        nextOclik.setOnClickListener(new CutmRelease1Activity.nextOclikListner());
    }
    private void initView() {
        release_ed_Xing=(EditText) findViewById(R.id.release_ed_Xing);
        release_ed_Name=(EditText) findViewById(R.id.release_ed_Name);
        release_ed_PhonNumber=(EditText) findViewById(R.id.release_ed_PhonNumber);
        city=(TextView) findViewById(R.id.city);
        date=(EditText) findViewById(R.id.date);
        yusaun=(EditText) findViewById(R.id.yusaun);

        nextOclik=(Button) findViewById(R.id.nextOclik);
        db=SQLiteDatabase.openOrCreateDatabase(CutmRelease1Activity.this.getFilesDir().toString()+"/test.dbs",null);

    }

    @Override
    public void onScrollChanged(MyScrollView myScrollView, int l, int t, int oldl, int oldt) {
        scrollView1.scrollTo(l, t);
    }

    class nextOclikListner implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String release_ed_Xing1 = release_ed_Xing.getText().toString();
            String release_ed_Name1 = release_ed_Name.getText().toString();
            String release_ed_PhonNumber1 = release_ed_PhonNumber.getText().toString();
            String city1 = city.getText().toString();
            String date1 = date.getText().toString();
            String yusaun1 = yusaun.getText().toString();

            if (release_ed_Xing1.equals("") || release_ed_Name1.equals("")||release_ed_PhonNumber1.equals("")) {
                new AlertDialog.Builder(CutmRelease1Activity.this).setTitle("小主!联系人信息不能为空哦")
                        .setMessage("请填写联系人信息")
                        .setPositiveButton("确定", null).show();
            }else if(city1.equals("")){
                new AlertDialog.Builder(CutmRelease1Activity.this).setTitle("小主!出发城市不能为空哦")
                        .setMessage("亲！请选择出发城市")
                        .setPositiveButton("确定",null).show();
            }else if(date1.equals("")){
                new AlertDialog.Builder(CutmRelease1Activity.this).setTitle("小主!出发日期不能为空哦")
                        .setMessage("请选择出发日期")
                        .setPositiveButton("确定",null).show();
            } else if(yusaun1.equals("")){
                new AlertDialog.Builder(CutmRelease1Activity.this).setTitle("小主!预算不能为空哦")
                        .setMessage("请选择填写预算金额")
                        .setPositiveButton("确定",null).show();
            }else {
                Intent intent =new Intent(CutmRelease1Activity.this,CutmReleasenext1Activity.class);
                startActivity(intent);
            }

        }

    }
}
