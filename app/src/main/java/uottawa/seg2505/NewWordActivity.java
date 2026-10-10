package uottawa.seg2505;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewWordActivity extends AppCompatActivity {

    // Identifiant utilisé pour retourner le mot saisi
    public static final String EXTRA_REPLY =
            "uottawa.seg2505.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Charger l'interface XML
        setContentView(R.layout.activity_new_word);

        // Récupérer les composants graphiques
        EditText editWord =
                findViewById(R.id.edit_word);

        Button buttonSave =
                findViewById(R.id.button_save);

        // Événement déclenché lorsque l'utilisateur clique
        // sur le bouton Enregistrer
        buttonSave.setOnClickListener(view -> {

            String word =
                    editWord.getText().toString().trim();

            // Vérifier que l'utilisateur a saisi un mot
            if (word.isEmpty()) {

                editWord.setError(
                        "Veuillez saisir un mot"
                );

                editWord.requestFocus();

                return;
            }

            // Préparer le résultat
            Intent replyIntent = new Intent();

            replyIntent.putExtra(EXTRA_REPLY, word);

            // Indiquer que la saisie a réussi
            setResult(Activity.RESULT_OK, replyIntent);

            // Fermer cette activité
            finish();
        });
    }
}
