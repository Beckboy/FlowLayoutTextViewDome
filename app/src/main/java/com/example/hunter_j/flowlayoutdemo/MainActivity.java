package com.example.hunter_j.flowlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.hunter_j.flowlayoutdemo.view.FlowLayout;

public class MainActivity extends AppCompatActivity {

    private FlowLayout mFlow;

    //宽高
    private int width = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int height = ViewGroup.LayoutParams.WRAP_CONTENT;

    // 数据源
    private String[] collegData = new String[]{"清华大学","北京大学","复旦大学","浙江大学","南开大学","同济大学"
                        ,"苏州大学","吉林大学","哈佛大学","斯坦福大学","麻省理工大学","斯坦福大学","加州理工学院"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

    }

    private void initView() {
        mFlow = (FlowLayout) findViewById(R.id.flowlayouot);
    }

    /**
     * 初始化瀑布流列表
     */
    private void initData() {
        for (String colleg : collegData){
            loadFlowCircleList(colleg);
        }
    }


    /**
     * 加载流标签
     */
    private void loadFlowCircleList(String colleg) {
        CheckBox cbTag = (CheckBox) getLayoutInflater().inflate(R.layout.item_topic_tag, mFlow, false);
        cbTag.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_bg_check_circle));
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(width,height);
        lp.leftMargin = 20; //左间距
        lp.rightMargin = 20; //右间距
        lp.topMargin = 40; //上间距
        cbTag.setLayoutParams(lp);
        cbTag.setText(colleg);
        mFlow.addView(cbTag);
    }

    public void onclick(View view) {
        mFlow.removeAllViews();
        switch (view.getId()){
            case R.id.btn_left: //加载自适应流布局
                width = ViewGroup.LayoutParams.WRAP_CONTENT;
                break;
            case R.id.btn_right: //加载等宽流布局
                int column = 3; //列数
                int max_width = getWindowManager().getDefaultDisplay().getWidth(); //获取屏幕宽度
                width = (max_width - 40 * column)/column;
                break;
        }
        initData();
    }
}
