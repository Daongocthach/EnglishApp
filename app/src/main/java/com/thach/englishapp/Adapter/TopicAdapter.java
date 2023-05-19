package com.thach.englishapp.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.thach.englishapp.Interface.IClickItem;
import com.thach.englishapp.Model.Topic;
import com.thach.englishapp.R;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private ArrayList<Topic> topicList;
    private IClickItem iClickItem;

    public TopicAdapter(ArrayList<Topic> topicList, IClickItem iClickItem) {
        this.topicList = topicList;
        this.iClickItem = iClickItem;
    }
    public void setData(ArrayList<Topic> topicList){
        this.topicList = topicList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_item, parent,false);
        return new TopicViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Topic topic = topicList.get(position);
        if(topic==null){
            return;
        }
        holder.name.setText(topic.getName());
        holder.image.setImageResource(topic.getImage());

        holder.topicLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItem.onClickItemTopic(topic);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(topicList!=null){
            return topicList.size();
        }
        return 0;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder{
        private CardView topicLayout;
        private TextView name;
        private ImageView image;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicLayout = itemView.findViewById(R.id.topic_item);
            name = itemView.findViewById(R.id.name_topic);
            image = itemView.findViewById(R.id.image_topic);
        }
    }
}