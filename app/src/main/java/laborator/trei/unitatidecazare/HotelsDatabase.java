package laborator.trei.unitatidecazare;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {HotelTable.class}, version = 2, exportSchema = false)
public abstract class HotelsDatabase  extends RoomDatabase {

    // create database instance

    private static HotelsDatabase database;
    private static String DATABASE_NAME = "database";

    static public HotelsDatabase getDatabase() {
        return database;
    }
    public synchronized static HotelsDatabase getInstance(Context context)
    {
        if(database == null)
        {
            // init database
            database = Room.databaseBuilder(context.getApplicationContext(), HotelsDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    // create Dao
    public abstract HotelDao hotelDao();
}
