package com.example.listview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

// AdapterはViewとデータセットを紐づける役割がある。
class MyAdpter(private val context: Activity, private val userList: MutableList<User>) : ArrayAdapter<User> (context,
      R.layout.list_item,userList) {

      // リスト項目を表示するためのViewを取得する
      override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // LayoutInflaterを使用することで、XMLに対応するViewオブジェクトを使用する
            val inflater : LayoutInflater =  LayoutInflater.from(context)
            val view : View = inflater.inflate(R.layout.list_item,null)

            //個々にアイテムを挿入する
            val imageView = view.findViewById<ImageView>(R.id.image)
            val userName = view.findViewById<TextView>(R.id.name)
            val textMassage = view.findViewById<TextView>(R.id.massage)
            val textMassageTime = view.findViewById<TextView>(R.id.massage_Time)

            //データに設定する
            imageView.setImageResource(userList[position].image)
            userName.text = userList[position].name
            textMassage.text = userList[position].massage
            textMassageTime.text = userList[position].massagetime

            return view //viewを返す

      }
}