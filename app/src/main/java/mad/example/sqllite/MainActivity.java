package mad.example.sqllite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText input1, input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);


    }


    public void SaveUser(View view) {
        DbHelper dbHelper = new DbHelper(this);
        String Username = input1.getText().toString();
        String Password = input2.getText().toString();

        if (Username.isEmpty() || Password.isEmpty()) {


            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();

        } else {
            long inserted = dbHelper.AddInfo(Username, Password);
            if (inserted > 0) {


                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();


            }

        }


    }


    public void ViewAll(View view) {
        DbHelper dbHelper = new DbHelper(this);

        List info = dbHelper.ReadAll();

        String[] Listarray = (String[]) info.toArray(new String[0]);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("USER DETAILS");

        builder.setItems(Listarray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String Username = Listarray[which].split(":")[0];
                input1.setText(Username);
                input2.setText("******");
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();


    }


    public void deleteInfo(View view) {
        DbHelper dbHelper = new DbHelper(this);

        String Username = input1.getText().toString();

        if (Username.isEmpty()) {


            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();

        } else {
            dbHelper.deleteInfo(Username);
            Toast.makeText(this, Username + " Is Deleted ", Toast.LENGTH_SHORT).show();

        }


    }


    public void updateInfo(View view) {


        DbHelper dbHelper = new DbHelper(this);
        String Username = input1.getText().toString();
        String Password = input2.getText().toString();

        if (Username.isEmpty() || Password.isEmpty()) {


            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();

        } else {
            dbHelper.UpdateInfo(view, Username, Password);
        }


    }
}



