package edu.temple.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class ColorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply{
            findViewById<Spinner>(R.id.spinner).apply{
                adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item,
                    arrayOf("Blue", "Red", "White", "Magenta"))

                onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        parent?.run{
                                this@ColorFragment.view?.setBackgroundColor(Color.parseColor(getItemAtPosition(position).toString()))
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                }
            }
        }
    }
}