package com.smartherd.msgshareapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.e("MainActivity","Button was clicked")

            Toast.makeText(this,"Button clicked",Toast.LENGTH_LONG).show()
            val msg : String = editText.text.toString();

            val intent = Intent();
            intent.putExtra(Intent.EXTRA_TEXT,msg)
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"share to:"))
        }

        button.setOnClickListener{
            val msg:String = editText.text.toString()
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("intent",msg)
            startActivity(intent)
        }
    }
}
