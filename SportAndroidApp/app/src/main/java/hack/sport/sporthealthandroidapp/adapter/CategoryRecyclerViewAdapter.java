package hack.sport.sporthealthandroidapp.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import hack.sport.sporthealthandroidapp.CategoryActivity;
import hack.sport.sporthealthandroidapp.R;

/**
 * Created by Abhishek Kumar on 11/8/2015.
 */
public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    private CategoryActivity onItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view);
    }

    public void setOnItemClickListener(CategoryActivity onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvCategory;
        CardView cardViewCategory;
        public ViewHolder(View v) {
            super(v);
            tvCategory = (TextView)v.findViewById(R.id.tvScore);
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

    public CategoryRecyclerViewAdapter() {

    }

    /*public TopRoutesRecyclerViewAdapter() {
        this.categoryModels = new ArrayList<CategoryModel>();
    }

    public void setCategoryDataItems(ArrayList<CategoryModel> categoryModels){
        this.categoryModels = categoryModels;
    }
*/
    @Override
    public CategoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_recycler_card_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position == 0){
            holder.tvCategory.setText("Cycling");
            holder.cardViewCategory.setBackgroundColor(Color.parseColor("#ec4c4a"));
        }else if(position == 1){
            holder.tvCategory.setText("Swimming");
            holder.cardViewCategory.setBackgroundColor(Color.parseColor("#679aa7"));
        }else {
            holder.tvCategory.setText("Running");
            holder.cardViewCategory.setBackgroundColor(Color.parseColor("#9476b8"));
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}