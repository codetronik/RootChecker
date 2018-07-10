package codetronik.rootchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckRootingButtonClick(View v) {
        RootChecker rc = new RootChecker();
        boolean bRooting1 = rc.execute_su();
        String su = rc.check_su_files();
/*
        if (bRooting1 || bRooting2) {
            Toast.makeText(getApplicationContext(), "ROOT!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "no Root~", Toast.LENGTH_LONG).show();
        }
        */
        TextView text = (TextView)findViewById(R.id.textView);
        TextView text2 = (TextView)findViewById(R.id.textView2);
        if (bRooting1) {
            text.setText("check execute su : YES");
        }
        else
        {
            text.setText("check execute su : NO");
        }


        text2.setText("check existing su file : " + su);


    }
}
