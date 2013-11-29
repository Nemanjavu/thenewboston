package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements OnClickListener {

	EditText personsEmail, intro, personName, stupidThinks, hatefulAction,
			outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		personName = (EditText) findViewById(R.id.etName);
		stupidThinks = (EditText) findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail = (Button) findViewById(R.id.bSendEmail);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		convertEditTextVarsIntoStringsAndYesThisIsMethodWeCreated();
		String emailadress[] = { emailAdd };
		String message = "Well hello "
				+ name
				+ " I just wanted to say "
				+ beginning
				+ ". Not only that but I hate when you "
				+ stupidAction
				+ ", that just really makes me creazy. I just want to make you "
				+ hatefulAct
				+ ". Welp, that all I wanted to chit-chatter about, oh and"
				+ out
				+ ". Oh also if you get bored you should chec out www.mybringbac.com"
				+ '\n' + "Ps. I think I love you ...";

		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailadress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
	}

	private void convertEditTextVarsIntoStringsAndYesThisIsMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personName.getText().toString();
		stupidAction = stupidThinks.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
