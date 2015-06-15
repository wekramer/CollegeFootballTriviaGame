package com.collegefootball.triviagame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.collegefootball.triviagame.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.InputType;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static final CharSequence[] Answers = { "Paris", "Barry Switzer", "Jimmy Johnson","Vince Lombardi", 
		"Big Ten", "ACC", "SEC", "1 foot", "both feet", "no feet", 
		"Johnny Manziel", "Archie Griffin", "Reggie Bush", "4", "5", "7", "Michigan", "Nebraska", "Ohio State",		
		"Yes", "Only regular season", "Never", "New Mexico State", "EMU", "UNLV", "10 minutes", "5 minutes", "2 minutes",
		"stunt", "blitz", "sack", 
		//10
		"touch back", "penalty", "ball down at spot", "Navy", "Oklahoma", " Florida State", "pitch", "lateral", "toss",
		"Oklahoma", "Nebraska", "Notre Dame", "5 yards", "10 yards ", "15 yards", "Michigan", "USC Trojans", "Nebraska",
		"safety", "punt", "penalty", "punt team", "special teams", "kick off team", "SEC", "Big Ten", "ACC",
		"Las Vegas bowl", "New Mexico bowl", "Idaho bowl",
		//10
		"Neither", "the defender", "the receiver", "Lou Holtz", "Nick Saban", "Urban Meye", "5 yards", "10 yards", "15 yards",
		"flea flicker", "hail Mary", "deep post", "option", "quarterback sneak", "plunge", "Zone rush", "blitz", "fast attack",
		"Alabama", "Michigan ", "Nebraska", "Joe Namath", "Roger Staubach", "Jim Plunkett", "Steve Spurrier", "Jim Tressel", "Jim Harbaugh",
		"Oklahoma", "Florida State", "LSU",
		//10
		"Virginia Tech", "Northwestern", "Buffalo", "Ohio State", "Auburn", "Oregon", "Army", "Navy", "Air Force",
		"Arkansas", "Florida", "USC", "Georgia Tech", "Yale", "Minnesota", "Miami", "Oklahoma", "Michigan State",
		"UCLA", "BYU", "Michigan State", "Michigan", "Alabama", "Notre Dame", "1902", "1922", "1934",
		"20", "32", "39",
		//10
		"90", "128", "140", "12", "13", "14", "0-0", "0-2", "0-3",
		"end kick", "touch out", "touch back", "all of the football", "half of the football", "tip of the football", "only penalty on offense", "only penalty on defense", "penalties offset each other",
		"Cotton Bowl", "Orange Bowl", "Outback Bowl", "coach reviews play", "ref reviews play", "coach calls coach upstairs for play", "player calling play", "player changing play", "player signals sideline",
		"0", "1", "2",
		
		"", "", "" };
	
	private static final CharSequence[] Quest = {
			"Where is the Eiffel Tower located?",
			"The first coach to win a Division 1-A Football Championship and a Super Bowl?",
			"What conference had a college that both won and lost the Division 1-A Football Championship in 2012?",
			"In college football, what needs to be in bounds to have a completed pass?",
			"Who was the only player to win two Heisman trophies?", "Most years in a row that a team from the SEC won the Division 1-A Football Championship game?",
			"What Division 1-A College Football team has won the most games all time?",
			"Is it possible to have the game end in a tie in Division 1-A College Football?",
			"What Division 1-A football team has the longest streak of not going to a bowl?",
			"What time in a game in college football will the clock stop briefly after a first down in the fourth quarter?",
			"What is the play called when the defensive player tackles an offensive player in the backfield?",
			//10
			"A Player from the kicking team swats the ball before it goes into the opposing teams end zone while his body is in the air in the end zone. The result is?",
			"The most amount of points scored by two teams in Division 1-A college football was 72-54 and the winner was?",
			"An offensive player is running down the field and tosses the ball parallel or behind him to another player this is called a?",
			"The longest home sell out streak in college football since 1962 is by?",
			"An onside kick must travel at least how many yards before it can be touched by the kicking team?",
			"This team plays in the largest stadium used in college football?",
			"If the offense fails to get the ball out of the end zone on a play this results in a?",
			"The group responsible for kickoffs, punts and field goals is called?",
			"What conference has won more national championships in college football?",
			"The first college football bowl to be played in the bowl season is?",
			//10
			"A ball is thrown into the end zone and the receiver and defender both catch the ball possession goes to?",
			"The only coach to win a national championship in Division 1-A college football at two different schools is?",
			"When an offense has a false start the penalty is?",
			"What is the play called when at the end of a game the receivers run down field to the end zone and the quarterback throws the ball as far as he can into the end zone?",
			"What is the play called when the quarterback needs very little yardage to get a first down and runs the ball himself behind the offensive center?",
			"What is the play called when one or more defenders rush into the offensive backfield?",
			"Which college football team has won more national championships?",
			"Who was the first quarterback to win a Heisman Trophy in college football and win a Superbowl?",
			"Which coach won a Heisman Trophy and coached a college team to a Division 1-A college football championship?",
			"Which Division 1-A college football team has the longest streak for going to a bowl game?",
			//10
			"Which Division 1-A college football team lost 34 games in a row?",
			"What college team was able to take a missed field goal at the end of the game and run all the way back down the field for a game winning touchdown?",
			"Which is the only military branch to never win a Division 1-A college football championship?",
			"What team won one of the longest college football games with 7 overtime periods and winning score 71-63?",
			"What team won one of the most lopsided college football games ever 222 - 0?",
			"What college football team had a 47 game win streak?",
			"What college football team after being down by 35 points in the 3rd quarter but came back to win the football game?",
			"Which college has gone to the most bowl games?",
			"What year was the first Rose Bowl game played?",
			"How many bowl games are there?",
			//10
			"How many colleges play Division 1-A football?",
			"The biggest football conferences for Division 1-A football are the ACC, the Big Ten and the SEC how many teams does each conference have?",
			"What is the lowest possible score in a college football game?",
			"What is it called when the punt  team kicks the ball to the other team and they don't catch it and it goes into the end zone?",
			"How much of the football needs to cross the end zone line to be considered a touchdown?",
			"A play is run and there is a penalty on the offense and then immediately after there is a penalty on the defense the result is?",
			"The four major bowls for BCS football are Rose Bowl, Fiesta Bowl, Sugar Bowl and?",
			"He's under the hood - refers to?",
			"When an offensive or defensive player calls an audible it means?",
			"How many overtime national championship football bowl games have there been?",
			
			"End of game click Select Question" };

	private static final CharSequence[] AnswersSelect = { "A", "B", "C", "A", "B", "C", "A", "C", "A", "B", "C",
		                                                //row1  1    2    3    4    5    6    7    8    9    10
	      "C", "A", "B", "B", "B", "A", "A", "B", "A", "B",
	//row2 1    2    3    4    5    6    7    8    9    10	
	     "C", "B", "A", "B", "B", "B", "A", "B", "A", "B",
   //row3 1    2    3    4    5    6    7    8    9    10
	     "B", "B", "C", "A", "A", "B", "C", "B", "A", "C",
   //row4 1    2    3    4    5    6    7    8    9    10
	     "B", "C", "B", "C", "C", "C", "B", "B", "B", "B" };
   //row5 1    2    3    4    5    6    7    8    9    10
	
	// change end num

	public int score;

	public static int highScore;
	public int quest_num = 0;
	public int quest_select_num = 0;
	int ansA = 0;
	int ansB = 0;
	int ansC = 0;
	int numAnsSelected = 0;
	int numQuestSelected = 0;

	private ImageView checkAImageView;
	private ImageView checkBImageView;
	private ImageView checkCImageView;
	private ImageView checkAImageViewWrong;
	private ImageView checkBImageViewWrong;
	private ImageView checkCImageViewWrong;

	EditText editTextSelctQuest, editTextAnsA, editTextAnsB, editTextAnsC,
			editTextScore;
	Button bAnsA, bAnsB, bAnsC, select_quest, editTextMainScreen;;
	String userName = null; // this will be replaced by edittext
	public static String filename = "MySharedString";
	public static String FILENAME;
	SharedPreferences someData;
	public static String outputScore;
	public String m_Text;
	public boolean imageview;

	private String reloadUserName;
	public boolean reloadGame2 = false;
	public int DisplayReloadTheScore;
	public String RELOADFILENAME;
	public String reloadString;
	public int reload_quest_number;
	public int reload_quest_number_from_exit;
	public FileInputStream fisreload;
	public int answer1of3;
	public int answer2of3;
	public int answer3of3;
	public boolean loadReloadAns;
	public String ReloadTheUserName;
	public String fullNameAndScore;
	public String fullNameAndScore1;
	public String string;
	public int loadnumQuestSelectedOnce;
	public boolean okToStartReload = false;
	public FileInputStream reloadok;
	public String reloadIsNowOK;
	public String RELOADOK;
	public String reloadisOK;
	FileOutputStream reloadOK;
	public String saveReloadIsOK;
	public FileInputStream fis;
	public static boolean scoreButtonClicked = false;

	//oncreate
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Welcome to The Trivia Game");
		builder.setPositiveButton("OK", null);
		builder.setMessage("Press “Select Question” to start game. Select A, B or C for correct answer. Click Menu for more options.");
		AlertDialog theAlertDialog = builder.create();
		theAlertDialog.show();

		select_quest = (Button) findViewById(R.id.select_question);
		bAnsA = (Button) findViewById(R.id.bAnsA);
		bAnsB = (Button) findViewById(R.id.bAnsB);
		bAnsC = (Button) findViewById(R.id.bAnsC);

		select_quest.setOnClickListener(this);
		bAnsA.setOnClickListener(this);
		bAnsB.setOnClickListener(this);
		bAnsC.setOnClickListener(this);

		editTextSelctQuest = (EditText) findViewById(R.id.editTextSelctQuest);
		editTextAnsA = (EditText) findViewById(R.id.editTextAnsA);
		editTextAnsB = (EditText) findViewById(R.id.editTextAnsB);
		editTextAnsC = (EditText) findViewById(R.id.editTextAnsC);
		editTextScore = (EditText) findViewById(R.id.editTextScore);

		checkAImageView = (ImageView) findViewById(R.id.anscheckAImageView);
		checkBImageView = (ImageView) findViewById(R.id.anscheckBImageView);
		checkCImageView = (ImageView) findViewById(R.id.anscheckCImageView);

		checkAImageViewWrong = (ImageView) findViewById(R.id.anscheckAWrongImageView);
		checkBImageViewWrong = (ImageView) findViewById(R.id.anscheckBWrongImageView);
		checkCImageViewWrong = (ImageView) findViewById(R.id.anscheckCWrongImageView);

		someData = getSharedPreferences(filename, 0);

	}

	//endoncreate

	//menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.scores:

			scoreButtonClicked = true;

			RunScoresRetrieve();

			Intent highIntent = new Intent(MainActivity.this, ScoresList.class);
			startActivity(highIntent);

			return true;

		case R.id.reload_game:

			CheckReloadOK();

			if (reloadIsNowOK != null) {

				reloadGame2 = true;

				ReloadGame();
				// ////////////////////////////////////////////////
				checkAImageView.setVisibility(ImageView.GONE);
				checkBImageView.setVisibility(ImageView.GONE);
				checkCImageView.setVisibility(ImageView.GONE);

				checkAImageViewWrong.setVisibility(ImageView.GONE);
				checkBImageViewWrong.setVisibility(ImageView.GONE);
				checkCImageViewWrong.setVisibility(ImageView.GONE);
				// ///////////////////////////////////////////////

			} else {
				Toast.makeText(getApplicationContext(),
						"Need To Click Exit And Save Before Reload Game",
						Toast.LENGTH_LONG).show();
				finish();
			}

			return true;

		case R.id.exit:

			Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT)
					.show();

			ExitAndSaveScore();

			return true;

		case R.id.feedback:

			Toast.makeText(getApplicationContext(), "Help/Feedback",
					Toast.LENGTH_SHORT).show();

			Intent intentFeedback = new Intent(MainActivity.this,
					Feedback.class);

			startActivity(intentFeedback);

			return true;

		case R.id.exit_no_save:

			Toast.makeText(getApplicationContext(), "Exit and no save",
					Toast.LENGTH_SHORT).show();

			finish();

			return true;

		}
		return false;

	}

	private void RunScoresRetrieve() {

		//get file score

		FILENAME = "all_scores";

		try {
			fis = openFileInput(FILENAME);
		
			byte[] dataArray = new byte[fis.available()];

			while (fis.read(dataArray) != -1) {

				String collected = new String(dataArray);

				outputScore = collected.toString();

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				fis.close();

			} catch (Exception e) {

				e.printStackTrace();
				
			}
		}

	}

	private void CheckReloadOK() {

		//get reload params
	
		RELOADOK = "reload_OK";

		try {
			reloadok = openFileInput(RELOADOK);
		
			byte[] dataArray = new byte[reloadok.available()];

			while (reloadok.read(dataArray) != -1) {

				String reloadokloaded = new String(dataArray);

				reloadIsNowOK = reloadokloaded.toString();

			}

		} catch (Exception e) {

			displayExcetionMessage(e.getMessage());

		} finally {
			try {
				
				reloadok.close();
				
			} catch (Exception e) {

				e.printStackTrace();
				displayExcetionMessage(e.getMessage());
			}
		}
            //get reload params
	}

	private void displayExcetionMessage(String message) {

		Toast.makeText(getApplicationContext(), "No Reload Game File",
				Toast.LENGTH_SHORT).show();
	}

	private void ReloadGame() {

		reloadGame2 = true;

		//get reload params

		RELOADFILENAME = "reload_params";

		try {
			fisreload = openFileInput(RELOADFILENAME);
			
			byte[] dataArray = new byte[fisreload.available()];

			while (fisreload.read(dataArray) != -1) {

				String collectedfisreload = new String(dataArray);

				reloadString = collectedfisreload.toString();

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				fisreload.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		//get reload params

		String[] separated = reloadString.split("/");

		ReloadTheUserName = separated[0];
		String ReloadTheScore = separated[1];
		String ReloadTheQuestNum = separated[2];

		if (reloadGame2 == true) {

			DisplayReloadTheScore = Integer.parseInt(ReloadTheScore);

			score = DisplayReloadTheScore;
			
			reload_quest_number_from_exit = Integer.parseInt(ReloadTheQuestNum);

			reload_quest_number = reload_quest_number_from_exit + 1;

			// two numbers used here .... quest_numreload_quest_number and
			// answers
			// formula for calculating answers [] position is
			// quest_num * 2 + awayfromfirstcountpos = answers []1of3
			// then add 1 and 2 to answers []1of2 and answers []1of3
			// ex... quest_num = 2 (starting counting position)
			// d
			
			answer1of3 = reload_quest_number * 2 + (reload_quest_number - 2);
			
			answer2of3 = answer1of3 + 1;
			
			answer3of3 = answer1of3 + 2;
			
		    // set toast to let userknow user name reloaded
			Toast.makeText(getApplicationContext(),
					"The username reloaded is " + ReloadTheUserName,
					Toast.LENGTH_LONG).show();

			editTextSelctQuest.setText(Quest[reload_quest_number]);

			editTextAnsA.setText(Answers[answer1of3]);
			editTextAnsB.setText(Answers[answer2of3]);
			editTextAnsC.setText(Answers[answer3of3]);

			loadReloadAns = true;

		}

		editTextScore.setText(Integer.toString(score));
	
		quest_num = reload_quest_number;

	}

	private void ExitAndSaveScore() {

		if (checkAImageView.isShown() || checkBImageView.isShown()
				|| checkCImageView.isShown() || checkAImageViewWrong.isShown()
				|| checkBImageViewWrong.isShown()
				|| checkCImageViewWrong.isShown()) {
			
			//input dialog box

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Save User Name?");

			// Set up the input
			final EditText input = new EditText(this);
			// Specify the type of input expected; this, for example, sets the
			// input as a password, and will mask the text
			input.setInputType(InputType.TYPE_CLASS_TEXT
					| InputType.TYPE_TEXT_VARIATION_NORMAL);

			builder.setView(input);

			// Set up the buttons
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							m_Text = input.getText().toString();

							reloadUserName = m_Text;
							m_Text = m_Text + "/";

							Toast.makeText(getApplicationContext(),
									"Saved User as " + reloadUserName,
									Toast.LENGTH_LONG).show();

							Toast.makeText(getApplicationContext(), "Exit",
									Toast.LENGTH_SHORT).show();

							saveUserParams();

						}

						private void saveUserParams() {

							//save file score
							RELOADFILENAME = "reload_params";

							FileOutputStream reloadfos = null;
							try {

								reloadfos = openFileOutput(RELOADFILENAME,
										Context.MODE_PRIVATE);

							} catch (FileNotFoundException e) {

								e.printStackTrace();
							}
							try {
								reloadfos.write(m_Text.getBytes());
								String reloadScore = java.lang.String
										.valueOf(score + "/");
								reloadfos.write(reloadScore.getBytes());
								String reloadQuest_num = java.lang.String
										.valueOf(quest_num);
								reloadfos.write(reloadQuest_num.getBytes());

								okToStartReload = true;
								
								ReloadOK();

							} catch (IOException e) {

								e.printStackTrace();
							}
							try {
								reloadfos.close();
								finish();
							} catch (IOException e) {

								e.printStackTrace();
							}

							//save file

						}
					});
			builder.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							finish();
							Toast.makeText(getApplicationContext(),
									"No Score Saved And No User Saved",
									Toast.LENGTH_LONG).show();
						}
					});

			builder.show();

			//input dialog box

			AlertDialog.Builder builderEnd = new AlertDialog.Builder(
					MainActivity.this);
			
			userName = m_Text;

			builderEnd.setTitle("Saving question " + quest_num
					+ " and score of " + score + ".");
			builderEnd.setPositiveButton("Save Score?",
					new DialogInterface.OnClickListener() {

						@SuppressLint("NewApi")
						@Override
						public void onClick(DialogInterface arg0, int arg1) {

							Toast.makeText(getApplicationContext(),
									"Saved User as ", Toast.LENGTH_LONG).show();

							Toast.makeText(getApplicationContext(), "Exit",
									Toast.LENGTH_SHORT).show();

							if (checkAImageView.isShown()
									|| checkBImageView.isShown()
									|| checkCImageView.isShown()
									|| checkAImageViewWrong.isShown()
									|| checkBImageViewWrong.isShown()
									|| checkCImageViewWrong.isShown()) {

							} else {
								Toast.makeText(getApplicationContext(),
										"checkAImageView isShown() NOT",
										Toast.LENGTH_SHORT).show();
								
							}

						}
					}

			);

			builderEnd.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					});

			builderEnd.show();

			// save the reload params
			//Log.e(TAG, "here is reloadfos ");
			// reloadUserName

		} else {
			Toast.makeText(getApplicationContext(),
					"Must pick answer before exit", Toast.LENGTH_LONG).show();
			
		}

	}

	private void ReloadOK() {

		//save file score
		RELOADOK = "reload_OK";

		try {

			reloadOK = openFileOutput(RELOADOK, Context.MODE_PRIVATE);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			reloadisOK = java.lang.String.valueOf("reloadOK");
			reloadOK.write(reloadisOK.getBytes());

			saveReloadIsOK = reloadisOK;
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			reloadOK.close();
			finish();
		} catch (IOException e) {

			e.printStackTrace();
		}
		//save file

	}

	//select question
	public void onClick(View arg0) {
		switch (arg0.getId()) {

		case R.id.select_question:
// change end num
			if (quest_num > 50) {
				bAnsA.setEnabled(false);
				bAnsB.setEnabled(false);
				bAnsC.setEnabled(false);
			}

			if (Quest[50].toString() == Quest[quest_num].toString()) {	

				//save score

				AlertDialog.Builder builderEnd = new AlertDialog.Builder(
						MainActivity.this);
				builderEnd.setTitle("");
				builderEnd.setPositiveButton("Save Score?",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								Toast.makeText(getApplicationContext(),
										"Goodbye saved score",
										Toast.LENGTH_SHORT).show();

								SharedPreferences.Editor editor = someData
										.edit();

								String scoreS = java.lang.String.valueOf(score);
								
								editor.putString(userName, scoreS);

								editor.commit();

								String nameAndScore = someData.getString(
										userName, scoreS);
								
								if (reloadGame2 == true) {
									m_Text = ReloadTheUserName;
									fullNameAndScore1 = m_Text + " = "
											+ nameAndScore + " \n ";
								} else {
									fullNameAndScore = userName + " = "
											+ nameAndScore + " \n ";
								}
								
								someData = getSharedPreferences(filename, 0);

								String scoress = someData.getString(userName,
										"No value");
								
								Toast.makeText(getApplicationContext(),
										scoress, Toast.LENGTH_LONG).show();

								String FILENAME = "all_scores";

								if (reloadGame2 == true) {
									string = fullNameAndScore1;
								} else {
									string = fullNameAndScore;
								}

								//save score

								//save file score

								FileOutputStream fos = null;
								try {

									fos = openFileOutput(FILENAME,
											Context.MODE_APPEND);
									
								} catch (FileNotFoundException e) {

									e.printStackTrace();
								}
								try {
									fos.write(string.getBytes());
									
								} catch (IOException e) {

									e.printStackTrace();
								}
								try {
									fos.close();
								} catch (IOException e) {

									e.printStackTrace();
								}

								//save file score

								//get file score

								fis = null;
								try {
									fis = openFileInput(FILENAME);
									//Log.e(TAG, "here is fis ");

									byte[] dataArray = new byte[fis.available()];

									while (fis.read(dataArray) != -1) {

										String collected = new String(dataArray);

										outputScore = collected.toString();

									}
								} catch (FileNotFoundException e) {

									e.printStackTrace();
								}

								catch (IOException e) {

									e.printStackTrace();
								} finally {
									try {
										fis.close();
									} catch (IOException e) {

										e.printStackTrace();
									}
								}

								//get file score

								reloadGame2 = false;

								Intent highIntent = new Intent(
										MainActivity.this, ScoresList.class);
								startActivity(highIntent);

								finish();
							}

						});
				builderEnd.setMessage("Game Over. Score = " + score);

				builderEnd.setNegativeButton("Exit",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								Toast.makeText(getApplicationContext(),
										"Goodbye", Toast.LENGTH_SHORT).show();
								finish();
							}

						});

				AlertDialog theAlertDialog = builderEnd.create();
				theAlertDialog.show();

				//input dialog box

				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				if (reloadGame2 == true) {
					
					m_Text = ReloadTheUserName;
					userName = ReloadTheUserName;
					
					builder.setTitle(userName
							+ " = reloaded UserName. Press OK.");
				} else {
					
					builder.setTitle("Save User Name?");
					
					userName = m_Text;
				}

				// Set up the input

				final EditText input = new EditText(this);
				// Specify the type of input expected; this, for example, sets
				// the input as a password, and will mask the text
				input.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_NORMAL);

				if (reloadGame2 == false) {
					builder.setView(input);
				}

				// Set up the buttons
				builder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								m_Text = input.getText().toString();

								userName = m_Text;

							}
						});
				builder.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();

							}
						});

				builder.show();

				//input dialog box

			}

			numQuestSelected = numQuestSelected + 1;

			if (reloadGame2 == true) {

				if (loadnumQuestSelectedOnce == 0) {
					numQuestSelected = numQuestSelected + 2;
					loadnumQuestSelectedOnce = loadnumQuestSelectedOnce + 1;
				}

			}

			if (numAnsSelected >= 1 || numQuestSelected == 1) {

				checkAImageView.setVisibility(ImageView.GONE);
				checkBImageView.setVisibility(ImageView.GONE);
				checkCImageView.setVisibility(ImageView.GONE);

				checkAImageViewWrong.setVisibility(ImageView.GONE);
				checkBImageViewWrong.setVisibility(ImageView.GONE);
				checkCImageViewWrong.setVisibility(ImageView.GONE);

				quest_num = quest_num + 1;

				quest_select_num = quest_num;

				editTextSelctQuest.setText(Quest[quest_select_num]);

				if (ansA == 0) {
					ansA = ansA + 1;
				} else {
					ansA = ansA + 3;

				}

				if (ansB == 0) {
					ansB = ansB + 2;
				} else {
					ansB = ansB + 3;

				}

				if (ansC == 0) {
					ansC = ansC + 3;
				} else {
					ansC = ansC + 3;

				}

				if (reloadGame2 == true && loadReloadAns == true) {
				
					ansA = answer1of3 + 3;
					
					ansB = answer2of3 + 3;
					
					ansC = answer3of3 + 3;
					
					loadReloadAns = false;
					
				}

				editTextAnsA.setText(Answers[ansA]);

				editTextAnsB.setText(Answers[ansB]);

				editTextAnsC.setText(Answers[ansC]);

				numAnsSelected = 0;
				
			} else {
			
				Toast.makeText(getApplicationContext(),
						"Make answer selection before selecting next question",
						Toast.LENGTH_LONG).show();
			}
			break;

		case R.id.bAnsA:

			// assign a constant for each button A,B,C then pass in constant to
			// checkanswer(A) and use hashmap for lookup
			
			String button_A = "A";

			// change end num
			if (quest_num >= 50) {
				bAnsA.setEnabled(false);
				bAnsB.setEnabled(false);
				bAnsC.setEnabled(false);
			}

			numAnsSelected = numAnsSelected + 1;
			
			CheckAnswer(button_A, quest_num);
			
			break;

		case R.id.bAnsB:
			
			String button_B = "B";

			if (quest_num >= 50) {
				bAnsA.setEnabled(false);
				bAnsB.setEnabled(false);
				bAnsC.setEnabled(false);
			}

			numAnsSelected = numAnsSelected + 1;
			
			CheckAnswer(button_B, quest_num);
			
			break;

		case R.id.bAnsC:
			
			String button_C = "C";

			if (quest_num >= 50) {
				bAnsA.setEnabled(false);
				bAnsB.setEnabled(false);
				bAnsC.setEnabled(false);
			}

			numAnsSelected = numAnsSelected + 1;
			
			CheckAnswer(button_C, quest_num);
			
			break;
		}

	}

	java.lang.String getString(CharSequence charSequence) {

		return null;
	}

	public void correctAnswerA() {

		checkAImageView.setVisibility(ImageView.INVISIBLE);

	}

	public void correctAnswerC() {

		checkCImageView.setVisibility(ImageView.VISIBLE);

	}

	//check answers in edit text box selected by button

	public void CheckAnswer(String string, int quest_num) {

		numQuestSelected = quest_num;

		if (numQuestSelected > 0) {

			if (numAnsSelected == 1) {

				if (string == "A") {

					if (string == AnswersSelect[quest_num]) {
						
						score = score + 1;

						if (score > highScore) {

							highScore = score;

						}

						editTextScore.setText(Integer.toString(score));
						
						checkAImageView.setVisibility(ImageView.VISIBLE);

					} else {
						
						checkAImageViewWrong.setVisibility(ImageView.VISIBLE);

						boolean imageviewA = true;

						imageview = imageviewA;

						imageviewA = false;

					}
				}

				if (string == "B") {

					if (string == AnswersSelect[quest_num]) {

						score = score + 1;

						if (score > highScore) {

							highScore = score;

						}

						editTextScore.setText(Integer.toString(score));

						checkBImageView.setVisibility(ImageView.VISIBLE);

						boolean imageviewB = true;

						imageview = imageviewB;

						imageviewB = false;

					} else {
						
						checkBImageViewWrong.setVisibility(ImageView.VISIBLE);

						boolean imageviewB = true;

						imageview = imageviewB;

						imageviewB = false;

					}
				}

				if (string == "C") {

					if (string == AnswersSelect[quest_num]) {

						score = score + 1;

						if (score > highScore) {

							highScore = score;

						}

						editTextScore.setText(Integer.toString(score));

						checkCImageView.setVisibility(ImageView.VISIBLE);

						boolean imageviewC = true;

						imageview = imageviewC;

						imageviewC = false;

					} else {
						
						checkCImageViewWrong.setVisibility(ImageView.VISIBLE);

						boolean imageviewC = true;

						imageview = imageviewC;

						imageviewC = false;

					}
				}

			} else {

			}

		}
	}

	//main end

}