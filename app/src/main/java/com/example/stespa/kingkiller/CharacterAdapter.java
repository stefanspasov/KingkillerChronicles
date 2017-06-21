package com.example.stespa.kingkiller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * Created by stespa on 2017-06-21.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterAdapterViewHolder> {

    private final CharacterAdapterOnClickHandler mClickHandler;
    private String[] mCharacterNames;

    public interface CharacterAdapterOnClickHandler {
        void onClick(String characterName);
    }


    public CharacterAdapter(CharacterAdapterOnClickHandler clickHandler)
    {
        mClickHandler = clickHandler;
    }



    public class CharacterAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mCharacterNameTextView;



        public CharacterAdapterViewHolder(View view)
        {
            super(view);
            mCharacterNameTextView = (TextView)view.findViewById(R.id.tv_character_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String characterName = mCharacterNames[adapterPosition];
            mClickHandler.onClick(characterName);
        }
    }

    @Override
    public CharacterAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.character_list_item, parent, false);
        return new CharacterAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharacterAdapterViewHolder holder, int position) {
        String characterName = mCharacterNames[position];
        holder.mCharacterNameTextView.setText(characterName);
    }

    @Override
    public int getItemCount() {
        if(null == mCharacterNames) return 0;
        return mCharacterNames.length;
    }

    public void setCharacterData(String[] characterData)
    {
        mCharacterNames = characterData;
        notifyDataSetChanged();
    }
}
