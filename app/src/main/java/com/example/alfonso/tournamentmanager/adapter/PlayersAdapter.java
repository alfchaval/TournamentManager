package com.example.alfonso.tournamentmanager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alfonso.tournamentmanager.R;
import com.example.alfonso.tournamentmanager.db.repository.PlayerRepository;
import com.example.alfonso.tournamentmanager.pojo.Player;

import java.util.ArrayList;

    /**
     * @author Alfonso Chamorro Valle
     */

    public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {

        private ArrayList<Player> players;
        private ArrayList<Player> playersModified;

        /**
         * Constructor que se llamará cuando Sector Activity venga de un cambio de Configuración
         * y se haya salvado el estado dinámico
         * @param playersModified
         */
        public PlayersAdapter(ArrayList<Player> playersModified) {
            players = PlayerRepository.getInstance().getPlayers();
            this.playersModified = getPlayersModified();
        }

        public PlayersAdapter() {
            players = PlayerRepository.getInstance().getPlayers();
        }

        @Override
        public PlayersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_player, null);
            PlayersViewHolder playersViewHolder = new PlayersViewHolder(view);
            return playersViewHolder;
        }

        @Override
        public void onBindViewHolder(PlayersViewHolder holder, int position) {
            holder.txvName.setText(players.get(position).get_name());
            holder.txvTelephone.setText(players.get(position).get_telephone());
        }

        @Override
        public int getItemCount() {
            return players.size();
        }

        public static class PlayersViewHolder extends RecyclerView.ViewHolder {

            private TextView txvName;
            private TextView txvTelephone;

            public PlayersViewHolder(View view) {
                super(view);
                txvName = (TextView) view.findViewById(R.id.txvName);
                txvTelephone = (TextView) view.findViewById(R.id.txvTelephone);}
        }

        public ArrayList<Player> getPlayersModified() {
            return playersModified;
        }

    }