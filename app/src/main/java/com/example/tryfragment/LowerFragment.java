package com.example.tryfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LowerFragment extends Fragment {

    TextView tvLFResult;

    public LowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lower, container, false);
        tvLFResult = rootView.findViewById(R.id.tvLFResult);
        return rootView;
    }

    public void updateResult(String result){
        tvLFResult.setText(result);
    }

}
