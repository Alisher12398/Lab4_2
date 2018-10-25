package com.android.lab3.Activity

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.lab3.Database
import com.android.lab3.R

class AddNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        val button_addnews_activityadd = findViewById<Button>(R.id.button_addnews_activityadd)
        val title_addnews = findViewById<EditText>(R.id.title_addnews)
        val date_addnews = findViewById<EditText>(R.id.date_addnews)
        val text_addnews = findViewById<EditText>(R.id.text_addnews)
        val image_addnews = findViewById<EditText>(R.id.image_addnews)

        button_addnews_activityadd.setOnClickListener{

            if (title_addnews.length()>0 && date_addnews.length()>0 && text_addnews.length()>0)
            {
                var db = Database(this)
                val sqlitedatabase = db.writableDatabase

                val cv = ContentValues()

                //val image_url : Int = image_addnews.text
                cv.put("title", title_addnews.text.toString())
                cv.put("date", date_addnews.text.toString())
                cv.put("text", text_addnews.text.toString())
                cv.put("image_url", R.drawable.footbal)
                sqlitedatabase.insert("News", null, cv)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            else{
                Toast.makeText(this, "A", Toast.LENGTH_LONG).show()
            }

        }
    }
}
