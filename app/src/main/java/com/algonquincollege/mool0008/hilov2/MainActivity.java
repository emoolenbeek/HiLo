package com.algonquincollege.mool0008.hilov2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    // defining variables
    public EditText guess;
    public int guessCount = 0;
    private String guessText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // creating random number
        Random r = new Random();
        final int Low = 1;
        final int High = 1001;
        final int Result = r.nextInt(High-Low) + Low;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining variables
        final Button guessButton = (Button) findViewById( R.id.guessButton);
        final Button resetButton = (Button) findViewById( R.id.resetButton);
        // getting guess from editText view
        guess = (EditText) findViewById(R.id.inputBox);

        // click listener for guess button
        guessButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                String errorText = "";
                Boolean errorState = false;

                guessText = guess.getText().toString();
                // +1 to counter  
                guessCount++;
                final int guessCountMax = 10;
                final int superiorWin = 5;

                if (guessText.isEmpty()){
                    errorText = "Please enter a guess";
                    errorState = true;
                }else if(Integer.parseInt(guessText) > Result){
                    errorText = "Too High";
                    errorState = true;
                }else if(Integer.parseInt(guessText) < Result){
                    errorText = "Too Low";
                    errorState = true;
                }else if(guessCount > guessCountMax){
                    errorText = "Too Many Guesses, please reset";
                    errorState = true;
                }

                if (errorState){
                    Toast.makeText( getApplicationContext( ), errorText, Toast.LENGTH_SHORT ).show( );
                }else if (guessCount <= superiorWin){
                    // toast superior win
                    Toast.makeText( getApplicationContext( ), "Congrats - Superior Win!!\n" + "you won in: " + guessCount + " guesse(s)", Toast.LENGTH_LONG ).show( );
                }else{
                    // toast excellent win
                    Toast.makeText( getApplicationContext( ), "Congrats - Excellent Win!!\n" + "you won in: " + guessCount + " guesses", Toast.LENGTH_LONG ).show( );
                }
            }
        });

        // click listener for reset button
        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // reset count to 0
            guessCount = 0;
                // generate new random num
                Random r = new Random();
                // toast for reset
                Toast.makeText( getApplicationContext( ), "Game has been reset", Toast.LENGTH_SHORT ).show( );
            }
        });

    }
}
