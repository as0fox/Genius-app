package com.example.myapplication;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class  MainActivity6 extends AppCompatActivity {
    EditText search_view;
    TextView textView_word,textView_phonetic,recycler_Meanings,recycler_definitions;
    ImageButton imageButton_audio;




    Dictionary<String, String> dict = new Hashtable<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        search_view=findViewById(R.id.search_view);
        textView_word=findViewById(R.id.textView_word);
        textView_phonetic=findViewById(R.id.textView_phonetic);
        recycler_Meanings=findViewById(R.id.recycler_Meanings);
        recycler_definitions=findViewById(R.id.recycler_definitions);
        imageButton_audio=findViewById(R.id.imageButton_audio);

        dict.put("fox","A red fox, small carnivore (Vulpes vulpes), related to dogs and wolves, with red or silver fur and a bushy tail" );
        dict.put("foxAudio","https://api.dictionaryapi.dev/media/pronunciations/en/fox-us.mp3" );
        dict.put("foxPhonetic","fɒks" );
        dict.put("foxExample","Any of numerous species of small wild canids resembling the red fox" );
        dict.put("hello","A greeting (salutation) said when meeting someone or acknowledging someone’s arrival or presence" );
        dict.put("helloAudio","https://api.dictionaryapi.dev/media/pronunciations/en/hello-uk.mp3" );
        dict.put("helloPhonetic","həˈləʊ" );
        dict.put("helloExample","Hello! What’s going on here?" );
        dict.put("good","The forces or behaviours that are the enemy of evil. Usually consists of helping others and general benevolence." );
        dict.put("goodAudio","https://api.dictionaryapi.dev/media/pronunciations/en/good-uk.mp3" );
        dict.put("goodPhonetic","ɡʊ(d)" );
        dict.put("goodExample","The soup is good and hot." );
        dict.put("man","An adult male human" );
        dict.put("manAudio","https://api.dictionaryapi.dev/media/pronunciations/en/man-uk.mp3" );
        dict.put("manPhonetic","mæn" );
        dict.put("manExample","The show is especially popular with middle-aged men." );
        dict.put("bad","not good." );
        dict.put("badAudio","https://api.dictionaryapi.dev/media/pronunciations/en/bad-us.mp3" );
        dict.put("badPhonetic","bæːd" );
        dict.put("badExample","These apples have gone bad." );
        dict.put("apple","Any of various tree-borne fruits or vegetables especially considered as resembling an apple" );
        dict.put("appleAudio","https://api.dictionaryapi.dev/media/pronunciations/en/apple-uk.mp3" );
        dict.put("applePhonetic","ˈæp.əl" );
        dict.put("appleExample","Eat the apple." );
        dict.put("dog","Any member of the Family Canidae, including domestic dogs, wolves, coyotes, jackals, foxes, and their relatives (extant and extinct)" );
        dict.put("dogAudio","https://api.dictionaryapi.dev/media/pronunciations/en/dog-uk.mp3" );
        dict.put("dogPhonetic","dɑɡ" );
        dict.put("dogExample","The dog barked all night long." );
        dict.put("wolf","The gray wolf, specifically all subspecies of the gray wolf (Canis lupus) that are not dingoes or dogs." );
        dict.put("wolfAudio","https://api.dictionaryapi.dev/media/pronunciations/en/wolf-us.mp3" );
        dict.put("wolfPhonetic","wʊlf" );
        dict.put("wolfExample","They toiled hard to keep the wolf from the door." );
        dict.put("cow","An adult female of the species Bos taurus, especially one that has calved." );
        dict.put("cowAudio","https://api.dictionaryapi.dev/media/pronunciations/en/cow-uk.mp3" );
        dict.put("cowPhonetic","kaʊ" );
        dict.put("cowExample","Con artists are not cowed by the law." );
        dict.put("bag","A flexible container made of cloth, paper, plastic, etc." );
        dict.put("bagAudio","https://api.dictionaryapi.dev/media/pronunciations/en/bag-au.mp3" );
        dict.put("bagPhonetic","ˈbæːɡ" );
        dict.put("bagExample","Acid House is not my bag: I prefer the more traditional styles of music." );
        dict.put("night","The period between sunset and sunrise, when a location faces far away from the sun, thus when the sky is dark." );
        dict.put("nightAudio","https://api.dictionaryapi.dev/media/pronunciations/en/night-uk.mp3" );
        dict.put("nightPhonetic","naɪt" );
        dict.put("nightExample","I stayed my friend's house for three nights." );
        dict.put("cat","An animal of the family Felidae" );
        dict.put("catAudio","https://api.dictionaryapi.dev/media/pronunciations/en/cat-uk.mp3" );
        dict.put("catPhonetic","kat" );
        dict.put("catExample","The weather was cat, so they returned home early." );

        imageButton_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new MediaPlayer instance
                String url= dict.get(search_view.getText()+"Audio");

                MediaPlayer player = new MediaPlayer();
                try {
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(url);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }

    public void get(View view) {
        textView_word.setText("Word:"+search_view.getText().toString());
        textView_phonetic.setText(dict.get(search_view.getText().toString()+"Phonetic"));
        recycler_Meanings.setText(dict.get(search_view.getText().toString()));
        recycler_definitions.setText(dict.get(search_view.getText().toString()+"Example"));
//        recycler_Meanings.setBackgroundColor(Color.parseColor("#C60303"));
//        recycler_definitions.setBackgroundColor(Color.parseColor("#C60303"));


    }


}


