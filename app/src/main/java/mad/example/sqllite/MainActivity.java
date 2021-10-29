package mad.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mad.example.sqllite.database.DBHelper;

public class MainActivity extends AppCompatActivity {
    EditText editname,editpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname =findViewById(R.id.editname);
        editpassword =findViewById(R.id.editpassword);
    }

    public void saveUser(View view){
        String name= editname.getText().toString();
        String password = editpassword.getText().toString();
        DBHelper dbHelper =new DBHelper(this);

        if (name.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"enter the values",Toast.LENGTH_LONG).show();
        }
        else {
            long inserted = dbHelper.addInfo(name,password);
        if (inserted >0){
            Toast.makeText(this," data inserted sucessful",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"somthig went wrong",Toast.LENGTH_LONG).show();
        }
        }

    }
}