package com.team5.adapter;import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team5.model.Feedback;
import com.team5.myapplication.R;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder> {
    private Context context;
    private List<Feedback> feedbackList;


    public FeedbackAdapter(Context context, List<Feedback> feedbackList) {
        this.context = context;
        this.feedbackList = feedbackList;
    }

    @NonNull
    @Override
    public FeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feedback, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackViewHolder holder, int position) {
        Feedback feedback = feedbackList.get(position);
        if (feedbackList != null) {
            Log.d("FeedbackAdapter", "Feedback list size: " + feedbackList.size());
        } else {
            Log.e("FeedbackAdapter", "Feedback list is null");
        }
        if (feedback != null) {
            holder.txtFeedback.setText(feedback.getDescription());  // Gán dữ liệu vào TextView

        } else {
            holder.txtFeedback.setText("No feedback available"); // Gán giá trị mặc định nếu dữ liệu null
        }
        byte[] photo = feedback.getPhoto();  // Lấy photo dưới dạng byte[]
        if (photo != null) {
            // Chuyển byte[] thành Bitmap và set vào ImageView
            Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
            holder.imgFeedback1.setImageBitmap(bitmap);
        } else {
            holder.imgFeedback1.setImageResource(R.drawable.hinhfeedback1); // Set ảnh mặc định nếu không có ảnh
        }
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    public static class FeedbackViewHolder extends RecyclerView.ViewHolder {
        TextView txtFeedback;
        LinearLayout starsLayout;
        LinearLayout imagesLayout;
        ImageView imgFeedback1;
        public FeedbackViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFeedback = itemView.findViewById(R.id.txtFeedback);
            imagesLayout = itemView.findViewById(R.id.lsImage);
            imgFeedback1 = itemView.findViewById(R.id.imgFeedback1);
        }
    }
}
