package uw.tacoma.edu.paidaid.view;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uw.tacoma.edu.paidaid.R;


/** Post Request Fragment is from clicking on the Add button - this allows a user to import their
 * request details (tip amount, distance from poster to picker - upper, store name, time until expire,
 * and the items and additional comments.*/
public class PostRequestFragment extends Fragment {

        /** OnFragmentInteractionListener */
        private OnFragmentInteractionListener mListener;

        /** Constructor */
        public PostRequestFragment() {}

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
            return inflater.inflate(R.layout.fragment_post_request, container, false);
        }


        /**
         * onButtonPressed
         * @param uri uri is a string of characters used to identify a resource.
         */
        public void onButtonPressed(Uri uri) {
            if (mListener != null) {
                mListener.onFragmentInteraction(uri);
            }
        }

        /** OnFragmentInteractionListener */
        public interface OnFragmentInteractionListener {
            void onFragmentInteraction(Uri uri);
        }
}
