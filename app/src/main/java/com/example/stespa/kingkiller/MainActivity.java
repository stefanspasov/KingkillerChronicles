package com.example.stespa.kingkiller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements CharacterAdapter.CharacterAdapterOnClickHandler {

    private RecyclerView mRecyclerView;
    private CharacterAdapter mCharacterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_characters);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mCharacterAdapter = new CharacterAdapter(this);
        mRecyclerView.setAdapter(mCharacterAdapter);
        mCharacterAdapter.setCharacterData(new String[] {"Kvothe", "Chronicler", "Simon"});
    }

    @Override
    public void onClick(String characterName) {
        Intent startDetailActivity = new Intent(this, DetailActivity.class);
        startDetailActivity.putExtra(Intent.EXTRA_TEXT, characterName);
        startActivity(startDetailActivity);
    }
}
