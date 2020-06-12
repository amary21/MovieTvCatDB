package com.amary.app.data.moviecat.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.amary.app.data.moviecat.R
import java.util.*

class SettingActivity : AppCompatActivity() {
    private var locale: Locale? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle(R.string.action_settings)

        val rbSetBahasa = findViewById<RadioGroup>(R.id.rg_setbahasa)
        rbSetBahasa.setOnCheckedChangeListener { group, checkedId ->
            val rb = group.findViewById<RadioButton>(checkedId)
            if (rb != null) {
                when (checkedId) {
                    R.id.rb_english -> {
                        locale = Locale("en")
                        rb.isChecked = true
                        setLocale()
                    }
                    R.id.rb_indonesia -> {
                        locale = Locale("in")
                        setLocale()
                    }
                    else -> {
                        locale = Locale("en")
                        setLocale()
                    }
                }
            }
        }

        val btnSaveLeanguage = findViewById<Button>(R.id.btn_save_language)
        btnSaveLeanguage.setOnClickListener {
            val intent = Intent(this@SettingActivity, MainActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setLocale() {
        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
    }
}