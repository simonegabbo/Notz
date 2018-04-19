package eu.fse.notz;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NotesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton addNoteButton;

   // private String[] myDataset = {"nota 1"," nota 2", "fai la spesa", "paga bolletta luca", "dadsadasa", "dsasdasd", "dassad"};
    private ArrayList<Note> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.notes_rv);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        addNoteButton = findViewById(R.id.add_note_fab);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = new ArrayList<>();

        Note pinPalazzo = new Note("PIN","12345");
        myDataset.add(pinPalazzo);

        Note spesa = new Note("Spesa","comprare il latte");
        myDataset.add(spesa);

        // specify an adapter (see also next example)
        mAdapter = new NotesAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);


        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               showDialog();

            }
        });

    }





    private void showDialog(){

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setView(R.layout.dialog_add_note);
        alertBuilder.setTitle(R.string.dialog_add_note_title);

        alertBuilder.setPositiveButton(R.string.dialog_positive_button,
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
                Note note = new Note("Titolo della nota",
                        "contenuto nota dsaasd");
                mAdapter.addNote(note);

            }
        });

        alertBuilder.setNegativeButton(R.string.dialog_negative_button,
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
            }
        });

        alertBuilder.show();


    }


}
