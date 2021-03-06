package uw.tacoma.edu.paidaid.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import uw.tacoma.edu.paidaid.R;

/**
 * @Author Jake Knowles
 * @Author Dmitriy Onishchenko
 * @version 5/26/17
 *
/**
 * Email Activity is an activity launched when the user is able to pick up a request,
 * prompting the user with an email template ready to fill in.
 */
public class EmailActivity extends Activity {

    /** Send email button */
    public Button mSendEmail;

    /** Subject of email */
    public EditText mEmailSubject;

    /** Message content of email */
    public EditText mEmailMessage;

    /** Email of person */
    public String mRecipient = "";

    /**
     * onCreate loads up XML layout for Email Activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pick_up_request_message);

        /** Text edits where text will be typed in from user and a button to submit text */
        mEmailSubject = (EditText) findViewById(R.id.subject);
        mEmailMessage = (EditText) findViewById(R.id.message);
        mSendEmail = (Button) findViewById(R.id.send_button);

        Bundle args = getIntent().getExtras();
        if (args != null) {
            mRecipient = args.getString("REQUEST_EMAIL");
            Log.e("email", mRecipient);
        }

        /** Listener on button for sending email */
        mSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = mEmailSubject.getText().toString();
                String message = mEmailMessage.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {mRecipient});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("text/plain");
                startActivity(Intent.createChooser(email, "Send Email Via"));
                finish();
            }
        });
    }

}