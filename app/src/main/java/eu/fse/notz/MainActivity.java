package eu.fse.notz;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Amministratore on 12/04/2018.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NotesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //private String[] myDataset = {"nota 1","ciao"};
    private ArrayList<Note> myDataset;
    FloatingActionButton addNote;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.note_rv);


        addNote = (FloatingActionButton) findViewById(R.id.add_note);


        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = new ArrayList<>();

        /*Note Spesa = new Note("Spesa", "acqua, laffuyfuyfyffuyuyuyfutte");
        myDataset.add(Spesa);

        Note pinPalazzo = new Note("PIN", "123456");
        myDataset.add(pinPalazzo);

        Note newPin = new Note("PIN", "12345vhfvuyfyvuyfuyfuyfguyfuy6");
        myDataset.add(newPin);

        Note pin = new Note("PIN", "123456");
        myDataset.add(pin);*/

        mAdapter = new NotesAdapter(myDataset, this);
        mRecyclerView.setAdapter(mAdapter);

        addNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                showDialog();
            }
        });
    }



    private void showDialog(){




        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_new, null);

        alertBuilder.setView(dialogView);

        final EditText titleEt = (EditText) dialogView.findViewById(R.id.new_title);
        final EditText descriptionEt = (EditText) dialogView.findViewById(R.id.new_description);

        alertBuilder.setPositiveButton(R.string.dialog_positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String insertTitle= titleEt.getText().toString();
                String insertDescription= descriptionEt.getText().toString();

                Note note = new Note(insertTitle, insertDescription);
                mAdapter.addNote(note);
            }
        });

        alertBuilder.setNegativeButton(R.string.dialog_negativ_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertBuilder.show();
    }

}
