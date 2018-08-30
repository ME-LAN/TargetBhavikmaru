package bhavikmaru.target.augmetic.target_with_bhavikmaru;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    //Toolbar toolbar;
    RecyclerView chapterRecyclerView;
    List<Chapter> chapterList;
    ChapterAdapter cAdapter;
    LinearLayoutManager mLayoutManager;
    Toolbar toolbar;
    DatabaseReference chapterDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.cha_tab_toolbar);
        setSupportActionBar(toolbar);

        chapterDB = FirebaseDatabase.getInstance().getReference();
        chapterDB = chapterDB.child("chapters");

        chapterList = new ArrayList<>();
        prepareChapter();

        chapterRecyclerView = findViewById(R.id.chapter_recyclerview);
        chapterRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        chapterRecyclerView.setLayoutManager(mLayoutManager);
        cAdapter = new ChapterAdapter(this, chapterList);

        chapterRecyclerView.setAdapter(cAdapter);
    }

    private void prepareChapter() {

        chapterDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Chapter chTemp = postSnapshot.getValue(Chapter.class);
                    String chapterName = chTemp.getChapterName();
                    String teacherName = chTemp.getTeacherName();
                    Chapter chInfo = new Chapter(chapterName, teacherName);
                    chapterList.add(chInfo);
                    cAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        /*int[] covers = new int[]{
                R.drawable.c1,
                R.drawable.c2,
                R.drawable.c3,
                R.drawable.c4,
                R.drawable.c5,
                R.drawable.c6,
                R.drawable.c7
        };

        Chapter c = new Chapter("Current Affairs", "Darshan Rawal", covers[0]);
        chapterList.add(c);

        c = new Chapter("Gujarati Vyakaran", "Ghanshyam Chudasama", covers[1]);
        chapterList.add(c);

        c = new Chapter("Mathematics", "Paras Parmar", covers[2]);
        chapterList.add(c);

        c = new Chapter("English Grammar", "Saunak Patel", covers[3]);
        chapterList.add(c);

        c = new Chapter("Logical Reasoning", "Maulik Patel", covers[4]);
        chapterList.add(c);

        c = new Chapter("Gujarat No Itihas", "Rushi Chalaliya", covers[5]);
        chapterList.add(c);

        c = new Chapter("Bhartiy Itihas", "Khumaram Chaudhary", covers[6]);
        chapterList.add(c);*/
        }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Fragment bottomSheetFragment = new BottomSheetFragment();
                ((BottomSheetFragment) bottomSheetFragment).show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/

}