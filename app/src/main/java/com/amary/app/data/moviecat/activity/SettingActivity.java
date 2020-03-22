package com.amary.app.data.moviecat.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.amary.app.data.moviecat.R;
import com.amary.app.data.moviecat.base.BaseActivity;
import com.amary.app.data.moviecat.utils.DateConvert;

import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("deprecation")
public class SettingActivity extends BaseActivity {
    private Locale locale;

    @BindView(R.id.rg_setbahasa)
    RadioGroup rbSetBahasa;
    @BindView(R.id.rb_english)
    RadioButton rbEnglish;
    @BindView(R.id.rb_indonesia)
    RadioButton rbIndonesia;
    @BindView(R.id.btn_save_language)
    Button btnSaveLeanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        String bhasa = getString(R.string.localization);
        ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.action_settings);


        if (bhasa.equals("en-US")) {
            rbEnglish.setChecked(true);
            rbIndonesia.setChecked(false);
        }else if (bhasa.equals("id-ID")){
            rbEnglish.setChecked(false);
            rbIndonesia.setChecked(true);
        }

        setBahasa();
        btnSaveConfig();

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

    public void setBahasa(){
        rbSetBahasa.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = group.findViewById(checkedId);
            if (rb != null) {
                switch (checkedId) {
                    case R.id.rb_english:
                        locale = new Locale("en");
                        rb.setChecked(true);
                        SettingActivity.this.setLocale();
                        break;
                    case R.id.rb_indonesia:
                        locale = new Locale("in");
                        SettingActivity.this.setLocale();
                        break;
                    default:
                        locale = new Locale("en");
                        SettingActivity.this.setLocale();
                }
            }
        });
    }

    public void btnSaveConfig(){
        btnSaveLeanguage.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, MainActivity.class);
            SettingActivity.this.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        });
    }

    public void setLocale() {
        DateConvert.setBhsData(locale.toString());
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

    }

}
