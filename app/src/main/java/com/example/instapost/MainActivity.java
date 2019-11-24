package com.example.instapost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnActSubmit;
    private EditText edtAKA, edtSex, edtAge, edtActivity, edtSkill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        btnActSubmit = findViewById(R.id.btn_activity);
        btnActSubmit.setOnClickListener(MainActivity.this);
        edtAKA = findViewById(R.id.edtAKA);
        edtSex = findViewById(R.id.edtSex);
        edtAge = findViewById(R.id.edtAge);
        edtActivity = findViewById(R.id.edtActivity);
        edtSkill = findViewById(R.id.edtSkill);

    }

    @Override
    public void onClick(View v) {
        final ParseObject partner = new ParseObject("Partner");
        partner.put("name", edtAKA.getText().toString());
        partner.put("sex", edtSex.getText().toString());
        partner.put("age", edtAge.getText().toString());
        partner.put("activity", edtActivity.getText().toString());
        partner.put("skill", edtSkill.getText().toString());
        partner.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, partner.get("name") + ", your entry is saved.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
