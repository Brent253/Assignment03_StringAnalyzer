package co.miniforge.corey.stringanalyzer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    public static String intentTag = "inputData";

    EditText input;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        locateViews();

        bindFunctionality();
    }

    void locateViews(){
        input = (EditText) findViewById(R.id.stringToAnalyzeEditText);
        submit = (Button) findViewById(R.id.submitButton);
    }

    void bindFunctionality(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context message = getApplicationContext();
                //Check if the fields are blank
                if(input.getText().toString().trim().length() == 0)
                {
                    CharSequence text = "Please enter a message!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(message,text,duration);
                    toast.show();
                }
                //Routed to correct activity
                else {
                    Intent intent = new Intent(getApplicationContext(), AnalyzerActivity.class);
                    intent.putExtra(intentTag, input.getText().toString());
                    startActivity(intent);

                }
            }
        });
    }
}
