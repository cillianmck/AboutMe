package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding // Binding object instantiated
    // layer of glue between layout and its views and the data

    //Real power of data binding comes when we bind data

    // Instance of MyName data class.
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main) // R = reference a resource, which is a layout,filename = activity_main
      binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

          /*  findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        } */

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // val editText = findViewById<EditText>(R.id.nickname_edit)
       // val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        binding.apply {
        nicknameText.text = binding.nicknameEdit.text
        invalidateAll()
        nicknameEdit.visibility = View.GONE
        doneButton.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}