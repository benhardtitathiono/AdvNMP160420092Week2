package com.ubaya160420092.adv160420092week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtTurn=view.findViewById<TextView>(R.id.txtTurn)
        val txtNum1=view.findViewById<TextView>(R.id.txtNum1)
        val txtNum2=view.findViewById<TextView>(R.id.txtNum2)
        var num1=(0..99).random()
        var num2=(0..99).random()

        arguments?.let{
            val playerName=GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text="$playerName's Turn"
        }
        val btnSubmit=view.findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener{
            val action=GameFragmentDirections.actionResultFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}