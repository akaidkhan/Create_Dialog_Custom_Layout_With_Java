package com.akaidkhan.create_dialog_custom_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mShowAlertDialogBtn = findViewById(R.id.showAlertDialogBtn);
        mShowAlertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        LinearLayout mLayout         = new LinearLayout(this);
        TextView mTvMessage          = new TextView(this);
        final EditText mEtInput      = new EditText(this);

        mTvMessage.setText("Enter name:");
        mTvMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
        mEtInput.setSingleLine();
        mLayout.setOrientation(LinearLayout.VERTICAL);
        mLayout.addView(mTvMessage);
        mLayout.addView(mEtInput);
        mLayout.setPadding(50, 40, 50, 10);

        mBuilder.setView(mLayout);

        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = mEtInput.getText().toString();
                Toast.makeText(MainActivity.this, "Name entered: " + name, Toast.LENGTH_SHORT).show();
            }
        });

        mBuilder.create().show();
    }

}