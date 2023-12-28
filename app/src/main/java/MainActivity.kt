package com.example.navigation02

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigation02.Fragments.HomeFragment
import com.example.navigation02.Fragments.JobsFragment
import com.example.navigation02.Fragments.MyNetwork_Fragment
import com.example.navigation02.Fragments.NotificationFragment
import com.example.navigation02.Fragments.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navigationview: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var drawable: DrawerLayout
    lateinit var container: FrameLayout
    lateinit var bottomNav: BottomNavigationView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find view ID

        var actionBarToggle: ActionBarDrawerToggle
        navigationview = findViewById(R.id.navigationview)
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        drawable = findViewById(R.id.drawable)

        // bottom navigation id findview

        container = findViewById(R.id.container)
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()


        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.home -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment()).commit()


                }

                R.id.my_network -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MyNetwork_Fragment()).commit()

                }


                R.id.post -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, PostFragment()).commit()
                }

                R.id.notification -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, NotificationFragment()).commit()
                }


                R.id.jobs -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, JobsFragment()).commit()

                }


            }
            true
        }


        //  Navigation Baar option

        actionBarToggle =
            ActionBarDrawerToggle(this, drawable, toolbar, R.string.open, R.string.close)
        drawable.addDrawerListener(actionBarToggle)

        actionBarToggle.syncState()

        navigationview.setNavigationItemSelectedListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.home -> {
                    intent = Intent(this@MainActivity, HomePage::class.java)
                    startActivity(intent)
                }

                R.id.message -> {
                    val intent = Intent(Intent.ACTION_MAIN)
                    intent.addCategory(Intent.CATEGORY_DEFAULT)
                    intent.type = "vnd.android-dir/mms-sms"
                    startActivity(intent)
                }


                R.id.txtEmail -> {
                    val intent = Intent(Intent.ACTION_SENDTO)
                        .setData(Uri.parse("mailto:"))
                    startActivity(intent)
                }

                R.id.txtShare -> {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My App Subject")
                }
            }
            drawable.closeDrawers()
            true
        }
    }


    //  Add option menu baar

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                startActivity(Intent.createChooser(shareIntent, "Share via"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My App Subject")
            }


            R.id.home -> {
                intent = Intent(this@MainActivity, HomePage::class.java)
                startActivity(intent)
            }

            R.id.logout -> {
                intent = Intent(this@MainActivity, LoginPage::class.java)
                startActivity(intent)
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
    }


}