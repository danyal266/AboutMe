package com.example.aboutme

import android.content.Context
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName:MyName= MyName("Danyal Zafar")


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
       binding =   DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName


        // setContentView(R.layout.activity_main)
        // findViewById<Button>(R.id.done_button).setOnClickListener {
        //  fg(it)
        // }
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
//  val edittext = findViewById<EditText>(R.id.Nickname_edit)
//        val twe = findViewById<TextView>(R.id.Nickname_text)
      myName?.nickname = Nickname_edit.text.toString()
        binding.apply {
            binding.NicknameText.text = binding.NicknameEdit.text
            invalidateAll()
            binding.NicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.NicknameText.visibility = View.VISIBLE
        }
//        twe.text = edittext.text
//        edittext.visibility = View.GONE
//        view.visibility = View.GONE
//        twe.visibility = View.VISIBLE
        val imme = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imme.hideSoftInputFromWindow(view.windowToken,0)

    }
}
