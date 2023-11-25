package poly.DuAn1.nhom2.MD18309.PRO1121.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass.OptionItem;
import poly.DuAn1.nhom2.MD18309.PRO1121.R;

public class OptionItemAdapter extends RecyclerView.Adapter<OptionItemAdapter.ViewFucker> {

    private final Context context;
    private ArrayList<OptionItem> optionItemArrayList;
    OptionCallBack optionCallBack;

    public interface OptionCallBack{
        void onOptionItemClickListener(int position);
    }

    public OptionItemAdapter(Context context, ArrayList<OptionItem> optionItemArrayList, OptionItemAdapter.OptionCallBack optionCallBack) {
        this.context = context;
        this.optionItemArrayList = optionItemArrayList;
        this.optionCallBack = optionCallBack;
    }

    @NonNull
    @Override
    public ViewFucker onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.option_menu_item, parent, false);
        return new ViewFucker(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewFucker holder, int position) {
        holder.optionIcon.setImageResource(optionItemArrayList.get(holder.getAdapterPosition()).getOptionIcon());
        holder.optionName.setText(optionItemArrayList.get(holder.getAdapterPosition()).getOptionName());
    }

    @Override
    public int getItemCount() {
        return optionItemArrayList.size();
    }

    public class ViewFucker extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView optionName;
        ImageView optionIcon;

        public ViewFucker(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            optionName = itemView.findViewById(R.id.optionName);
            optionIcon = itemView.findViewById(R.id.optionIcon);
        }

        @Override
        public void onClick(View v) {
            optionCallBack.onOptionItemClickListener(getAdapterPosition());
        }
    }
}
