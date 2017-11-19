package com.example.alfonso.tournamentmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alfonso.tournamentmanager.db.repository.TournamentRepository;
import com.example.alfonso.tournamentmanager.pojo.Tournament;
import com.example.alfonso.tournamentmanager.R;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * @author Alfonso Chamorro Valle
 */

public class TournamentAdapter extends ArrayAdapter<Tournament> {

    /**
     * Se crea una copia del ArrayList que se tiene en TournamentRepository para tener
     * una copia local en el adapter que se pueda cambiar sin modificar los datos originales
     * @param context
     */
    public TournamentAdapter(@NonNull Context context) {
        super(context, R.layout.item_tournament, TournamentRepository.getInstance().getTournaments());
        sort(new Tournament.TournamentOrderByName());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TournamentHolder tournamentHolder;
        View view = convertView;

        if(convertView == null) {
            //1. Obtener el servicio dle sistema Layout Inflater
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_tournament.xml
            view = inflater.inflate(R.layout.item_tournament, null);
            tournamentHolder = new TournamentHolder();

            //3. Inicializar las variables a los objetos ya creados de los widget del xml
            tournamentHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            tournamentHolder.txvOrganizer = (TextView) view.findViewById(R.id.txvTelephone);
            view.setTag(tournamentHolder);
        }
        else {
            tournamentHolder = (TournamentHolder) view.getTag();
        }

        //4. Mostrar los datos del ArrayList mediante la posición.
        tournamentHolder.txvName.setText("Nombre: " + getItem(position).get_name());
        tournamentHolder.txvOrganizer.setText("Organizador: " + getItem(position).get_organizer().get_name());

        return view;
    }

    class TournamentHolder {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvOrganizer;
    }
}