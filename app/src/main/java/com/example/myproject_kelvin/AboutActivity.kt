package com.example.myproject_kelvin

import android.content.Intent
import android.content.Intent.ACTION_SENDTO
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myproject_kelvin.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "About Me"

        binding.tvEmail.setOnClickListener(this)
    }

    override fun onClick(p: View) {
        when (p) {
            binding.tvEmail -> {
                val emailIntent = Intent(ACTION_SENDTO)
                emailIntent.data = Uri.parse("mailto:zaenal.alfian@mhs.rosma.ac.id")
                startActivity(emailIntent)
            }
        }
    }
}