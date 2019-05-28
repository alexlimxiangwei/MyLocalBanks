package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    int btnPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);


    }

    // CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.button_menu, menu);
        btnPressed = v.getId();
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.websiteSelection) {
            //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            String url = "";
            if(btnPressed == R.id.btnDBS){
                url = getString(R.string.wwwDBS);
            }
            else if(btnPressed == R.id.btnOCBC){
                url = getString(R.string.wwwDBS);
            }
            else{
                url = getString(R.string.wwwDBS);
            }
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(url));
            startActivity(intent);

            return true; //menu item successfully handled
        }

        else if(id == R.id.callSelection) {
            String tel = "";
            if(btnPressed == R.id.btnDBS){
                tel = getString(R.string.numDBS);
            }
            else if(btnPressed == R.id.btnOCBC){
                tel = getString(R.string.numOCBC);
            }
            else{
                tel = getString(R.string.numDBS);
            }
            Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel:"+tel));
            startActivity(intent);
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    // MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if(id == R.id.englishSelection) {
            btnDBS.setText(getString(R.string.dbs));
            btnOCBC.setText(getString(R.string.ocbc));
            btnUOB.setText(getString(R.string.uob));

        }
        else if(id == R.id.chineseSelection) {
            btnDBS.setText(getString(R.string.chi_dbs));
            btnOCBC.setText(getString(R.string.chi_ocbc));
            btnUOB.setText(getString(R.string.chi_uob));
        }
        return super.onOptionsItemSelected(item);
    }
}
