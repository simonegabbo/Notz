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

public class NotesAdapter extends RecyclerView.Adapter {

    private ArrayList<Note> mDataset;
    private Context context;
    private Note note;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView titleTv;
        public TextView descriptionTv;


        public ViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.title_tv);
            descriptionTv = (TextView) itemView.findViewById(R.id.description_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO fai cose
                    Intent intent = new Intent(context, NoteActivity.class);

                    String title = mDataset.get(getAdapterPosition()).getTitle();
                    String description = mDataset.get(getAdapterPosition()).getDescription();

                    intent.putExtra("title", title);
                    intent.putExtra("description", description);
                    intent.putExtra("position", getAdapterPosition());

                    ((MainActivity) context).startActivityForResult(intent, 1001);


                }
            });

        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NotesAdapter(ArrayList<Note> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    public Note getNote(int index) {
        return mDataset.get(index);
    }


    public void updateNote(int index, Note note) {
        mDataset.set(index, note);
        notifyItemChanged(index);
    }

    public void removeNote(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    public void addNote(int index, Note note) {
        mDataset.add(index, note);
        notifyItemInserted(index);

    }


    public void updateNote(int index, String title, String description) {

        Note note = mDataset.get(index);

        note.setTitle(title);
        note.setDescription(description);
        notifyItemChanged(index);


    }


    public void addNote(Note note) {
        this.mDataset.add(0, note);
        notifyItemInserted(0);

    }

    // Create new views (invoked by the layout manager)

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_note, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        NotesAdapter.ViewHolder noteVH = (NotesAdapter.ViewHolder) holder;
        Note currentNote = mDataset.get(position);

        // Data binding
        noteVH.titleTv.setText(currentNote.getTitle());
        noteVH.descriptionTv.setText(currentNote.getDescription());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

























/*

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{

    private ArrayList<Note> mDataset;
    public Context context;

    public Note getNote(int index) {
        return mDataset.get(index);
    }

    public void updateNote(int index, Note note) {
        mDataset.set(index, note);
        notifyItemChanged(index);
    }


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
                    ((MainActivity)context).startActivityForResult(intent,MainActivity.EDIT_REQUEST);

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
}*/
