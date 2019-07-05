package com.example.hp.passengerapplication.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hp.passengerapplication.Model.MessageChat
import com.example.hp.passengerapplication.R
import com.google.firebase.auth.FirebaseAuth

class UsersChatListAdapter(
        var context: Context, var userChatList: ArrayList<MessageChat>

) :
        RecyclerView.Adapter<UsersChatListAdapter.myViewHoder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHoder {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(context).inflate(
                        R.layout.row_chat,
                        null, false)
                myViewHoder(view)
            }
            else -> {
                val view = LayoutInflater.from(context).inflate(
                        R.layout.row_chat_reciever,
                        null, false)
                myViewHoder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return userChatList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (userChatList[position].senderId) {
            FirebaseAuth.getInstance().uid -> {
                0
            }
            else -> {
                1
            }
        }
    }

    override fun onBindViewHolder(holder: myViewHoder, position: Int) {
        holder.bindUser(userChatList[position])
    }

    inner class myViewHoder(var view: View) : RecyclerView.ViewHolder(view) {
        val msg_view = view.findViewById<TextView>(R.id.text_message_body)
        fun bindUser(msg: MessageChat) {
            msg_view.text = msg.msg
        }
    }

}
