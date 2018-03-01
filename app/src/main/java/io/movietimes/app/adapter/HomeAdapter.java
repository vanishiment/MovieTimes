package io.movietimes.app.adapter;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.movietimes.app.model.Card;
import io.movietimes.app.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VH> {

    private Context mContext;
    private List<Card> mCardList = new ArrayList<>();

    public HomeAdapter(Context context) {
        mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_card, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final Card card = mCardList.get(position);
        if (card == null) return;
        String title = card.getTitle();
        if (!TextUtils.isEmpty(title)) {
            holder.title.setText(title);
        }
        String coverImg = card.getImg();
        if (!TextUtils.isEmpty(coverImg)) {
            Glide.with(holder.cover).load(coverImg).into(holder.cover);
        }
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, DetailAct.class);
//                Bundle bundle = new Bundle();
//                bundle.putParcelable(DetailAct.CARD,card);
//                intent.putExtras(bundle);
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }

    public void replaceData(final List<Card> data) {
        if (data != null && data.size() != 0) {
            if (mCardList.size() == 0) {
                mCardList.addAll(data);
                notifyItemRangeChanged(0, mCardList.size());
            } else {
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                    @Override
                    public int getOldListSize() {
                        return mCardList.size();
                    }

                    @Override
                    public int getNewListSize() {
                        return data.size();
                    }

                    @Override
                    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                        Card oldCard = mCardList.get(oldItemPosition);
                        Card newCard = data.get(newItemPosition);
                        return oldCard.getTitle().equals(newCard.getTitle());
                    }

                    @Override
                    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                        Card oldCard = mCardList.get(oldItemPosition);
                        Card newCard = data.get(newItemPosition);
                        return oldCard.getImg().equals(newCard.getImg());
                    }
                }, true);
                mCardList = data;
                diffResult.dispatchUpdatesTo(HomeAdapter.this);
            }
        }
    }

    static class VH extends RecyclerView.ViewHolder {

        FrameLayout card;
        ImageView cover;
        TextView title;

        VH(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.item_card);
            cover = itemView.findViewById(R.id.item_movie_cover);
            title = itemView.findViewById(R.id.item_movie_title);
        }
    }
}
