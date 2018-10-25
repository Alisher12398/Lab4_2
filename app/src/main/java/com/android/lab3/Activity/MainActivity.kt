package com.android.lab3.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewPager
import com.android.lab3.Model.NewsModel
import com.android.lab3.Adapter.PageAdapter
import com.android.lab3.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var actors = ArrayList<NewsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PageAdapter(getSupportFragmentManager())
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)

        val add_news_button = findViewById<FloatingActionButton>(R.id.add_news_button)

        add_news_button.setOnClickListener{
            val intent = Intent(this, AddNewsActivity::class.java)
            startActivity(intent)
        }

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                position.inc()
            }

            override fun onPageSelected(position: Int) {

            }

        })

    }
}
