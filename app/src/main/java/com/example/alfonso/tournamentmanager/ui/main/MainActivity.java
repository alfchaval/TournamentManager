package com.example.alfonso.tournamentmanager.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.alfonso.tournamentmanager.R;
import com.example.alfonso.tournamentmanager.adapter.TournamentAdapter;
import com.example.alfonso.tournamentmanager.db.repository.PlayerRepository;
import com.example.alfonso.tournamentmanager.db.repository.TournamentRepository;
import com.example.alfonso.tournamentmanager.pojo.Tournament;
import com.example.alfonso.tournamentmanager.ui.about.AboutUsActivity;
import com.example.alfonso.tournamentmanager.ui.players.PlayerDatabaseActivity;

/**
 * @author Alfonso Chamorro Valle
 */

public class MainActivity extends AppCompatActivity {

    private TournamentAdapter adapter;
    private ListView listview;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new TournamentAdapter(this);
        listview = (ListView) findViewById(android.R.id.list);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        fab = findViewById(R.id.fab);

        listview.setAdapter(adapter);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TournamentRepository tournamentRepository = TournamentRepository.getInstance();
                Tournament tournament = new Tournament(tournamentRepository.getTournaments().size(), "Nuevo torneo", PlayerRepository.getInstance().getPlayers().get(0));
                tournamentRepository.addTournament(tournament);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_player_database:
                startActivity(new Intent(this, PlayerDatabaseActivity.class));;
                break;
            case R.id.action_about_us:
                startActivity(new Intent(this, AboutUsActivity.class));;
                break;
        }
        return true;
    }
}
