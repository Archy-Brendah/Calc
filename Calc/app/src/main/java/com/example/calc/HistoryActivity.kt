package com.example.calc

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
var word: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        var word = "Old calculation is showed here"
        var etShowHistory= findViewById(R.id.etShowHistory) as EditText
        print(word)
        val prefs = getPreferences(String)
        word = (if (prefs != null) prefs.getString("saved", null) else null).toString()

        var editor: SharedPreferences.Editor

//        val adapter: ArrayAdapter<String>
//        var list=findViewById(R.id.list) as ListView
//        list.setAdapter(adapter)
//                val txt = etShowHistory.getText().toString()
//                adapter.add(txt)

    }

    private fun getPreferences(string: String.Companion) {

    }

    fun print(word:String) {
        val bundle = getIntent().getExtras()?.also {
             var word = it.getString("message").toString()
        }
        etShowHistory.setMovementMethod(ScrollingMovementMethod())
        etShowHistory.setText(word)
    }

    fun update(finalNumber:String) {
        var editor = getPreferences(String)?.edit()
        word = (word
                + System.getProperty("line.separator")
                + finalNumber
                + System.getProperty("line.separator"))
        editor?.putString("saved", word)

        editor?.apply()
    }

//    fun onBackPressed() {
//        super.onBackPressed()
//        overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right)
//    }
    fun deleteAppData(v: View) {
        try
        {
            // clearing app data
            val packageName = getApplicationContext().getPackageName()
            val runtime = Runtime.getRuntime()
            runtime.exec("pm clear " + packageName)
        }
        catch (e:Exception) {
            e.printStackTrace()
        }
    }


        }

private fun Unit.apply() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

private fun Unit.putString(finalNumber: String, word: String) {

}

private fun Unit.edit() {


}

private fun Unit.getString(finalNumber: String, nothing: Nothing?) {    

}



  