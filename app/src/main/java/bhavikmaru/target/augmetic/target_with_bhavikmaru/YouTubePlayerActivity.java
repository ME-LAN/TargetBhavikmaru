package bhavikmaru.target.augmetic.target_with_bhavikmaru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import static bhavikmaru.target.augmetic.target_with_bhavikmaru.R.id.youtube_player_fragment;

public class YouTubePlayerActivity extends AppCompatActivity {

    private YouTubePlayer youTubePlayer;
    private YouTubePlayerSupportFragment youTubePlayerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_player);
        initializeYoutubePlayer();
    }

    private void initializeYoutubePlayer() {
        


    }
}
