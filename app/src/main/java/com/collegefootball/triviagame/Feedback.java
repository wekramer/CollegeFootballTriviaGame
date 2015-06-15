package com.collegefootball.triviagame;

import com.collegefootball.triviagame.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Feedback extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.feedback);

		Button exit = (Button) findViewById(R.id.exit);
		exit.setOnClickListener(this);

		Button email_support = (Button) findViewById(R.id.email_support);
		email_support.setOnClickListener(this);

		Button website = (Button) findViewById(R.id.website);
		website.setOnClickListener(this);

		Button youtube_help = (Button) findViewById(R.id.youtube_help);
		youtube_help.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.email_support:
		
			SendEmail();
			break;

		case R.id.website:
		
			GoToWebsite();
			break;

		case R.id.youtube_help:
		
			GoToYouTubeHelp();
			break;

		case R.id.exit:
			finish();
			break;

		}
	}

	private void GoToWebsite() {

		startActivity(new Intent(
				Intent.ACTION_VIEW,
				
		Uri.parse("http://collegefootballtriviagame.weebly.com/")));

	}

	private void GoToYouTubeHelp() {

		startActivity(new Intent(Intent.ACTION_VIEW,
				
		Uri.parse("https://www.youtube.com/watch?v=8Xt3rPWQw7U")));

	}

	private void SendEmail() {

		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.putExtra(Intent.EXTRA_EMAIL,
				new String[] { "triviagameapps@yahoo.com" });
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback On College Football Trivia App");
		emailIntent.putExtra(Intent.EXTRA_TEXT,
				"Here is feedback on the app. My phone manufacturer is                 My phone model number is ");
		emailIntent.setType("message/rfc822");
		startActivity(emailIntent);
	}

}