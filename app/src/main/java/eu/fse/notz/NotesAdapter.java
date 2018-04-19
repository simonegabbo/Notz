package eu.fse.notz;

import android.content.ClipData;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amministratore on 12/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

    private ArrayList<Note> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTv;
        public TextView descriptionTv;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.title_Tv);
            descriptionTv = (TextView) itemView.findViewById(R.id.description_Tv);


        }
    }


    public NotesAdapter(ArrayList<Note> myDataset) {

        mDataset = myDataset;
    }

    public void addNote(Note note){
        mDataset.add(note);
        notifyDataSetChanged();
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
