package com.example.mydictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import java.io.BufferedReader
import java.io.InputStreamReader

class Word02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word02)

        val input = InputStreamReader(assets.open("word2.csv"))
        val reader = BufferedReader(input)

        var line : String?

        val words:ArrayList<String> = ArrayList()
        val wordAll:ArrayList<Word> = ArrayList()
        while (reader.readLine().also { line = it } != null){
            val row : List<String> = line!!.split("_")//",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex()
            words.add( row[0].toString())
            val  w :Word = Word()
            w.WordEng = row[0].toString()
            w._Void = row[1].toString()
            if (row.count()==3)
            {
                w.WordTh = row[2].toString()
            }
            else
            {
                w.WordTh = row[2].toString().replace("\"","")+ " , " + row[3].toString().replace("\"","")
            }

            wordAll.add(w)
        }

        val ad = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,  words )
        val  listView2: ListView = findViewById(R.id.view2)
        val  atcText: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView2)
        listView2.adapter = ad
        atcText.setAdapter(ad)

        listView2.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = listView2.getItemAtPosition(position) as String

                val filtered = wordAll!!.filter { it.WordEng == itemValue }
                val text = filtered[0].WordEng + "_" + filtered[0]._Void + "_" + filtered[0].WordTh
                val intent = Intent(this@Word02, Detail::class.java)
                intent.putExtra(EXTRA_MESSAGE, text)
                startActivity(intent)

            }
        }


    }
}