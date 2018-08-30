package bhavikmaru.target.augmetic.target_with_bhavikmaru;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TutorialChapter extends AppCompatActivity {

    RecyclerView tutorialRecyclerview;
    List<Tutorial> tutorialList;
    TutorialAdapter tutorialAdapter;
    LinearLayoutManager linearLayoutManager;
    Toolbar toolbar;
    String recyclePosition;

    private DatabaseReference tutRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_chapter);
        toolbar = findViewById(R.id.tut_tab_toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();

        tutorialList = new ArrayList<>();
        recyclePosition = getIntent().getExtras().getString("postion");
        prepareTutorial();

        tutorialAdapter = new TutorialAdapter(this, tutorialList);

        tutorialRecyclerview = findViewById(R.id.chapter_recyclerview_tutorial);
        tutorialRecyclerview.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        tutorialRecyclerview.setLayoutManager(linearLayoutManager);
        tutorialRecyclerview.setAdapter(tutorialAdapter);
    }

    private void prepareTutorial() {

        tutRef = FirebaseDatabase.getInstance().getReference();
        tutRef = tutRef.child("tutorial").child(recyclePosition);

        tutorialList.clear();

        tutRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Tutorial tutInfo = postSnapshot.getValue(Tutorial.class);
                    tutorialList.add(tutInfo);
                    tutorialAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.tut_collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.tut_appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
