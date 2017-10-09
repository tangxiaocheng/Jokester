package jokester.fest.dev.jokester.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import jokester.fest.dev.jokester.R;

/**
 * Created by Wasim on 18-04-2015.
 */
public class FragmentTwo extends Fragment {

    public static FragmentTwo newInstance(String SearchType) {
        FragmentTwo f = new FragmentTwo();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putCharSequence("SearchType", SearchType);
        f.setArguments(args);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_two,container,false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String strSearchType = (String) args.getCharSequence("SearchType", "?");

        TextView txtJokeListInfo = (TextView) view.findViewById(R.id.txtJokeListInfo);
        txtJokeListInfo.setText("Joke list: " + strSearchType);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // write logic here b'z it is called when fragment is visible to user
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
