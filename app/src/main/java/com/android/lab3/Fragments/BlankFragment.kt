package com.android.lab3.Fragments


import android.os.Bundle
import android.content.ContentValues
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.lab3.Activity.Activity2
import com.android.lab3.Adapter.NewsAdapter
import com.android.lab3.Adapter.RecyclerTouchListener
import com.android.lab3.Database

import com.android.lab3.Model.NewsModel
import com.android.lab3.R


class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_blank, container, false)

       // var db = Database(container.getContext())

        var db = Database(container!!.getContext())
        val sqlitedatabase = db.writableDatabase

        val actors = db.parceDBtoList()

        /*
        val cv = ContentValues()
        cv.put("title", "title1")
        cv.put("date", "date1")
        cv.put("text", "Text1")
        cv.put("image_url", R.drawable.news1)
        sqlitedatabase.insert("News", null, cv)


        val cv2 = ContentValues()
        cv2.put("title", "title2")
        cv2.put("date", "date2")
        cv2.put("text", "Text2")
        cv2.put("image_url", R.drawable.news1)
        sqlitedatabase.insert("News", null, cv2)
        */

         var adapter2 = NewsAdapter(actors)

         val recycler = root.findViewById(R.id.recycler) as RecyclerView

         recycler.adapter = adapter2

         recycler.layoutManager = LinearLayoutManager(activity)



         recycler.addOnItemTouchListener(RecyclerTouchListener(getActivity()!!.getApplicationContext(), recycler, object : RecyclerTouchListener.ClickListener {
             override fun onClick(view: View, position: Int) {
 //                Toast.makeText(context,"is selected!", Toast.LENGTH_SHORT).show()
                 val intent = Intent(context, Activity2::class.java)
                 intent.putExtra( "selected_news_id", actors[position].id)
                 startActivity(intent)
             }
         }))


        return root
    }

}
