package ca.lokendra.scorekeeper

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    private lateinit var save : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val player1Name = findViewById<EditText>(R.id.player1_edittext).text.toString()
            val player2Name = findViewById<EditText>(R.id.player2_edittext).text.toString()
        }





    }
}
