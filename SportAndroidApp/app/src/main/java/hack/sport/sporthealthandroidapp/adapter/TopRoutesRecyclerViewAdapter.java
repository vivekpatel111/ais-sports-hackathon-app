package hack.sport.sporthealthandroidapp.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hack.sport.sporthealthandroidapp.CategoryActivity;
import hack.sport.sporthealthandroidapp.R;
import hack.sport.sporthealthandroidapp.TopRoutesActivity;

/**
 * Created by Abhishek Kumar on 11/8/2015.
 */
public class TopRoutesRecyclerViewAdapter extends RecyclerView.Adapter<TopRoutesRecyclerViewAdapter.ViewHolder> {

    private TopRoutesActivity onItemClickListener;
    private ArrayList<HashMap<String, String>> data;

    private static final ArrayList<Map<String, Object>> sample;
    private static final ArrayList<Integer> image;
    static
        {
            sample = new ArrayList<Map<String,Object>>();
            image = new ArrayList<>();
            image.add(R.drawable.bike_route_1);
            image.add(R.drawable.bike_route_2);
            image.add(R.drawable.bike_route_3);
            image.add(R.drawable.bike_route_4);

            Map<String, Object> sampleMap =
            new HashMap<String, Object>();
            sampleMap.put("Complexity Score", "6");
            sampleMap.put("Total Distance", "15 Km");
            sampleMap.put("Avg. Time", "45 Mins");
            sampleMap.put("Avg. Speed", "12 Km/Hr");
            sampleMap.put("Best time to start", "5:30 AM");
            sampleMap.put("image", R.drawable.bike_route_1);
            sample.add(sampleMap);

            sampleMap =
                    new HashMap<String, Object>();
            sampleMap.put("Complexity Score", "9");
            sampleMap.put("Total Distance", "30 Km");
            sampleMap.put("Avg. Time", "1 Hr 30 Mins");
            sampleMap.put("Avg. Speed", "15 Km/Hr");
            sampleMap.put("Best time to start", "6:00 AM");
            sampleMap.put("image", R.drawable.bike_route_2);
            sample.add(sampleMap);

            sampleMap =
                    new HashMap<String, Object>();
            sampleMap.put("Complexity Score", "3");
            sampleMap.put("Total Distance", "10 Km");
            sampleMap.put("Avg. Time", "45 Mins");
            sampleMap.put("Avg. Speed", "12 Km/Hr");
            sampleMap.put("Best time to start", "6:00 AM");
            sampleMap.put("image", R.drawable.bike_route_3);
            sample.add(sampleMap);



            sampleMap =
                    new HashMap<String, Object>();
            sampleMap.put("Complexity Score", "5");
            sampleMap.put("Total Distance", "12 Km");
            sampleMap.put("Avg. Time", "45 Mins");
            sampleMap.put("Avg. Speed", "13 Km/Hr");
            sampleMap.put("Best time to start", "7:00 AM");
            sampleMap.put("image", R.drawable.bike_route_4);
            sample.add(sampleMap);
        }

    public interface OnItemClickListener {
        public void onItemClick(View view);
    }

    public void setOnItemClickListener(TopRoutesActivity onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivTrack;
        TextView tvDistance, tvAvgTime, tvAvgSpeed, tvAvgBestTime, tvScore;
        CardView cardViewCategory;
        public ViewHolder(View v) {
            super(v);
            ivTrack = (ImageView)v.findViewById(R.id.imageView);
            tvScore = (TextView)v.findViewById(R.id.tvScore);
            tvDistance = (TextView)v.findViewById(R.id.tvDistance);
            tvAvgTime = (TextView)v.findViewById(R.id.tvAvgTime);
            tvAvgSpeed = (TextView)v.findViewById(R.id.tvAvgSpeed);
            tvAvgBestTime = (TextView)v.findViewById(R.id.tvAvgBestTime);

            cardViewCategory = (CardView)v.findViewById(R.id.card_view);
            cardViewCategory.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener != null){
                    onItemClickListener.onItemClick(v);
            }
        }
    }


    public TopRoutesRecyclerViewAdapter() {
        this.data = new ArrayList<HashMap<String, String>>();
    }

    public void setCategoryDataItems( ArrayList<HashMap<String, String>> data){
        this.data = data;
    }

    @Override
    public TopRoutesRecyclerViewAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_card_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvAvgBestTime.setText((String)TopRoutesRecyclerViewAdapter.sample.get(position).get("Best time to start"));
        holder.tvAvgSpeed.setText((String) TopRoutesRecyclerViewAdapter.sample.get(position).get("Avg. Speed"));
        holder.tvAvgTime.setText((String) TopRoutesRecyclerViewAdapter.sample.get(position).get("Avg. Time"));
        holder.tvDistance.setText((String) TopRoutesRecyclerViewAdapter.sample.get(position).get("Total Distance"));
        holder.tvScore.setText((String) TopRoutesRecyclerViewAdapter.sample.get(position).get("Complexity Score"));

        holder.ivTrack.setImageResource(TopRoutesRecyclerViewAdapter.image.get(position));
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}