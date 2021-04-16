package com.example.csci370_lab_06.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.csci370_lab_06.dao.PersonDao;
import com.example.csci370_lab_06.entities.Person;


@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}

