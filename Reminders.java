import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.data.Task;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;
import java.content.ContentValues;
import java.content.Context;
import java.util.Log;
import javax.swing.JDialog;
import javax.swing.Timer;
import org.apache.log4j.Logger;
public class Reminders {
    private static Logger logger=Logger.getLogger(Reminder.class);
    private final static long MIN_TO_MILLISEC = 1000*60;
    public static long timeleft;
    public static long delay = 5* MIN_TO_MILLISEC;
    public static Task task;
    public static Timer timer;
    public static ActionListener reminderPerformer; 
public static void init(){
    reminderPerformer = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(task.getImportant()}{
                new Reminder(task);
              }
            else{
              UIController.getMsg(task.getName()+”is starting”+task.getStart().formattedToString());
             }
          Task=null;
RunReminder();
}
    
public long createReminder(String title, String body, String reminderDateTime) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_BODY, body);
        initialValues.put(KEY_DATE_TIME, reminderDateTime); 
        return mDb.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteReminder(long rowId) {
        return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    public Cursor fetchAllReminders() {
        return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TITLE,
                KEY_BODY, KEY_DATE_TIME}, null, null, null, null, null);
    }
    public Cursor fetchReminder(long rowId) throws SQLException {
        Cursor mCursor = mDb.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,KEY_TITLE, KEY_BODY, KEY_DATE_TIME}, KEY_ROWID + "=" + rowId, null,null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateReminder(long rowId, String title, String body, String reminderDateTime) {
        ContentValues args = new ContentValues();
        args.put(KEY_TITLE, title);
        args.put(KEY_BODY, body);
        args.put(KEY_DATE_TIME, reminderDateTime);
        return mDb.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0; }};
