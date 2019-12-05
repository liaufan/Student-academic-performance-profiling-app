package com.example.hackaton.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.hackaton.Model.Member;
import com.example.hackaton.Model.Question;
import com.example.hackaton.Model.Score;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME = "Educate.db";
    private static final int DB_VER = 2;

    public Database(Context context){
        super(context, DB_NAME,null, DB_VER);
    }


    public void addScore(Score score){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO Score(Id, Score, startYear, startMonth, startDay,endYear,endMonth,endDay,duration,feedback) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s');",
                score.getId(),
                score.getScore(),
                score.getStartYear(),
                score.getStartMonth(),
                score.getStartDay(),
                score.getEndYear(),
                score.getEndMonth(),
                score.getEndDay(),
                score.getDuration(),
                score.getFeedback());

        db.execSQL(query);

    }



    public List<Question> getQuestions(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Id","Description", "Option1", "Option2", "Option3", "Answer","SubjectId"};
        String sqlTable = "Question";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);

        final List<Question> result = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                result.add(new Question(c.getInt(c.getColumnIndex("Id")),
                        c.getString(c.getColumnIndex("Description")),
                        c.getString(c.getColumnIndex("Option1")),
                        c.getString(c.getColumnIndex("Option2")),
                        c.getString(c.getColumnIndex("Option3")),
                        c.getString(c.getColumnIndex("Answer")),
                                c.getInt(c.getColumnIndex("SubjectId"))
                ));
            }while (c.moveToNext());
        }
        return result;
    }

    public void addMemberSubject(String memberUsername,int subjectId,String status,int attempt){
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO MemberSubject(MemberUsername, SubjectId, Status, Attempt) VALUES('%s','%s','%s','%s');",
                memberUsername,
               subjectId,
                status,
                attempt
                );

        db.execSQL(query);
    }




    public void addMember(Member newMember){
        SQLiteDatabase db = getReadableDatabase();
        String query = "INSERT INTO Member\n" +
                "(Username, Password, Name, Grade, Status,Email) \n" +
                "VALUES (\""+newMember.getUsername()+"\", \""+newMember.getPassword()+"\", \""+newMember.getName()+"\",\""+newMember.getGrade()+"\",\"1\",\""+newMember.getEmail()+"\");";
        /*
        String query = String.format("INSERT INTO Member(Username, Password, Name, Grade, Status,Email,Star) VALUES('%s','%s','%s','%s','%s','%s','%s');",
                newMember.getUsername(),
                newMember.getPassword(),
                newMember.getName(),
                newMember.getGrade(),
                newMember.getStatus(),
                newMember.getEmail(),
                newMember.getStar());
*/
        db.execSQL(query);
    }

    public boolean isAuthenticated(String username, String password){
        SQLiteDatabase db=getReadableDatabase();
        //String query=String.format("SELECT * FROM Member Where Username = '%s' AND Password = '%s'",username,password );
        //String query=String.format("SELECT * FROM Member where Username ='%s';",username);
        String query = "select * from Member where Username = \""+username+"\" and Password = \""+password+"\";";
        //String query = "select *from Member where username = \"1\";";
        Cursor cursor=db.rawQuery(query,null);
        Log.d("Test Authentication",username+"/"+password+"/"+cursor.getCount()+"/"+query);
        if (cursor.getCount()<=0){
            cursor.close();
            return false;

        }
        cursor.close();
        return true;

    }

    public int getGrade(String username){
        SQLiteDatabase db = getReadableDatabase();
        String query = "select Grade from Member where Username =\""+username+"\";";
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getInt(0);
    }

}
