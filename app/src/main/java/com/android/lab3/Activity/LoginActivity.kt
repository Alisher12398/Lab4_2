package com.android.lab3.Activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.lab3.R
import android.widget.Toast



class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button_login_login = findViewById<Button>(R.id.button_login_login)
        val edittext_login_name = findViewById<EditText>(R.id.edittext_login_name)
        val edittext_login_password = findViewById<EditText>(R.id.edittext_login_password)

        val sPref = getPreferences(Context.MODE_PRIVATE)
        val ed = sPref.edit()
        ed.putString("login", edittext_login_name.text.toString())
        ed.putString("password", edittext_login_password.text.toString())
        ed.apply()

        button_login_login.setOnClickListener{
            if (edittext_login_name.length()>0 && edittext_login_password.length()>0){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            else{
                Toast.makeText(this, "Please, write login/password", Toast.LENGTH_SHORT).show()
            }
        }

    }



}
