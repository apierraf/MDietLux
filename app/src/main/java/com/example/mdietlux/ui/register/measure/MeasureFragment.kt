package com.example.mdietlux.ui.register.measure

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.mdietlux.R
import com.example.mdietlux.datastore.DataStore
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.textfield.TextInputEditText
import com.shawnlin.numberpicker.NumberPicker
import kotlinx.coroutines.launch

class MeasureFragment : Fragment() {

    lateinit var dataStore: DataStore

    lateinit var ageEditText: TextInputEditText
    var ageData: String = "0"

    lateinit var heigthEditText: TextInputEditText
    var heigthDara = "0"

    lateinit var weigthEditText: TextInputEditText
    var weigthDara = "0"

    lateinit var weigthObjEditText: TextInputEditText
    var weightOBJ = "0"

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

        dataStore = DataStore(view.context)

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
                Toast.makeText(activity?.applicationContext, "Metrico", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity?.applicationContext, "Imperial", Toast.LENGTH_LONG).show()
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
                    lifecycleScope.launch {
                        dataStore.saveDataAge(numberPicker.value)
                        ageData = dataStore.currentAge.asLiveData().value.toString()
                        ageEditText.setText(numberPicker.value.toString())
                    }
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
                this.message(R.string.height_info_text_dialog)

                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_heigth)

                positiveButton {
                    lifecycleScope.launch {
                        dataStore.saveDataHeigth(numberPicker.value)
                        heigthDara = dataStore.currentHeigth.asLiveData().value.toString()
                        heigthEditText.setText("${numberPicker.value} cm")
                    }
                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }

    fun dialogWeigth(){
        this.context?.let {
            MaterialDialog(it).show {
                this.customView(R.layout.dialog_weigth)
                this.cornerRadius(6f)
                this.title(res = R.string.weight_title)
                this.message(R.string.weight_info_text_dialog)

                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_weigth)

                positiveButton {

                    lifecycleScope.launch {
                        dataStore.saveDataWeigth(numberPicker.value)
                        weigthDara = dataStore.currentWeigth.asLiveData().value.toString()
                        weigthEditText.setText("${numberPicker.value} kg")
                    }
                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }

    fun dialogWeigthOBJ(){
        this.context?.let {
            MaterialDialog(it).show {
                this.customView(R.layout.dialog_weigth)
                this.cornerRadius(6f)
                this.title(res = R.string.weight_title)
                this.message(R.string.weight_info_text_dialog)

                val numberPicker: NumberPicker = this.findViewById(R.id.number_picker_weigth)

                positiveButton {

                    lifecycleScope.launch {
                        dataStore.saveDataWeigthOBJ(numberPicker.value)
                        weigthDara = dataStore.currentWeigthOBJ.asLiveData().value.toString()
                        weigthObjEditText.setText("${numberPicker.value} kg")
                    }
                }
                negativeButton {
                    this.dismiss()
                }
            }
        }
    }
}