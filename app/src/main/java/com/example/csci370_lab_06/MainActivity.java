package com.example.csci370_lab_06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.csci370_lab_06.asyncs.AddPersonAsync;
import com.example.csci370_lab_06.asyncs.GetAllPersonsAsync;
import com.example.csci370_lab_06.database.LabDatabase;
import com.example.csci370_lab_06.entities.Person;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "Name";
    private static LabDatabase labDB;
    private static Button addBtn;
    private static Button listBtn;
    private static EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME).build();

        addBtn = findViewById(R.id.add_person_button);
        listBtn = findViewById(R.id.get_all_persons_button);
        editText = findViewById(R.id.editText);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AddPersonAsync addPersonAsync = new AddPersonAsync(labDB);

                Person person = new Person();
                person.setName(editText.getText().toString());
                addPersonAsync.execute(person);

                editText.setText("");
            }
        });

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final GetAllPersonsAsync getAllPersonsAsync = new GetAllPersonsAsync(labDB, getApplicationContext());
                getAllPersonsAsync.execute();




            }
        });
    }
}