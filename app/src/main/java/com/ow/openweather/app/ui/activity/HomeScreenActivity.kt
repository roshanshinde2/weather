package com.ow.openweather.app.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ow.openweather.R
import com.ow.openweather.app.viewmodel.HomeScreenViewModel
import kotlinx.android.synthetic.main.activity_homescreen.*
import com.ow.openweather.databinding.ActivityHomescreenBinding

//home screen
class HomeScreenActivity : AppCompatActivity() {

    lateinit var mEvent: Lifecycle.Event
    lateinit var mainBinding : ActivityHomescreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setContentView(layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()*/

        val model: HomeScreenViewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        setContentView(R.layout.activity_homescreen)
        /*setSupportActionBar(toolbar)*/

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_homescreen)
        mainBinding.lifecycleOwner = this
        mainBinding.vmHomeScreen = model

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        model.getToastMessageLiveData().observe(this, Observer {
            Toast.makeText(applicationContext,it,Toast.LENGTH_SHORT).show()
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
