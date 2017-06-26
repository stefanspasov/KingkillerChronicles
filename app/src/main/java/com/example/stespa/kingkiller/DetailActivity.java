package com.example.stespa.kingkiller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by stespa on 2017-06-21.
 */

public class DetailActivity extends AppCompatActivity {

    private String mCharacterName;
    private TextView mCharacterNameTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mCharacterNameTextView = (TextView) findViewById(R.id.tv_display_character);
        Intent intent = getIntent();
        if(intent != null)
        {
            if(intent.hasExtra(Intent.EXTRA_TEXT))
            {
                mCharacterName = intent.getStringExtra(Intent.EXTRA_TEXT);
                mCharacterNameTextView.setText(mCharacterName);
            }
        }
    }
}
