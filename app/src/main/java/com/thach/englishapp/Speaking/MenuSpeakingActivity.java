package com.thach.englishapp.Speaking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thach.englishapp.Adapter.TopicAdapter;
import com.thach.englishapp.Arrange.MenuArrangeActivity;
import com.thach.englishapp.Interface.IClickItem;
import com.thach.englishapp.Model.Topic;
import com.thach.englishapp.R;

import java.util.ArrayList;

public class MenuSpeakingActivity extends AppCompatActivity {
    private ArrayList<Topic> topicList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity_speaking);
        topicList = getTopicList();
        topicAdapter = new TopicAdapter(topicList, new IClickItem() {
            @Override
            public void onClickItemTopic(Topic topic) {
                onCLickGoToSpeaking(topic);
            }
        });
        recyclerView = findViewById(R.id.topic_recycleview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(topicAdapter);
        ImageView btn_back = findViewById(R.id.toolbar_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuSpeakingActivity.super.onBackPressed();
            }
        });
    }

    public ArrayList<Topic> getTopicList() {
        topicList.add(new Topic("Inflationary", R.drawable.lamphat, "The demand-pull and cost-push inflation will put pressure on the country's efforts to control inflation amid surging demand and strengthening of the US dollar which yields increased import prices.\n" +
                "It will not be easy to keep inflation at 4.5% this year as targeted, economic expert Nguyen Bich Lam, former General Director of the General Statistics Office (GSO), has said.\n" +
                "\n" +
                "Inflationary pressure for Vietnam's economy in 2023 is \"huge\" and comes from many factors, he said in an interview with the Vietnam News Agency (VNA).\n" +
                "\n" +
                "The demand-pull and cost-push inflation will put pressure on the country's efforts to control inflation amid surging demand and strengthening of the US dollar which yields increased import prices.\n" +
                "\n" +
                "Demand for petrol and electricity – the two important commodities for production and consumption – will increase in 2023. The domestic electricity price has been kept unchanged for the past few years, while the price of coal and gas used in the production of electricity has increased, he said, noting that thermal and gas power account for a large proportion of the total generated electricity. Therefore, it is forecasted that the Government may raise the price of electricity this year"));
        topicList.add(new Topic("War", R.drawable.chientranh, "US President Joe Biden will meet his Ukrainian counterpart at the G7 summit in Japan, a top advisor said Saturday. President Volodymyr Zelensky will join the global leaders after taking part in the Arab League summit in Saudi Arabia."));
        topicList.add(new Topic("Food", R.drawable.luongthuc, "Canning your own tomatoes at home will bring garden-fresh flavor to all kinds of dishes year-round. Learn how to safely preserve them with our simple guide."));
        topicList.add(new Topic("Weather", R.drawable.khihau, "According to the National Centre for Hydro- Metreologogical Forecasting (NCHMF), hot weather is set to scorch northern and northern-central localities on May 18, with the highest temperature ranging from 37 to 40 degrees Celsius."));
        topicList.add(new Topic("Technology", R.drawable.congnghe, "According to the National Centre for Hydro- Metreologogical Forecasting (NCHMF), hot weather is set to scorch northern and northern-central localities on May 18, with the highest temperature ranging from 37 to 40 degrees Celsius."));
        topicList.add(new Topic("Security", R.drawable.anninh, "According to the National Centre for Hydro- Metreologogical Forecasting (NCHMF), hot weather is set to scorch northern and northern-central localities on May 18, with the highest temperature ranging from 37 to 40 degrees Celsius."));
        topicList.add(new Topic("Economy", R.drawable.kinhte, "According to the National Centre for Hydro- Metreologogical Forecasting (NCHMF), hot weather is set to scorch northern and northern-central localities on May 18, with the highest temperature ranging from 37 to 40 degrees Celsius."));
        topicList.add(new Topic("Education", R.drawable.hoctap, "According to the National Centre for Hydro- Metreologogical Forecasting (NCHMF), hot weather is set to scorch northern and northern-central localities on May 18, with the highest temperature ranging from 37 to 40 degrees Celsius."));
        return topicList;
    }

    private void onCLickGoToSpeaking(Topic topic){
        Intent intent = new Intent(this, SpeakingActivity.class);
        startActivity(intent);
    }
}