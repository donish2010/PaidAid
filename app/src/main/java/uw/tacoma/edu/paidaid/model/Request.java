package uw.tacoma.edu.paidaid.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Jake Knowles
 * @Author  Dmitriy Onishchenko
 * @version 5/29/2017
 *
/**
 * Request object that contains all necessary request info
 * (tip amount, distance, store name, expiration time, items & comments, rating)
 */
public class Request implements Serializable {

    /** Units for miles when forming string */
    public static final String MILES_UNITS = " miles";

    /** Money symbol when forming string to display */
    public static final String MONEY_SIGN = "$";

    /** Constant for JSON user id */
    public static final String USER_ID = "userid";

    /** Constant for JSON username */
    public static final String USERNAME = "username";

    /** Constant for JSON email */
    public static final String EMAIL = "email";

    /** Constant for JSON key tip_amount */
    public static final String TIP_AMOUNT = "tip";

    /** Constant for JSON key distance_away */
    public static final String DISTANCE_AWAY = "distance";

    /** Constant for JSON key store_name */
    public static final String STORE_NAME = "storename";

    /** Constant for JSON key items_and_comments */
    public static final String ITEMS_AND_COMMENTS = "items_comments";

    /** Constant for JSON key star_rating */
    public static final String STAR_RATING = "rating";

    // Tip amount for picking up request
    private double mTip;

    // Distance away from request
    private double mDistanceAway;

    // Store name of where items are located
    private String  mStoreName;

    // Items & Comments contained in Request
    private String mItemsAndComments;

    // 1 - 5 Star rating
    private float mStarRating;

    // User ID
    private int mUserID;

    // Username
    private String mUsername;

    // Email
    private String mEmail;

    private Double mLatitude;

    private Double mLongitude;

    /**
     * Requests Constructor
     * @param theTip is the tip in cash rewarded to user for picking up request
     * @param theDistanceAway is the distance the poster is what the picker-upper
     * @param theStoreName is the store name where the items are
     * @param theItemsAndComments is the list of items and additional comments if need be
     */
    public Request(int theUserID, String theUsername, String theEmail, double theTip, double theLatitude,
                   double theLongitude, double theDistanceAway,
                   String theStoreName, String theItemsAndComments, float theStarRating) {

        mUserID = theUserID;
        mUsername = theUsername;
        mEmail = theEmail;
        mTip = theTip;
        mLatitude = theLatitude;
        mLongitude = theLongitude;
        mDistanceAway = theDistanceAway;
        mStoreName = theStoreName;
        mItemsAndComments = theItemsAndComments;
        mStarRating = theStarRating;

    }


    /**
     * Parses the json string, returns an error message if unsuccessful.
     * Returns course list if success.
     * @param requestJSON
     * @return reason or null if successful.
     */
    public static String parseRequestsJSON(String requestJSON, List<Request> requestsList) {
        String reason = null;
        if (requestJSON != null) {
            try {
                JSONArray arr = new JSONArray(requestJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Request request = new Request(obj.getInt(Request.USER_ID), obj.getString(Request.USERNAME),
                            obj.getString(Request.EMAIL), obj.getDouble(Request.TIP_AMOUNT),
                            obj.getDouble("lat"), obj.getDouble("lng"),
                            obj.getDouble(Request.DISTANCE_AWAY), obj.getString(Request.STORE_NAME),
                            obj.getString(Request.ITEMS_AND_COMMENTS), (float) obj.getDouble(Request.STAR_RATING));
                    requestsList.add(request);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }

    /**
     * Getter mUserID
     * @return the User ID
     */
    public int getmUserID() {
        return mUserID;
    }

    /**
     * Getter mUsername
     * @return the Username of the user who posted the request
     */
    public String getmUsername() {
        return mUsername;
    }

    /**
     * Getter mEmail
     * @return the email of the user
     */
    public String getmEmail() {
        return mEmail;
    }

    /**
     * Getter for mTipAmount
     * @return tip amount ($0.00)
     */
    public double getmTipAmount() {
        return mTip;
    }

    /**
     * Getter for mDistanceAway
     * @return distance away from request
     */
    public double getmDistanceAway() {
        return mDistanceAway;
    }

    /**
     * Getter for mStoreName
     * @return the name of the store where the items are located
     */
    public String getmStoreName() {
        return mStoreName;
    }


    /**
     * Getter mItemsAndComments
     * @return the request items and additional comments
     */
    public String getmItemsAndComments() {
        return mItemsAndComments;
    }


    /**
     * Getter mStarRating
     * @return the Star Rating for the user
     */
    public float getmStarRating() {
        return mStarRating;
    }


    /**
     * Getter latitude
     * @return the latitude
     */
    public double getLatitude() {
        return mLatitude;
    }


    /**
     * Getter longitude
     * @return the longitude
     */
    public double getLongitude() {
        return mLongitude;
    }

    /**
     * Getter distance
     * @return the distance
     */
    public void setDistanceAway(double theDistance) {
        mDistanceAway = theDistance;
    }


}