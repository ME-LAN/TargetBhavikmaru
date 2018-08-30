package bhavikmaru.target.augmetic.target_with_bhavikmaru;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    FirebaseAuth authUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authUser = FirebaseAuth.getInstance();
        if(authUser.getCurrentUser() != null){
            startActivity(new Intent(Splash.this, MainActivity.class));
            finish();
        }else {
            startActivity(new Intent(Splash.this, SignIn.class));
            finish();
        }
    }
}
