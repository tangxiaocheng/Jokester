package jokester.fest.dev.jokester.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import jokester.fest.dev.jokester.R;

/**
 * Created by Wasim on 18-04-2015.
 */
public class FragmentOne extends Fragment {

    EditText m_txtJokeText;
    private FirebaseDatabase dref;
    private DatabaseReference dataRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_one,container,false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        dref = FirebaseDatabase.getInstance();
        dataRef = dref.getReference("FirebaseAppJokes/jokesByList");
        m_txtJokeText= (EditText) view.findViewById(R.id.txtNewJoke);
//        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(m_txtJokeText, InputMethodManager.SHOW_IMPLICIT);

        Button btnAddJoke = (Button) view.findViewById(R.id.cmdAddJoke);
        btnAddJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String content =    m_txtJokeText.getText().toString();

//              Auth auth =  FirebaseAuth.getInstance();

                JokeModel model = new JokeModel();
                model.setBody(content);
                model.setTitle(content);
//                model.setTitle(dref.getApp().g);


                Toast.makeText(getActivity(), "Your joke has been added ... NOT!",Toast.LENGTH_LONG).show();
                m_txtJokeText.setText("");


                InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imgr.hideSoftInputFromWindow(view.getWindowToken(), 0);





                DatabaseReference newPostRef = dataRef.push();
                newPostRef.setValue(model);


            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // write logic here b'z it is called when fragment is visible to user
    }

    @Override
    public void onResume() {
        super.onResume();
        m_txtJokeText.requestFocus();

        InputMethodManager imgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
