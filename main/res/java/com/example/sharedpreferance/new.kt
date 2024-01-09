package com.example.sharedpreferance

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferance.databinding.ActivityMainBinding

class new: AppCompatActivity() {
private lateinit var sp:SharedPreferences
private lateinit var binding: ActivityMainBinding

 override fun onCreate(savedInstanceState:Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(binding.root)
     sp = getSharedPreferences("shared_prefarences", MODE_PRIVATE)

     val name = sp.getString("name",null)
     val age = sp.getInt("age",0)
     binding.nameEt.setText(name)
     if (age )
 }