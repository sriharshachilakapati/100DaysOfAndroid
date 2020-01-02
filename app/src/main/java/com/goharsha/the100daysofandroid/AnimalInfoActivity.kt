package com.goharsha.the100daysofandroid

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner

class AnimalInfoActivity : AppCompatActivity() {
    private lateinit var animalInfoContentFragment: AnimalInfoContentFragment
    private var selectedAnimal: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        title = "Day 4: Animal Info"
        animalInfoContentFragment = AnimalInfoContentFragment()

        selectedAnimal = savedInstanceState?.getInt("selection") ?: 0

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.animalInfoFragmentContainer, animalInfoContentFragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("selection", selectedAnimal)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_animal_info, menu)

        val spinner = menu!!.findItem(R.id.menuSelectAnimalSpinner).actionView as AppCompatSpinner
        spinner.apply {
            adapter = ArrayAdapter.createFromResource(
                this@AnimalInfoActivity,
                R.array.image_drawable_names,
                R.layout.support_simple_spinner_dropdown_item
            )

            setSelection(selectedAnimal)

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedAnimal = position
                    animalInfoContentFragment.selectionChange(position)
                }
            }
        }

        return true
    }
}