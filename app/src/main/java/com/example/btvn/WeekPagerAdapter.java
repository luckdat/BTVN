package com.example.btvn;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WeekPagerAdapter extends RecyclerView.Adapter<WeekPagerAdapter.WeekViewHolder> {
    private List<Integer> imageList;
    private List<String> weekList;

    public WeekPagerAdapter(List<Integer> imageList, List<String> weekList) {
        this.imageList = imageList;
        this.weekList = weekList;
    }

    @NonNull
    @Override
    public WeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_week, parent, false);
        return new WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewHolder holder, int position) {
        holder.babyImage.setImageResource(imageList.get(position));
        holder.weekNumber.setText(weekList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    static class WeekViewHolder extends RecyclerView.ViewHolder {
        ImageView babyImage;
        TextView weekNumber;

        public WeekViewHolder(@NonNull View itemView) {
            super(itemView);
            babyImage = itemView.findViewById(R.id.babyImage);
            weekNumber = itemView.findViewById(R.id.weekNumber);
        }
    }
}
