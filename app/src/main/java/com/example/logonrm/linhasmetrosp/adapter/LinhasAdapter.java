package com.example.logonrm.linhasmetrosp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonrm.linhasmetrosp.R;
import com.example.logonrm.linhasmetrosp.model.LinhasMetro;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by logonrm on 21/06/2017.
 */

public class LinhasAdapter extends RecyclerView.Adapter<LinhasAdapter.LinhasViewHolder>{

    private List<LinhasMetro> linhasMetros;
    private OnItemClickListener listener;

    public LinhasAdapter(List<LinhasMetro> linhasMetros, OnItemClickListener listener) {
        this.linhasMetros = linhasMetros;
        this.listener = listener;
    }

    @Override
    public LinhasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.android_row, parent,false);

        return new LinhasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LinhasViewHolder holder, final int position) {

        holder.tvTitulo.setText(linhasMetros.get(position).getCor());
        holder.tvSubtitulo.setText(linhasMetros.get(position).getNumero());

        Picasso.with(holder.itemView.getContext())
                .load(linhasMetros.get(position).getUrlImage())
                .into(holder.ivImagem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(linhasMetros.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {

        return linhasMetros.size();

    }

    public class LinhasViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitulo;
        public TextView tvSubtitulo;
        public ImageView ivImagem;


        public LinhasViewHolder(View itemView) {
            super(itemView);

            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tvSubTitulo);
            ivImagem = (ImageView) itemView.findViewById(R.id.ivLogo);
        }

    }

    public void update(List<LinhasMetro> linhasMetros){
        this.linhasMetros = linhasMetros;
        notifyDataSetChanged();
    }

}
