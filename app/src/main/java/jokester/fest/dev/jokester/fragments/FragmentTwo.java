package jokester.fest.dev.jokester.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import jokester.fest.dev.jokester.R;

/**
 * Created by Wasim on 18-04-2015.
 */
public class FragmentTwo extends Fragment {

    private ListView listview;
    private ArrayList<String> list = new ArrayList<>();
    private FirebaseDatabase dref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_two, container, false);

        listview = (ListView) rootview.findViewById(R.id.listview);
        dref = FirebaseDatabase.getInstance();
        DatabaseReference dataRef = dref.getReference("FirebaseAppJokes/jokesByList");

        FirebaseListAdapter mAdapter = new FirebaseListAdapter<JokeModel>(getActivity(), JokeModel.class, R.layout.layout, dataRef) {
            @Override
            protected void populateView(View view, JokeModel myObj, int position) {
                ((TextView) view.findViewById(R.id.textView1)).setText("userName:"+myObj.getAuthor());
                ((TextView) view.findViewById(R.id.textView2)).setText(myObj.getBody());
                ((TextView) view.findViewById(R.id.textView3)).setText(myObj.getTitle());
                ((TextView) view.findViewById(R.id.textView4)).setText("userID:"+myObj.getUid());
                ((TextView) view.findViewById(R.id.textView5)).setText("" + myObj.getViewCount());
            }
        };
        listview.setAdapter(mAdapter);
        return rootview;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
