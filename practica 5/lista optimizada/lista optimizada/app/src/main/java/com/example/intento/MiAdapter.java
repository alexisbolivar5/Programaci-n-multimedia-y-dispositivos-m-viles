package com.example.intento;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MiAdapter extends RecyclerView.Adapter<MiAdapter.MiViewHolder> {

    private List<data> listaPeliculas;

    public MiAdapter(List<data> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        public TextView tituloTextView;
        public TextView directorTextView;
        public ImageView imageView;

        public MiViewHolder(View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.titulo_pelicula_textView);
            directorTextView = itemView.findViewById(R.id.director_textView);

            imageView = itemView.findViewById(R.id.pelicula_imageView);
        }
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.peli_lista, parent, false);
        return new MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        data peliculaActual = listaPeliculas.get(position);

        holder.tituloTextView.setText(peliculaActual.getTitulo());
        holder.directorTextView.setText(peliculaActual.getDirector());

        holder.imageView.setImageResource(peliculaActual.getImagenID());
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }
}