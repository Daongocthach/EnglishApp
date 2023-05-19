package com.thach.englishapp.Listening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.thach.englishapp.Adapter.TopicAdapter;
import com.thach.englishapp.Interface.IClickItem;
import com.thach.englishapp.Model.Topic;
import com.thach.englishapp.R;

import java.util.ArrayList;

public class MenuListeningActivity extends AppCompatActivity {
    private ArrayList<Topic> topicList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity_listening);
        topicList = getTopicList();
        topicAdapter = new TopicAdapter(topicList, new IClickItem() {
            @Override
            public void onClickItemTopic(Topic topic) {
                onCLickGoToListening(topic);
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
                MenuListeningActivity.super.onBackPressed();
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
        topicList.add(new Topic("War", R.drawable.chientranh, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Food", R.drawable.luongthuc, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Weather", R.drawable.khihau, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Technology", R.drawable.congnghe, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Security", R.drawable.anninh, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Economy", R.drawable.kinhte, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Education", R.drawable.hoctap, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        return topicList;
    }
    private void onCLickGoToListening(Topic topic){
        Intent intent = new Intent(this, ListeningActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("topic", topic);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}