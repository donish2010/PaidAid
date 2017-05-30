package uw.tacoma.edu.paidaid.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import uw.tacoma.edu.paidaid.R;
import uw.tacoma.edu.paidaid.model.Request;

/**
 * @Author Jake Knowles
 * @Author Dmitriy Onishchenko
 * @version 5/11/17
 *
/** Review Fragment is from clicking on the messages button, then clicking on a username to review,
 * and then this fragment gives users an option to give a star rating (1 - 5) */
public class ReviewFragment extends Fragment {

    /** Request Item Selected Constant */
    public final static String REQUEST_ITEM_SELECTED = "request_selected";

    /** Request Selected Constant */
    public final static String REQUEST_SELECTED = "request_selected";


    /** Username text view for populating with the username of the request poster */
    private EditText mUsernameTextView;

    /** Request */
    private Request mRequest;

    /** Constructor */
    public ReviewFragment() {}

    /**
     * onCreate
     * @param savedInstanceState is a reference to a Bundle object that is passed into the onCreate method
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * onCreateView
     * @param inflater instantiates the layout XML file into its corresponding View objects
     * @param container is a container for ViewGroup views
     * @param savedInstanceState is a reference to a Bundle object that is passed into the onCreate method
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        String value = getArguments().getString("REQUEST_USERNAME");


        mUsernameTextView = (EditText) view.findViewById(R.id.username_text);
        mUsernameTextView.setText(value);

        mUsernameTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.submit_rating:
                            goBackToRequestDetails();
                        break;
                    default:
                        break;
                }
            }
        });

        return view;
    }

    public void goBackToRequestDetails() {
        
    }


    /** OnFragmentInteractionListener */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
