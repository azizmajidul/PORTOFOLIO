package com.stmikbanisaleh.smart_md;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.stmikbanisaleh.smart_md.Model_Ok.Login.PreferenceManager;
import com.stmikbanisaleh.smart_md.Ui.History.Coba;
import com.stmikbanisaleh.smart_md.Ui.History.History;
import com.stmikbanisaleh.smart_md.Ui.StoreList;
import com.stmikbanisaleh.smart_md.Ui.Store_visit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView audit_card, profil_card, schedule_card, history_card;
    private TextView name;
    private PreferenceManager preferenceManager;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find card by id
        audit_card = (CardView) findViewById(R.id.audit_card);
        history_card = (CardView) findViewById(R.id.dashborad_card);
//        profil_card = (CardView) findViewById(R.id.profil_card);
        schedule_card = (CardView) findViewById(R.id.schedule_card);

        //add on click
        audit_card.setOnClickListener(this);
        history_card.setOnClickListener(this);
//        profil_card.setOnClickListener(this);
        schedule_card.setOnClickListener(this);

        preferenceManager = new PreferenceManager(this);
        name = findViewById(R.id.textjudul);
        String nama = preferenceManager.getEmail().toString();
        String pecahemail = nama.substring(0,5);
        String coba = nama.replace("@gmail.com", " !");

        name.setText("Hai " + coba);

        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                preferenceManager.logoutUser();
            }
        });
    }
    private  void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Are you sure to exit from this Application?")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {dialog.dismiss();

                    }
                })
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                });
        AlertDialog dialog= builder.create();
        dialog.show();

    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.audit_card : i = new Intent(this, StoreList.class);startActivity(i); break;
            case R.id.dashborad_card : i = new Intent(this, History.class); startActivity(i);break;
            case R.id.schedule_card : i = new Intent(this, Store_visit.class); startActivity(i);break;
            default:break;
        }
    }
}