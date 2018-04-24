package eu.fse.notz;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Amministratore on 12/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

    private ArrayList<Note> mDataset;
    public Context context;

    

    public  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTv;
        public TextView descriptionTv;

        public ViewHolder(final View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.title_Tv);
            descriptionTv = (TextView) itemView.findViewById(R.id.description_Tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = mDataset.get(getAdapterPosition()).getTitle();
                    String description = mDataset.get(getAdapterPosition()).getDescription();


                    Intent intent = new Intent(context, NoteActivity.class);
                    intent.putExtra("titleTv", title);
                    intent.putExtra("descriptionTv", description);
                    intent.putExtra("position", getAdapterPosition());
                    ((MainActivity)context).startActivityForResult(intent,);

                }
            });


        }
    }


    public NotesAdapter(ArrayList<Note> myDataset, Context context) {

        mDataset = myDataset;
        this.context = context;
    }

    public void addNote(Note note){
        mDataset.add(0,note);
        notifyItemInserted(0);
    }


    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_note, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder holder, int position) {
        Note currentNote = mDataset.get(position);

        holder.titleTv.setText(currentNote.getTitle());
        holder.descriptionTv.setText(currentNote.getDescription());


    }



    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}
