package com.sun_asterisk.clean_architecture_sample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun_asterisk.clean_architecture_sample.R
import com.sun_asterisk.clean_architecture_sample.ui.movies.MoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainFrameLayout, MoviesFragment.newInstance())
            .commit()
    }
}
