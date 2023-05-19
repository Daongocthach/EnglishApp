package com.thach.englishapp.Vocabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.thach.englishapp.Adapter.TopicAdapter;
import com.thach.englishapp.Arrange.MenuArrangeActivity;
import com.thach.englishapp.Interface.IClickItem;
import com.thach.englishapp.Model.Topic;
import com.thach.englishapp.R;
import java.util.ArrayList;

public class MenuVocabularyActivity extends AppCompatActivity {
    private ArrayList<Topic> topicList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TopicAdapter topicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity_vocabulary);
        topicList = getTopicList();
        topicAdapter = new TopicAdapter(topicList, new IClickItem() {
            @Override
            public void onClickItemTopic(Topic topic) {
                onCLickGoToVocabulary(topic);
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
                MenuVocabularyActivity.super.onBackPressed();
            }
        });
    }

    public ArrayList<Topic> getTopicList() {
        topicList.add(new Topic("Lạm phát", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Chiến tranh", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Lạm phát", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Chiến tranh", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Lạm phát", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Chiến tranh", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Lạm phát", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        topicList.add(new Topic("Chiến tranh", R.drawable.picture, "Việc bảo đảm nguồn cung các mặt hàng lương thực, thực phẩm, kiểm soát đà tăng giá xăng dầu, chưa tăng giá điện, giá dịch vụ y tế, học phí… đã giúp Chính phủ kiểm soát thành công lạm phát năm 2022 dưới 4% như mục tiêu Quốc hội đề ra."));
        return topicList;
    }

    private void onCLickGoToVocabulary(Topic topic){
        Intent intent = new Intent(this, VocabularyActivity.class);
        startActivity(intent);
    }
}