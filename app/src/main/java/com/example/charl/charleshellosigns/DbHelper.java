package com.example.charl.charleshellosigns;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "chiffres1";
    private static final String TABLE_QUEST2 = "chiffres2";
    private static final String TABLE_QUEST3 = "heure";
    private static final String TABLE_QUEST4 = "famille";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        String sq2 = "CREATE TABLE " + TABLE_QUEST2 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        String sq3 = "CREATE TABLE " + TABLE_QUEST3 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        String sq4 = "CREATE TABLE " + TABLE_QUEST4 + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";

        db.execSQL(sql);
        db.execSQL(sq2);
        db.execSQL(sq3);
        db.execSQL(sq4);

        addQuestions();
        addQuestions2();
        addQuestions3();
        addQuestions4();
    }

    private void addQuestions()
    {
        Question q1=new Question("Quel est le signe pour" +
                " le chiffre 1","Signe 1", "Signe 5", "Signe 10", "Signe 1");
        this.addQuestion(q1);
        Question q2=new Question("Quel est le signe pour" +
                " le chiffre 3","Signe 7", "Signe 2", "Signe 3", "Signe 3");
        this.addQuestion(q2);
        Question q3=new Question("Quel est le signe pour" +
                " le chiffre 7","Signe 4", "Signe 7", "Signe 6", "Signe 7");
        this.addQuestion(q3);
        Question q4=new Question("Quel est le signe pour" +
                " le chiffre 9","Signe 9", "Signe 8", "Signe 4", "Signe 9");
        this.addQuestion(q4);
        Question q5=new Question("Quel est le signe pour" +
                " le nombre 10","Signe 10", "Signe 8", "Signe 5", "Signe 10");
        this.addQuestion(q5);
    }

    private void addQuestions2()
    {
        Question q1=new Question("Quel est le signe pour" +
                " le nombre 11","Signe 12", "Signe 11", "Signe 13", "Signe 11");
        this.addQuestion2(q1);
        Question q2=new Question("Quel est le signe pour" +
                " le nombre 14","Signe 15", "Signe 13", "Signe 14", "Signe 14");
        this.addQuestion2(q2);
        Question q3=new Question("Quel est le signe pour" +
                " le nombre 16","Signe 12", "Signe 17", "Signe 16", "Signe 16");
        this.addQuestion2(q3);
        Question q4=new Question("Quel est le signe pour" +
                " le nombre 18","Signe 18", "Signe 20", "Signe 19", "Signe 18");
        this.addQuestion2(q4);
        Question q5=new Question("Quel est le signe pour" +
                " le nombre 20","Signe 10", "Signe 15", "Signe 20", "Signe 20");
        this.addQuestion2(q5);
    }
    private void addQuestions3()
    {
        Question q1=new Question("Quel est le signe pour" +
                " dire 4h","Signe 2h15", "Signe 9h", "Signe 4h", "Signe 4h");
        this.addQuestion3(q1);
        Question q2=new Question("Quel est le signe pour" +
                " dire 9h","Signe 20h", "Signe 4h", "Signe 9h", "Signe 9h");
        this.addQuestion3(q2);
        Question q3=new Question("Quel est le signe pour" +
                " dire 4h45","Signe 4h", "Signe 4h45", "Signe 3h10", "Signe 4h45");
        this.addQuestion3(q3);
        Question q4=new Question("Quel est le signe pour" +
                " dire 3h10","Signe 3h10", "Signe 2h15", "Signe 20h", "Signe 3h10");
        this.addQuestion3(q4);
        Question q5=new Question("Quel est le signe pour" +
                " dire 20h","Signe 2h15", "Signe 20h", "Signe 4h45", "Signe 20h");
        this.addQuestion3(q5);
    }
    private void addQuestions4()
    {
        Question q1=new Question("Quel est le signe pour" +
                " dire famille","Signe famille", "Signe grandpere", "Signe papa", "Signe famille");
        this.addQuestion4(q1);
        Question q2=new Question("Quel est le signe pour" +
                " dire maman","Signe soeur", "Signe maman", "Signe tante", "Signe maman");
        this.addQuestion4(q2);
        Question q3=new Question("Quel est le signe pour" +
                " dire frere","Signe frere", "Signe soeur", "Signe oncle", "Signe frere");
        this.addQuestion4(q3);
        Question q4=new Question("Quel est le signe pour" +
                " dire tante","Signe grandmere", "Signe grandpere", "Signe tante", "Signe tante");
        this.addQuestion4(q4);
        Question q5=new Question("Quel est le signe pour" +
                " dire fils","Signe fille", "Signe fils", "Signe papa", "Signe fils");
        this.addQuestion4(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST4);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public void addQuestion2(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST2, null, values);
    }
    public void addQuestion3(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST3, null, values);
    }
    public void addQuestion4(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST4, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllQuestions2() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST2;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllQuestions3() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST3;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public List<Question> getAllQuestions4() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST4;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

}
