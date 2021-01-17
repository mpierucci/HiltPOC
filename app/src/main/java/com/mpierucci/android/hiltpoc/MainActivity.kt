package com.mpierucci.android.hiltpoc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mpierucci.hiltpoc.btc.presentation.BtcFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.fragment_container,
                BtcFragment(),
                "Tag"
            ).commit()
        }
    }
}