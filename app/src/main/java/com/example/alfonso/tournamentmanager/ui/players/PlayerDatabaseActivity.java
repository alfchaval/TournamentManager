package com.example.alfonso.tournamentmanager.ui.players;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alfonso.tournamentmanager.R;
import com.example.alfonso.tournamentmanager.adapter.PlayersAdapter;

/**
 * @author Alfonso Chamorro Valle
 */

public class PlayerDatabaseActivity extends AppCompatActivity{

    private RecyclerView recyclerSector;
    private PlayersAdapter playersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        recyclerSector = (RecyclerView) findViewById(R.id.rvPlayers);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new LinearLayoutManager(this));

        playersAdapter = new PlayersAdapter();
    }
}
