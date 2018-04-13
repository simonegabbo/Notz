package eu.fse.notz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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


    }
}
