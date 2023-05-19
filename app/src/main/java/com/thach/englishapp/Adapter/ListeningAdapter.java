package com.thach.englishapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.thach.englishapp.Listening.ListeningActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thach.englishapp.Interface.IClickItem;
import com.thach.englishapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class ListeningAdapter extends RecyclerView.Adapter<ListeningAdapter.ListenViewHolder> {
    private ArrayList<String> strings;
    private IClickItem iClickItem;
    private Context context;
    private TextToSpeech tts;
    ListeningActivity listeningActivity = new ListeningActivity();
    public ListeningAdapter(ArrayList<String> strings, Context context, TextToSpeech tts) {
        this.strings = strings;
        this.iClickItem = iClickItem;
        this.context = context;
        this.tts = tts;
    }
    @NonNull
    @Override
    public ListenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listening_item, parent,false);
        return new ListenViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListenViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String string = strings.get(position);

        if(string==null){
            return;
        }


        holder.text.setText(string);
        holder.listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(string, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
    @Override
    public int getItemCount() {
        if(strings!=null){
            return strings.size();
        }
        return 0;
    }
    public class ListenViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout listenLayout;
        private TextView text;
        private ImageView dich;
        private ImageView listen;
        public ListenViewHolder(@NonNull View itemView) {
            super(itemView);
            listenLayout = itemView.findViewById(R.id.listen_item);
            text = itemView.findViewById(R.id.text);
            dich = itemView.findViewById(R.id.dich);
            listen = itemView.findViewById(R.id.listen);
        }
    }

}