package com.android.lab3.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.lab3.R


class BlankFragment3 : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root= inflater.inflate(R.layout.blank_fragment3, container, false)

      /* *//* val actors = ArrayList<CategoryModel>()
        for (i in 1..7) {
            actors.add(CategoryModel("Category  " + i.toString()))
        }
*//*
        //var adapter3 = CategoryAdapter(actors)

        val recycler = root.findViewById(R.id.recycler2) as RecyclerView

        recycler.adapter = adapter3

        recycler.layoutManager = LinearLayoutManager(activity)
*/
        return root
    }

}
