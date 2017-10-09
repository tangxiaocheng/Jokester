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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import jokester.fest.dev.jokester.fragments.FragmentOne;
import jokester.fest.dev.jokester.fragments.FragmentTwo;

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
        } else {
            newFragment = new FragmentTwo();
        }

        getFragmentManager().beginTransaction().replace(
                R.id.fragmentContainer, newFragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FirebaseDatabase database = FirebaseDatabase.getInstance();


        DatabaseReference myRef = database.getReference("dev_jokes");


        List<Joke> jokes = new ArrayList<Joke>();
        jokes.add(new Joke("knife is one dollar", "2017-10-9", "nouser", "0", "jokeid_test"));
        jokes.add(new Joke("knife is one dollar2", "2017-10-9", "nouser", "0", "jokeid_test2"));
        jokes.add(new Joke("knife is one dollar3", "2017-10-9", "nouser", "0", "jokeid_test3"));
        jokes.add(new Joke("knife is one dollar4", "2017-10-9", "nouser", "0", "jokeid_test4"));


        myRef.setValue(jokes);

        changeFragment(0);

    }



}
