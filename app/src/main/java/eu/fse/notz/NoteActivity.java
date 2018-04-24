package eu.fse.notz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Amministratore on 12/04/2018.
 */

public class NoteActivity extends AppCompatActivity {

    EditText titleEt;
    EditText descriptionEt;
    Button editConfirmBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        titleEt = (EditText) findViewById(R.id.titleEdit);
        descriptionEt = (EditText) findViewById(R.id.descriptionEdit);
        editConfirmBtn = (Button) findViewById(R.id.edit_confirm);



        final Intent intent = getIntent();

        String title = intent.getStringExtra("titleTv");
        titleEt.setText(title);

        String description = intent.getStringExtra("descriptionTv");
        descriptionEt.setText(description);

        editConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTitle = titleEt.getText().toString();
                String editDescription = descriptionEt.getText().toString();
                int position = intent.getIntExtra("position", -1);


                Intent finishIntent = new Intent();
                finishIntent.putExtra("titleEt",editTitle);
                finishIntent.putExtra("descriptionEt",editDescription);
                finishIntent.putExtra("position",position);
                setResult(Activity.RESULT_OK,finishIntent);

                finish();
            }
        });


    }
}
