package com.example.mdietlux.ui.register.measure

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.mdietlux.R
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.textfield.TextInputEditText
import com.shawnlin.numberpicker.NumberPicker
import kotlinx.coroutines.launch

class MeasureFragment : Fragment() {

    lateinit var pref: SharedPreferences

    lateinit var ageEditText: TextInputEditText
    var ageData: String = "0"

    lateinit var heigthEditText: TextInputEditText
    var heigthDara = "0"

    lateinit var weigthEditText: TextInputEditText
    var weigthDara = "0"

    lateinit var weigthObjEditText: TextInputEditText
    var weightOBJ = "0"

    var isMetric: Boolean = true

    lateinit var toggleButton: MaterialButtonToggleGroup

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_measure, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)!!

        ageEditText = view.findViewById(R.id.inputAge)
        ageEditText.keyListener = null
        ageEditText.setOnClickListener {
            dialogAge()
        }

        heigthEditText = view.findViewById(R.id.inputHeight)
        ageEditText.keyListener = null
        heigthEditText.setOnClickListener {
            dialogHeigth()
        }

        weigthEditText = view.findViewById(R.id.inputWeight)
        weigthEditText.keyListener = null
        weigthEditText.setOnClickListener {
            dialogWeigth()
        }

        weigthObjEditText = view.findViewById(R.id.inputOBJtHeight)
        weigthObjEditText.keyListener = null
        weigthObjEditText.setOnClickListener {
            dialogWeigthOBJ()
        }

        toggleButton = view.findViewById(R.id.toggleButton)

        toggleButton.check(R.id.button1)

        toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
            // Respond to button selection
            if (checkedId == R.id.button1) {
                isMetric = true
                Toast.makeText(activity?.applicationContext, isMetric.toString(), Toast.LENGTH_LONG).show()
            } else {
                isMetric = false
                Toast.makeText(activity?.applicationContext, isMetric.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }


    fun dialogAge() {
        this.context?.let {
            MaterialDialog(it).show {
                this.customView(R.layout.dialog_age)
                this.cornerRadius(6f)
                this.title(res = R.string.agetitle)
                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_age)
                positiveButton {

                    val editor = pref.edit()
                    editor?.putInt("age", numberPicker.value)
                    editor?.apply()
                    ageData = pref.getInt("age", 0).toString()
                    ageEditText.setText(ageData)

                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }

    fun dialogHeigth() {
        this.context?.let {
            MaterialDialog(it).show {
                this.customView(R.layout.dialog_heigth)
                this.cornerRadius(6f)
                this.title(res = R.string.height_title)

                if (isMetric) {
                    this.message(R.string.height_info_text_dialog)
                } else {
                    this.message(R.string.height_info_text_imperial_dialog)
                }

                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_heigth)

                positiveButton {
                    val editor = pref.edit()
                    editor?.putInt("heigth", numberPicker.value)
                    editor?.apply()

                    heigthDara = pref.getInt("heigth", 0).toString()
                    if (isMetric) {
                        heigthEditText.setText("${heigthDara} cm")
                    } else {
                        heigthEditText.setText("${heigthDara} plg")
                    }

                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }

    fun dialogWeigth() {
        this.context?.let {
            MaterialDialog(it).show {
                this.customView(R.layout.dialog_weigth)
                this.cornerRadius(6f)
                this.title(res = R.string.weight_title)

                if (isMetric) {
                    this.message(R.string.weight_info_text_dialog)
                } else {
                    this.message(R.string.weight_info_text_imperial_dialog)
                }

                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_weigth)

                positiveButton {

                    val editor = pref.edit()
                    editor?.putInt("weigth", numberPicker.value)
                    editor?.apply()

                    weigthDara = pref.getInt("weigth", 0).toString()

                    if (isMetric) {
                        weigthEditText.setText("${weigthDara} kg")
                    } else {
                        weigthEditText.setText("${weigthDara} lb")
                    }

                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }

    fun dialogWeigthOBJ() {
        this.context?.let {
            MaterialDialog(it).show {
                this.customView(R.layout.dialog_weigth)
                this.cornerRadius(6f)
                this.title(res = R.string.weight_title)

                if (isMetric) {
                    this.message(R.string.weight_info_text_dialog)
                } else {
                    this.message(R.string.weight_info_text_imperial_dialog)
                }

                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_weigth)

                positiveButton {

                    val editor = pref.edit()
                    editor?.putInt("weigthOBJ", numberPicker.value)
                    editor?.apply()
                    weightOBJ = pref.getInt("weigthOBJ", 0).toString()
                    if (isMetric) {
                        weigthObjEditText.setText("${weightOBJ} kg")
                    } else {
                        weigthObjEditText.setText("${weightOBJ} lb")
                    }

                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }
}