package com.example.example_listcountry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.example_listcountry.DetailsActivity;
import com.example.example_listcountry.MainActivity;
import com.example.example_listcountry.Model.ListCountryModel;
import com.example.example_listcountry.R;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ListCountryAdapter extends RecyclerView.Adapter<ListCountryAdapter.ViewHolder> {
    private List<ListCountryModel> listCountryposts;

    public ListCountryAdapter(List<ListCountryModel> listCountryposts) {
        this.listCountryposts = listCountryposts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_country_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListCountryModel post = listCountryposts.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.post.setText(post.getCountryName()) ;
            //holder.post.setText(post.getCountryName()+ "    code:" + post.getDetailsCountryModels().get(0).getCode()) ;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(TAG, "Country Name:    " + post.getCountryName() );
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra( "name", post.getCountryName());
                    context.startActivity(intent);
                }
            });
        } else {
            holder.post.setText(post.getCountryName());
        }
    }

    @Override
    public int getItemCount() {
        if (listCountryposts == null)
            return 0;
        return listCountryposts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView post;

        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.country_item);
        }
    }
}
