package com.collegefootball.triviagame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.collegefootball.triviagame.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ScoresList extends Activity implements OnClickListener {

	SharedPreferences someDataScores;
	private FileInputStream fisGetHS;
	private String FILENAMEHS;
	private String theOutHighScore = "0";
	private String theOutHighScore2 = "0";
	private int NumtheOutHighScore = 0;
	private int NumtheOutHighScore2 = 0;
	private TextView highScore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_scores);

		TextView scoreView = (TextView) findViewById(R.id.scoreView);

		Button exit = (Button) findViewById(R.id.exit);
		exit.setOnClickListener(this);

		scoreView.setText(MainActivity.outputScore);

		int outHighScore = MainActivity.highScore;

		theOutHighScore = String.valueOf(outHighScore);

		highScore = (TextView) findViewById(R.id.highScore);

		FILENAMEHS = "save_high_score";

		try {
			fisGetHS = openFileInput(FILENAMEHS);

			byte[] dataArray = new byte[fisGetHS.available()];

			while (fisGetHS.read(dataArray) != -1) {

				String collected = new String(dataArray);

				theOutHighScore2 = collected.toString();

				MainActivity.scoreButtonClicked = false;

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

		}

		CompareHighScores();

	}// end oncreate

	public void CompareHighScores() {

		NumtheOutHighScore2 = Integer.parseInt(theOutHighScore2);

		NumtheOutHighScore = Integer.parseInt(theOutHighScore);

		if (NumtheOutHighScore > NumtheOutHighScore2) {
			theOutHighScore2 = theOutHighScore;

			highScore.setText(theOutHighScore2);

			SaveNewHighScore();

		}

		highScore.setText(theOutHighScore2);

		MainActivity.scoreButtonClicked = false;

	}

	private void SaveNewHighScore() {

		if (MainActivity.scoreButtonClicked == false) {
		
			java.lang.String stringHighScore = theOutHighScore;// High Score

			FileOutputStream fosHS = null;

			FILENAMEHS = "save_high_score";
			try {

				fosHS = openFileOutput(FILENAMEHS, Context.MODE_PRIVATE);
				
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				fosHS.write(stringHighScore.getBytes());
				
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				fosHS.close();
			
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		//save file score
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