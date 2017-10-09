package jokester.fest.dev.jokester;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import jokester.fest.dev.jokester.fragments.FragmentOne;
import jokester.fest.dev.jokester.fragments.FragmentTwo;
import jokester.fest.dev.jokester.fragments.JokeModel;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(0);
                    return true;
                case R.id.navigation_dashboard:
                    changeFragment(1);
                    return true;
                case R.id.navigation_notifications:
                    changeFragment(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    private void changeFragment(int position) {

        Fragment newFragment = null;

        if (position == 0) {
            newFragment = new FragmentOne();
        } else if (position == 1) {
            newFragment = FragmentTwo.newInstance("BEST");
        } else {
            newFragment = FragmentTwo.newInstance("RECENT");
        }

        getFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, newFragment)
                .commit();
    }

    //
//    FirebaseAppJokes
//            jokesByList
// -Kw1YwqS9Tr7RVaCGHPm
//    author:
//            "testAuthor"
//    body:
//            "testBody"
//    title:
//            "testTitle"
//    uid:
//            "sEuuQb7qyxeQ4qQ0HRHPrSdTnVn2"
//    viewCount:
//            0


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);





        changeFragment(0);

    }



}
