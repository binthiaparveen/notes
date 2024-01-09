package com.example.sharedpreferance

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sp:SharedPreferences
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences("my_sp", MODE_PRIVATE)
    }

    override fun onPause() {
        super.onPause()
        val name = binding.nameEt.text.toString()
        val age = binding.ageEt.text.toString().toInt()
        val editor =sp.edit()
        editor.apply(){

            putString("sp_name",name)
            putInt("sp_age", age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name= sp.getString("sp_name",null)
        val  age =sp.getInt("sp_age",0)
        binding.nameEt.setText(name)
        if (age!=0){
            binding.ageEt.setText(age.toString())
        }
        val intent =Intent (this@MainActivity,new::class.java)
        intent.putExtra("sp_name","sp_age")
        startActivity(intent)
    }
}
