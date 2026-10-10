package uottawa.seg2505;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {Word.class},
        version = 1,
        exportSchema = false
)
public abstract class WordRoomDatabase extends RoomDatabase {

    // Accès aux opérations de la base de données
    public abstract WordDao wordDao();

    // Instance unique de la base de données
    private static volatile WordRoomDatabase INSTANCE;

    // Retourne l'instance de la base de données
    public static WordRoomDatabase getDatabase(
            @NonNull final Context context) {

        if (INSTANCE == null) {

            synchronized (WordRoomDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordRoomDatabase.class,
                            "word_database"
                    ).build();
                }
            }
        }

        return INSTANCE;
    }
}