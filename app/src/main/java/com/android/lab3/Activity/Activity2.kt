package com.android.lab3.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.lab3.Database
import com.android.lab3.R
import kotlinx.android.synthetic.main.activity_2.*


class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val intent = intent

        var db = Database(this)
        val sqlitedatabase = db.writableDatabase

        //intent.getParcelableArrayExtra("selected_news_id")


       // val mIntent = getIntent()
        val intValue = intent.getIntExtra("selected_news_id", 0)
        //val exampleItem = intent.getParcelableExtra<NewsModel>("ExampleItem")



        val news = db.selectByID(intValue)

        val textView1 = findViewById<TextView>(R.id.title_activity2)
        textView1.text = news.title

        val textView2 = findViewById<TextView>(R.id.date_activity2)
        textView2.text = news.date

        val textView3 = findViewById<TextView>(R.id.text_activity2)
        textView3.text = news.text

        val image2 = findViewById<ImageView>(R.id.image_activity2)
        image2.setImageResource(R.drawable.footbal)

        /*when(line4){
            "footbal" -> image2.setImageResource(R.drawable.footbal)
            "wifi" -> image2.setImageResource(R.drawable.wifi)
            "amazon" -> image2.setImageResource(R.drawable.news1)
            "uber" -> image2.setImageResource(R.drawable.uber)
        }*/

        floating_button.setOnClickListener {
            val toast = Toast.makeText(this,
                    intValue.toString(), Toast.LENGTH_LONG)
            toast.show()
        }

        image_button.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

        }

        image_edit.setOnClickListener{
            val intent = Intent(this, EditNewsActivity::class.java)
            intent.putExtra( "selected_news_id", intValue)
            startActivity(intent)
        }

        image_trash.setOnClickListener{
            db.deleteNews(intValue)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        /* val intent = intent
         val exampleItem = intent.getParcelableExtra<NewsModel>("Example Item")

         val line1 = exampleItem.title
         val line2 = exampleItem.date


         val textView1 = findViewById<TextView>(R.id.title_activity2)
         textView1.text = line1

         val textView2 = findViewById<TextView>(R.id.date_activity2)
         textView1.text = line2*/

    }






























}
