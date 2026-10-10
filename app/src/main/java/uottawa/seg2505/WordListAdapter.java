package uottawa.seg2505;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter
        extends ListAdapter<Word, WordListAdapter.WordViewHolder> {

    // Constructeur
    public WordListAdapter() {
        super(WORD_COMPARATOR);
    }

    // Création d'un élément visuel
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.recyclerview_item,
                        parent,
                        false
                );

        return new WordViewHolder(itemView);
    }

    // Affichage du mot à une position donnée
    @Override
    public void onBindViewHolder(
            @NonNull WordViewHolder holder,
            int position) {

        Word current = getItem(position);

        holder.wordItemView.setText(current.getWord());
    }

    // Classe représentant une ligne de la liste
    static class WordViewHolder
            extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {

            super(itemView);

            wordItemView =
                    itemView.findViewById(R.id.word_text);
        }
    }

    // Comparaison des éléments pour actualiser la liste
    private static final DiffUtil.ItemCallback<Word>
            WORD_COMPARATOR =
            new DiffUtil.ItemCallback<Word>() {

                @Override
                public boolean areItemsTheSame(
                        @NonNull Word oldItem,
                        @NonNull Word newItem) {

                    return oldItem.getWord()
                            .equals(newItem.getWord());
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull Word oldItem,
                        @NonNull Word newItem) {

                    return oldItem.getWord()
                            .equals(newItem.getWord());
                }
            };
}
