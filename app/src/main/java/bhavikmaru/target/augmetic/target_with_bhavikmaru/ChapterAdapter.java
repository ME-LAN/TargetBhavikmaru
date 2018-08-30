package bhavikmaru.target.augmetic.target_with_bhavikmaru;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {
    private Context mContext;
    private List<Chapter> chapterList;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView chapterName, teacherName;
        public ImageView chapterImage;
        public CardView chapterCard;

        public MyViewHolder(View itemView) {
            super(itemView);
            chapterName = itemView.findViewById(R.id.chapter_name);
            teacherName = itemView.findViewById(R.id.teacher_name);
            chapterImage = itemView.findViewById(R.id.teacherImage);
            chapterCard = itemView.findViewById(R.id.chapter_card);
        }
    }

    public ChapterAdapter(Context mContext, List<Chapter> chapterList){
        this.mContext = mContext;
        this.chapterList = chapterList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Chapter chapter = chapterList.get(position);
        holder.chapterName.setText(chapter.getChapterName());
        holder.teacherName.setText(chapter.getTeacherName());
        //Picasso.get().load(chapter.getThumbnail()).into(holder.chapterImage);

        holder.chapterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Hello", String.valueOf(position));
                final Intent tutIntent;
                tutIntent = new Intent(mContext, TutorialChapter.class);
                tutIntent.putExtra("postion", String.valueOf(position));
                mContext.startActivities(new Intent[]{tutIntent});

                /*AuthUI.getInstance()
                        .signOut(mContext)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(mContext, "Logout Successfull", Toast.LENGTH_SHORT).show();
                            }
                        });*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }
}
