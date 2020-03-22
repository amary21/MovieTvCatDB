package com.amary.app.data.moviecat.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.amary.app.data.moviecat.R;

import java.util.Locale;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class SettingActivity extends AppCompatActivity {
    private Locale locale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.action_settings);

        RadioGroup rbSetBahasa = findViewById(R.id.rg_setbahasa);
        rbSetBahasa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (rb !=null){
                    switch (checkedId){
                        case R.id.rb_english:
                            locale = new Locale("en");
                            rb.setChecked(true);
                            setLocale();
                            break;
                        case R.id.rb_indonesia:
                            locale = new Locale("in");
                            setLocale();
                            break;
                        default:
                            locale = new Locale("en");
                            setLocale();
                    }
                }
            }
        });

        Button btnSaveLeanguage = findViewById(R.id.btn_save_language);
        btnSaveLeanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocale() {

        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    }
}
