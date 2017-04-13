package net.androidbootcamp.haiquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class matchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);

        //changes the size and font color of spinner from the R.layout.spinner_item in layouts folder
        Spinner item1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> item1adapter = ArrayAdapter.createFromResource(
                this, R.array.answerGrp1, R.layout.spinner_item);
        item1adapter.setDropDownViewResource(R.layout.spinner_item);
        item1.setAdapter(item1adapter);

        //changes the size and font color of spinner from the R.layout.spinner_item in layouts folder
        Spinner item2 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> item2adapter = ArrayAdapter.createFromResource(
                this, R.array.answerGrp2, R.layout.spinner_item);
        item2adapter.setDropDownViewResource(R.layout.spinner_item);
        item2.setAdapter(item2adapter);

    }
}
