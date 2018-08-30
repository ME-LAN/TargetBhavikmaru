package bhavikmaru.target.augmetic.target_with_bhavikmaru;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.MyViewHolder> {

    public Context tContext;
    public List<Tutorial> tutorialList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tutorialName, tutorialTime;
        public ImageView tutorialImage;
        public CardView tutorialCard;

        public MyViewHolder(View itemView) {
            super(itemView);
            tutorialName = itemView.findViewById(R.id.tutorial_name);
            tutorialTime = itemView.findViewById(R.id.tutorial_time);
            //tutorialImage = itemView.findViewById(R.id.tutorial_image);
            tutorialCard = itemView.findViewById(R.id.tutorial_card);
        }
    }

    public TutorialAdapter(Context tContext, List<Tutorial> tutorialList) {
        this.tContext = tContext;
        this.tutorialList = tutorialList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_tutorial, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tutorial tutorial = tutorialList.get(position);
        holder.tutorialName.setText(tutorial.getTutName());
        holder.tutorialTime.setText(tutorial.getTutTime());
        //Picasso.get().load(tutorial.getThumbnail()).into(holder.tutorialImage);

        holder.tutorialCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=Hxy8BZGQ5Jo")));
                Log.i("Video", "Video Playing....");
            }
        });
    }

    @Override
    public int getItemCount() {
        return tutorialList.size();
    }
}
