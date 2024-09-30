package com.example.calculatorapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding : ActivityMainBinding
    private var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result : ActivityResult ->
        if(result.resultCode == RESULT_OK){
            var message = result.data?.getStringExtra("message").toString()
            mainBinding.recipient.text = message
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mainBinding.root)
    }
    fun sendButton(view : View){
        var intent = Intent(this , SecondActivity::class.java)
        intent.putExtra("message" , mainBinding.yourMessage.text.toString())
        mainBinding.yourMessage.text.clear()
        launcher.launch(intent)
    }
}