package com.dicoding.papbfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dicoding.papbfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            val mBundle = Bundle()
            val fragmentOne = FragmentOne()
            mBundle.putString("number", binding.et.text.toString())
            fragmentOne.arguments = mBundle
            supportFragmentManager.beginTransaction()
               .add(R.id.fl, fragmentOne, FragmentOne::class.java.simpleName)
                .addToBackStack(null)
               .commit()
        }
    }

}