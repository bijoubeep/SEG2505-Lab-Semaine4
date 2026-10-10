package uottawa.seg2505;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordRepository {

    // Interface permettant de communiquer avec Room
    private final WordDao wordDao;

    // Liste observable des mots enregistrés
    private final LiveData<List<Word>> allWords;

    // Thread dédié aux opérations d'écriture
    private static final ExecutorService databaseWriteExecutor =
            Executors.newSingleThreadExecutor();

    // Constructeur
    public WordRepository(Application application) {

        WordRoomDatabase db =
                WordRoomDatabase.getDatabase(application);

        wordDao = db.wordDao();

        allWords = wordDao.getAlphabetizedWords();
    }

    // Retourner tous les mots
    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    // Insérer un nouveau mot
    public void insert(Word word) {

        databaseWriteExecutor.execute(() -> {
            wordDao.insert(word);
        });
    }

    // Supprimer tous les mots
    public void deleteAll() {

        databaseWriteExecutor.execute(() -> {
            wordDao.deleteAll();
        });
    }
}