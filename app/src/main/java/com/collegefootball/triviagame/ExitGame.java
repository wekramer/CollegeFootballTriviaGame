package com.collegefootball.triviagame;

import com.collegefootball.triviagame.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;

public class ExitGame extends Activity implements OnClickListener,
		android.view.View.OnClickListener {

	SharedPreferences someData;
	public static String filename = "MySharedString";
	public String userName2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT)
				.show();

		setContentView(R.layout.activity_scores);

		Button exit = (Button) findViewById(R.id.exit);
		exit.setOnClickListener(this);

		someData = getSharedPreferences(filename, 0);

		// save score
		
		AlertDialog.Builder builderEnd = new AlertDialog.Builder(ExitGame.this);
		builderEnd.setTitle(userName2 + " saving at question " + "3"
				+ " and score of " + "3");
		builderEnd.setPositiveButton("Save Score?",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {

						Toast.makeText(getApplicationContext(),
								"Goodbye saved score", Toast.LENGTH_SHORT)
								.show();

					}
				});

		builderEnd.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		builderEnd.show();

		//input dialog

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Save User Name?");

		// Set up the input
		final EditText input = new EditText(this);
		// Specify the type of input expected; this, for example, sets the input
		// as a password, and will mask the text
		input.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_NORMAL);

		builder.setView(input);

		// Set up the buttons
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String m_Text = input.getText().toString();

				userName2 = m_Text;

			}
		});
		builder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		builder.show();

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.exit:
			finish();
			break;
		}
	}
}
