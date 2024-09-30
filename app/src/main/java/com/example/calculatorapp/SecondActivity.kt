package com.example.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorapp.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity(){
    lateinit var secondActivityBinding: SecondActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        secondActivityBinding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(secondActivityBinding.root)
        var receivedMessage : String = intent.getStringExtra("message").toString()
        secondActivityBinding.recipient.text = receivedMessage
    }
    fun sendButton(view : View){
        var message : String = secondActivityBinding.yourMessage.text.toString()
        var intent = Intent()
        intent.putExtra("message" , message.toString())
        setResult(RESULT_OK , intent)
        finish()
    }
}