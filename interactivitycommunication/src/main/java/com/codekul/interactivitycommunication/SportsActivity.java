package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class SportsActivity extends AppCompatActivity {

    private StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            builder.append(bundle.getString("yoNm"));

            ((TextView) findViewById(R.id.txtCmp))
                    .setText(builder.toString());
        }

        ((CheckBox) findViewById(R.id.chAnd)).setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b) builder.append(",Android");
                        else delete(",Android");

                        ((TextView) findViewById(R.id.txtCmp))
                                .setText(builder.toString());
                    }
                }
        );
        ((CheckBox) findViewById(R.id.chAp)).setOnCheckedChangeListener(
                (cb, st) -> {
                    if(st) builder.append(",Apple");
                    else delete(",Apple");
                    ((TextView) findViewById(R.id.txtCmp))
                            .setText(builder.toString());
                }
        );
 (cb, st) -> {
                    if(st) builder.append(",Apple");
                    else delete(",Apple");
                    ((TextView) findViewById(R.id.txtCmp))
                            .setText(builder.toString());
                }
        ((CheckBox)findViewById(R.id.chWin)).setOnCheckedChangeListener(this::chkChg);
    }

    public void chkChg(CompoundButton cb, boolean st) {
        if(st) builder.append(",Windows");
        else delete(",Windows");
        ((TextView) findViewById(R.id.txtCmp))
                .setText(builder.toString());
    }

    private void delete( String s) {
        int start = builder.indexOf(s);
        if(start < 0)
            return;

        builder.delete(start, start + s.length());
    }

    public void onMain(View view) {

        Intent dt = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("opNm", builder.toString());
        dt.putExtras(bundle);
        setResult(RESULT_OK , dt);
        finish();
    }
}
