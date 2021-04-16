package com.example.csci370_lab_06.asyncs;

import android.os.AsyncTask;

import com.example.csci370_lab_06.database.LabDatabase;
import com.example.csci370_lab_06.entities.Person;

public class AddPersonAsync extends AsyncTask<Person, Void, Void> {
    private LabDatabase database;

    public AddPersonAsync(LabDatabase database) {
        this.database = database;
    }

    @Override
    protected Void doInBackground(Person... people) {

        database.personDao().insertPerson(people[0]);
        return null;
    }
}

