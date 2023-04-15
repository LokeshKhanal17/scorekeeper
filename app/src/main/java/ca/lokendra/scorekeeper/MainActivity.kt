package ca.lokendra.scorekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var scoreTeamA = 0
    private var scoreTeamB = 0
    private lateinit var player1Switch: Switch
    private lateinit var player2Switch: Switch
    private lateinit var scoreTextView1: TextView
    private lateinit var scoreTextView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val increase = findViewById<Button>(R.id.button1)
        val decrease = findViewById<Button>(R.id.button2)
        player1Switch = findViewById(R.id.player1_switch)
        player2Switch = findViewById(R.id.player2_switch)
        scoreTextView1 = findViewById(R.id.scoreTeamA)
        scoreTextView2 = findViewById(R.id.scoreTeamB)

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            recreate()
        }

        player1Switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                scoreTextView1.text = "0"
                scoreTeamA = 0
            }
        }

        player2Switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                scoreTextView2.text = "0"
                scoreTeamB = 0
            }
        }

        increase.setOnClickListener {
            if (player1Switch.isChecked) {
                increaseScore("A")
            } else if (player2Switch.isChecked) {
                increaseScore("B")
            }
        }

        decrease.setOnClickListener {
            if (player1Switch.isChecked) {
                decreaseScore("A")
            } else if (player2Switch.isChecked) {
                decreaseScore("B")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                val message = "This app was created by Lokendra Khanal,Gorge , and Manish. We worked as team For CPIN."
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menu_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun increaseScore(team: String) {
        if (team == "A") {
            scoreTeamA++
            scoreTextView1.text = scoreTeamA.toString()
            if (scoreTeamA == 10) {
                scoreTeamA = 0
                scoreTeamB = 0
                scoreTextView1.text = "0"
                scoreTextView2.text = "0"
                val winnerMessage = "Team 1 is the winner!"
                Toast.makeText(this, winnerMessage, Toast.LENGTH_SHORT).show()
            }
        } else if (team == "B") {
            scoreTeamB++
            scoreTextView2.text = scoreTeamB.toString()
            if (scoreTeamB == 10) {
                scoreTeamA = 0
                scoreTeamB = 0
                scoreTextView1.text = "0"
                scoreTextView2.text = "0"
                val winnerMessage = "Team 2 is the winner!"
                Toast.makeText(this, winnerMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun decreaseScore(team: String) {
        if (team == "A") {
            scoreTeamA--
            if (scoreTeamA < 0) {
                scoreTeamA = 0
                scoreTextView1.text = "0"
            } else {
                scoreTextView1.text = scoreTeamA.toString()
            }
        } else if (team == "B") {
            scoreTeamB--
            if (scoreTeamB < 0) {
                scoreTeamB = 0
                scoreTextView2.text = "0"
            } else {
                scoreTextView2.text = scoreTeamB.toString()
            }
        }
    }
}
