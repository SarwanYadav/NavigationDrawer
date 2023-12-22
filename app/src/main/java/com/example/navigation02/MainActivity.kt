package com.example.navigation02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var navigationview: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var drawable: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var actionBarToggle: ActionBarDrawerToggle


        navigationview = findViewById(R.id.navigationview)
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        drawable = findViewById(R.id.drawable)






        actionBarToggle = ActionBarDrawerToggle(this, drawable,toolbar, R.string.open, R.string.close)
        drawable.addDrawerListener(actionBarToggle)

        actionBarToggle.syncState()


        navigationview.setNavigationItemSelectedListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.home -> {
                    Toast.makeText(this, "This is home button", Toast.LENGTH_SHORT).show()

                }

                R.id.message -> {
                    val intent = Intent(Intent.ACTION_MAIN)
                    intent.addCategory(Intent.CATEGORY_DEFAULT)
                    intent.type = "vnd.android-dir/mms-sms"
                    startActivity(intent)
                }

                R.id.txtEmail ->{
                    val intent = Intent(Intent.ACTION_SENDTO)
                        .setData(Uri.parse("mailto:"))
                    startActivity(intent)
                }

            }
            true


        }

    }
}

