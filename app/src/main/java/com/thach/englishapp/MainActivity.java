package com.thach.englishapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.thach.englishapp.Arrange.MenuArrangeActivity;
import com.thach.englishapp.EditProfile.EditProfileActivity;
import com.thach.englishapp.FillInBlank.MenuFillInBlankActivity;
import com.thach.englishapp.Listening.MenuListeningActivity;
import com.thach.englishapp.Quiz.MenuQuizActivity;
import com.thach.englishapp.Speaking.MenuSpeakingActivity;
import com.thach.englishapp.Vocabulary.MenuVocabularyActivity;

public class MainActivity extends AppCompatActivity {
    CardView cardViewHocTuVung, cardViewTracNghiem, cardViewSapXepCau, cardViewLuyenNghe,cardViewDienKhuyet,cardViewXepHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView btnListening = (CardView) findViewById(R.id.btn_listening);
        CardView btnSpeaking = (CardView) findViewById(R.id.btn_speaking);
        CardView btnArrange = (CardView) findViewById(R.id.btn_arrange);
        CardView btnFillInBlank = (CardView) findViewById(R.id.btn_fillinblank);
        CardView btnVocabulary = (CardView) findViewById(R.id.btn_vocabulary);
        CardView btnQuiz = (CardView) findViewById(R.id.btn_quiz);
        CardView btnVideo = (CardView) findViewById(R.id.btn_video);
        CardView btnAddNew = (CardView) findViewById(R.id.btn_addnew);
        ImageView imageAccount = findViewById(R.id.image_account);
        btnListening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuListeningActivity.class);
                startActivity(intent);
            }
        });
        btnSpeaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuSpeakingActivity.class);
                startActivity(intent);
            }
        });
        btnArrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuArrangeActivity.class);
                startActivity(intent);
            }
        });
        btnArrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuArrangeActivity.class);
                startActivity(intent);
            }
        });
        btnFillInBlank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuFillInBlankActivity.class);
                startActivity(intent);
            }
        });
        btnVocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuVocabularyActivity.class);
                startActivity(intent);
            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuQuizActivity.class);
                startActivity(intent);
            }
        });
        imageAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}