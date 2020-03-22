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


public class SettingActivity extends BaseActivity {
    private Locale locale;

    @BindView(R.id.rb_set_language)
    RadioGroup rbSetLanguage;
    @BindView(R.id.rb_en)
    RadioButton rbEn;
    @BindView(R.id.rb_id)
    RadioButton rbId;
    @BindView(R.id.btn_save_language)
    Button btnSaveLanguage;

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
            rbEn.setChecked(true);
            rbId.setChecked(false);
        } else if (bhasa.equals("id-ID")) {
            rbEn.setChecked(false);
            rbId.setChecked(true);
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

    public void setBahasa() {
        rbSetLanguage.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = group.findViewById(checkedId);
            if (rb != null) {
                switch (checkedId) {
                    case R.id.rb_en:
                        locale = new Locale("en");
                        rb.setChecked(true);
                        setLocaleLanguage(locale);
                        break;
                    case R.id.rb_id:
                        locale = new Locale("in");
                        setLocaleLanguage(locale);
                        break;
                    default:
                        locale = new Locale("en");
                        setLocaleLanguage(locale);
                }
            }
        });
    }

    public void btnSaveConfig() {
        btnSaveLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, MainActivity.class);
            SettingActivity.this.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        });
    }

    public void setLocaleLanguage(Locale localeLanguage) {
        DateConvert.setBhsData(localeLanguage.toString());
        Locale.setDefault(localeLanguage);
        Configuration configuration = new Configuration();
        configuration.setLocale(localeLanguage);
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

    }

}
