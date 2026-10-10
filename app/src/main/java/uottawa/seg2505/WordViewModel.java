package uottawa.seg2505;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    // Référence au Repository
    private final WordRepository repository;

    // Liste des mots
    private final LiveData<List<Word>> allWords;

    // Constructeur
    public WordViewModel(@NonNull Application application) {

        super(application);

        repository = new WordRepository(application);

        allWords = repository.getAllWords();
    }

    // Obtenir les mots enregistrés
    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    // Insérer un mot
    public void insert(Word word) {
        repository.insert(word);
    }

    // Supprimer tous les mots
    public void deleteAll() {
        repository.deleteAll();
    }
}
