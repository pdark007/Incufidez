package com.pdark007.incufidez;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuienesSomosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String TAG = "QuienesSomosFragment";
    private OnFragmentInteractionListener mListener;

    private EditText etponertexto;
    private Button btncomollegar;

    // TODO: Rename and change types and number of parameters
    public static QuienesSomosFragment newInstance(Bundle args) {
        QuienesSomosFragment fragment = new QuienesSomosFragment();
        if (args != null) {
            fragment.setArguments(args);
        }
        return fragment;
    }
    public QuienesSomosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_quienes_somos, container, false);
        return  rootView;

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_quienes_somos, container, false);
    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/
    //El fragment se ha adjuntado al Activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Object objeto);
    }

    public void initControls(){
        etponertexto = (EditText) getView().findViewById(R.id.etTexto);
        btncomollegar= (Button) getView().findViewById(R.id.btncomollegar);

        btncomollegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, ComoLlegarFragment.newInstance("Hola","Mundo"))
                        .commit();
                Toast.makeText(getActivity(), etponertexto.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        initControls();
    }
}
