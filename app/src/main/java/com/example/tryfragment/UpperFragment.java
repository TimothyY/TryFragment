package com.example.tryfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment
        implements View.OnClickListener {

    Button btnShowGreetings, btnChangeActivity;
    private OnUpperFragmentInteractionListener mListener;

    public UpperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_upper, container, false);
//        btnShowGreetings =
//                rootView.findViewById(R.id.btnShowGreetings);
        btnShowGreetings.setOnClickListener(this);
        btnChangeActivity =
                rootView.findViewById(R.id.btnChangeActivity);
        btnChangeActivity.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnShowGreetings){
            Log.v("tryfrag","btnShowGreetings ditekan");
            Toast.makeText(getActivity(), "btnShowGreetings ditekan", Toast.LENGTH_SHORT).show();
            mListener.onUpperFragmentInteraction("btnShowGreetings ditekan");
        }else if(v.getId()==R.id.btnChangeActivity){
            Log.v("tryfrag","btnChangeActivity ditekan");
            Toast.makeText(getActivity(), "btnChangeActivity ditekan", Toast.LENGTH_SHORT).show();
            mListener.onUpperFragmentInteraction("btnChangeActivity ditekan");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnUpperFragmentInteractionListener){
            mListener = (OnUpperFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(
                    context.toString()+" must implement OnUpperFragmentInteractionListener"
            );
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener=null;
    }

    public interface OnUpperFragmentInteractionListener{
      void onUpperFragmentInteraction(String result);
    }
}
