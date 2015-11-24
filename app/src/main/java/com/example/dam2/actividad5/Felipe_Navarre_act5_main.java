package com.example.dam2.actividad5;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class Felipe_Navarre_act5_main extends Activity {
    Resources res;
    ListView lv;
    String lista[];
    String selectedWord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felipe__navarre_act5_main);
        res=getApplicationContext().getResources();
        lista= res.getStringArray(R.array.nombres);
        lv=(ListView)findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
        registerForContextMenu(lv);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;
        selectedWord = ((TextView) info.targetView).getText().toString();

        menu.setHeaderTitle(selectedWord);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                Toast.makeText(this, "Has pulsado la opción mostrar", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Has pulsado la opción eliminar", Toast.LENGTH_SHORT).show();
                return true;

        }



        return super.onOptionsItemSelected(item);
    }
}
