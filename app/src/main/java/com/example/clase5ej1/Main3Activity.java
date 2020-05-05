package com.example.clase5ej1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity {

    private ActionMode mActionMode;

    class ActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.menu_contextual_app_bar, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.edit:
                    Toast.makeText(Main3Activity.this, "edit BTN", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.share:
                    Toast.makeText(Main3Activity.this, "share BTN", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.conMenE1:
                Log.d("msgC", "elemento 1");
                return true;
            case R.id.conMenE2:
                Log.d("msgC", "elemento 2");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView textView2 = findViewById(R.id.textView2);
        registerForContextMenu(textView2);

        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode == null){
                    mActionMode = Main3Activity.this.startActionMode(new ActionModeCallback());
                    v.setSelected(true);
                    return true;
                }else{
                    return false;
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemAppBar:
                Toast.makeText(this, "item btn", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void accionLikeAppBar(MenuItem item) {
        //Intent i = new Intent(this, Main2Activity.class);
        //startActivity(i);

        View menuView = findViewById(item.getItemId());

        PopupMenu popupMenu =new PopupMenu(this,menuView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.reply:
                        Toast.makeText(Main3Activity.this, "btn reply", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.replayall:
                        Toast.makeText(Main3Activity.this, "btn replyall", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.forward:
                        Toast.makeText(Main3Activity.this, "btn forward", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();

    }

    public void abrirDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Términos y Condiciones");
        dialog.setMessage("Estos son los TyC ");
        dialog.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Main3Activity.this, "TYC aceptados", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("NO ACEPTO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Main3Activity.this, "TYC NO aceptados", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }


}
