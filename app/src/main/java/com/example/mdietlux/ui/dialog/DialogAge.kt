package com.example.mdietlux.ui.dialog

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.mdietlux.R

class DialogAge(val context: Context) {

    fun dialogShow(){
        MaterialDialog(context).show {
            this.customView(R.layout.dialog_age)
            this.cornerRadius(6f)
            this.title(res = R.string.agetitle)

            positiveButton {

            }
            negativeButton {
                this.dismiss()
            }
        }
    }
}