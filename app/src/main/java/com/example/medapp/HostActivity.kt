package com.example.medapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.medapp.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {
    var hostActivityHostBinding: ActivityHostBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hostActivityHostBinding = ActivityHostBinding.inflate(layoutInflater)
        val view = hostActivityHostBinding?.root
        setContentView(view)
        supportFragmentManager.commit {
            add<SplashFragment>(R.id.host_container)
        }
    }
}