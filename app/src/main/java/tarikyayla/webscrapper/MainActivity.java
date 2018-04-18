package tarikyayla.webscrapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;
import android.view.*;
import java.lang.Object;
import java.util.logging.*;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "tarikyayla.webscrapper";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spMangalist = (Spinner) findViewById(R.id.spMangalist);
        List<String> mangaList = new ArrayList<String>();
        mangaList.add("Naruto");mangaList.add("Bleach");mangaList.add("Fairy Tail"); mangaList.add("One Piece");
        final ArrayAdapter<String> adMangaList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mangaList);
        spMangalist.setAdapter(adMangaList);
        final ListView list1 = (ListView) findViewById(R.id.listView);
        final Button buttonleft = (Button) findViewById(R.id.btLeft);
        final Button buttonRight = (Button) findViewById(R.id.btRight);
        final Button buttonListele = (Button) findViewById(R.id.btListele);
        list1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        spMangalist.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spMangalistSecilen = adapterView.getSelectedItem().toString();
                Toast.makeText(getBaseContext(),"Seçilen manga : " + spMangalistSecilen,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
     public void mesajGonder(View view){
        Intent intent = new Intent(this, manga_oku.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String mesaj = "Açlan artık";
        intent.putExtra(EXTRA_MESSAGE, mesaj);
        startActivity(intent);
    }
}