package com.example.listview

import android.app.Activity
import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val image = intArrayOf(
            R.drawable.girl_13,R.drawable.boy_08,R.drawable.youngman_34,R.drawable.youngwoman_42,
            R.drawable.oldwoman_85,R.drawable.oldman_82
        )

        val name = arrayListOf(
            "さくら","翔太","宗介","愛子","マツ","祐一郎"
        )

        val massage = arrayListOf(
            "おはよう！！","遊ぼうよー","何してる？","元気？","体に気をつけてね。","頑張ってな"
        )

       val massageTime = arrayListOf(
           "9:00 AM","11:00 AM","15:00 PM","17:30 PM","18:00 PM","19:00 PM"
       )

        userArrayList = ArrayList() // 初期化する

        for(i in 0..5) {
            val user = User(image[i],name[i],massage[i],massageTime[i])
        userArrayList.add(user)
        }

        //クリック機能を実装する
        binding.listView.isClickable = true
        // ユーザーがクリックした位置を取得している
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val iamge = image[position]
            val name = name[position]
            val massage = massage[position]
            val massageTime = massageTime[position]

            val intent = Intent(this,SubActivity::class.java)
            intent.putExtra("image",iamge)
            intent.putExtra("name",name)
            intent.putExtra("massage",massage)
            intent.putExtra("massageTime",massageTime)

            startActivity(intent)
        }

        // アダプターと結びづけを行う
        binding.listView.adapter = MyAdpter(this,userArrayList)

    }
}

