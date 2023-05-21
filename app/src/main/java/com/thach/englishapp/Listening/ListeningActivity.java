package com.thach.englishapp.Listening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.thach.englishapp.Adapter.ListeningAdapter;
import com.thach.englishapp.Model.Topic;
import com.thach.englishapp.R;
import java.util.ArrayList;
import java.util.Locale;

public class ListeningActivity extends AppCompatActivity {
    private Topic topic;
    private String string;
    private ListeningAdapter listeningAdapter;
    private RecyclerView recyclerView;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView btn_back = findViewById(R.id.toolbar_back);
        ImageView imageView = findViewById(R.id.image);
        ImageView imageViewplay = findViewById(R.id.imageView_play);
        TextView name = findViewById(R.id.title);
        //TextView showtext = findViewById(R.id.showtext);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.US);
                }
            }
        });
        Intent intent = getIntent();
        if (getIntent().getExtras() != null) {
            topic = (Topic) intent.getExtras().get("topic");
            if (topic != null) {
                imageView.setImageResource(topic.getImage());
                name.setText(topic.getName());
            } else return;
        }
        string = topic.getText();

        ArrayList<String> arrayList = splitIntoParagraphs(string, 30);
        //showtext.setText();
        listeningAdapter = new ListeningAdapter(arrayList, ListeningActivity.this, tts);
        recyclerView = findViewById(R.id.listen_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(listeningAdapter);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListeningActivity.super.onBackPressed();
            }
        });
        imageViewplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(topic.getText(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    private ArrayList<String> splitIntoParagraphs(String text, int wordsPerParagraph) {
        ArrayList<String> paragraphs = new ArrayList<>();
        String[] words = text.split("\\s");
        int totalWords = words.length;
        int totalParagraphs = (int) Math.ceil((double) totalWords / wordsPerParagraph);
        for (int i = 0; i < totalParagraphs; i++) {
            StringBuilder paragraph = new StringBuilder();

            int startIndex = i * wordsPerParagraph;
            int endIndex = Math.min(startIndex + wordsPerParagraph, totalWords);

            for (int j = startIndex; j < endIndex; j++) {
                paragraph.append(words[j]).append(" ");
            }

            paragraphs.add(paragraph.toString().trim());
        }

        return paragraphs;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}

