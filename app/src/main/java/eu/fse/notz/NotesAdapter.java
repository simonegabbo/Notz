package eu.fse.notz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amine on 12/04/18.
 */

public class NotesAdapter extends RecyclerView.Adapter {

    private ArrayList<Note> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NotesAdapter(ArrayList<Note> myDataset){
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_note, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        NotesAdapter.ViewHolder  noteVH = (NotesAdapter.ViewHolder)holder;
        Note currentNote = mDataset.get(position);
        noteVH.mTextView.setText(currentNote.getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
