package uz.khan.retrofit_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<GithubUser> currentList = new ArrayList<>();

    public void submitData(List<GithubUser> timeUis) {
        currentList.clear();
        currentList.addAll(timeUis);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeVh(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TimeVh) holder).onBind(currentList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }
}


class TimeVh extends RecyclerView.ViewHolder {

    View userView;

    public TimeVh(@NonNull View userView) {
        super(userView);
        this.userView = userView;
    }

    public void onBind(GithubUser timeUi) {
        ImageView imageView = userView.findViewById(R.id.image);
        TextView textView = userView.findViewById(R.id.nameTv);
        textView.setText(timeUi.login);

        Picasso.get().load(timeUi.avatarUrl).into(imageView);
    }
}
