package com.espinoza.labactivity4_espinoza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    String[] api;
    String[] rDate;
    String[] info;
    String[] names;
    String[] version;

    int[] cLogo = {R.drawable.v1, R.drawable.cupcake, R.drawable.donut, R.drawable.eclair, R.drawable.froyo, R.drawable.gingerbread, R.drawable.honeycomb, R.drawable.icsandwich, R.drawable.jellybean, R.drawable.kitkat,
            R.drawable.lollipop, R.drawable.marshmallow, R.drawable.nougat, R.drawable.oreo, R.drawable.pie, R.drawable.ten};

    ArrayList<Android> androidList =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getResources().getStringArray(R.array.androidNames);
        version = getResources().getStringArray(R.array.androidVersions);
        api = getResources().getStringArray(R.array.androidAPI);
        rDate = getResources().getStringArray(R.array.androidRdate);
        info = getResources().getStringArray(R.array.info);
        list = findViewById(R.id.lvAndroids);

        for(int array = 0; array < names.length; array++){
            androidList.add(new Android(cLogo[array], names[array], version[array], api[array], rDate[array], info[array]));
        }

        list = findViewById(R.id.lvAndroids);
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getName());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage(androidList.get(i).getInfo());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                dialog.dismiss();
            }
        });
        dialog.create().show();

    }
}
