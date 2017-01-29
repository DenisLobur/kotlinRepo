package com.kotlin.den.kotlinstart

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        if(savedInstanceState == null) {
            changefragment(NewsFragment())
        }
    }

    fun changefragment(f: Fragment, clearStack: Boolean = false) {
        val ft = supportFragmentManager.beginTransaction()
        if (clearStack) {
            clearBackStack()
        }
        ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
        ft.replace(R.id.content_main, f)
        ft.addToBackStack(null)
        ft.commit()
    }

    fun clearBackStack() {
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        val manager = supportFragmentManager
        if(manager.backStackEntryCount > 1) {
            manager.popBackStack()
        } else {
            finish()
        }
    }

    fun chech(a: Int, b: Int): Unit {
        val map: HashMap<String, String> = HashMap()
        map.put("1", "one")
        map.put("2", "two")

        for ((k, v) in map) {
            println("$v" + " ")
        }

        val map2 = mapOf<Int, Int>(1 to 2, 2 to 3)
        for (x in 1..3) {

        }
        for (x in 10 downTo 1) {

        }

        for (x in 1 until 10) {

        }


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
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
