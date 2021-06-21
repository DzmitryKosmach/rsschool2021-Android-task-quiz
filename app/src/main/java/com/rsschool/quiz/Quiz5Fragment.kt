package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Quiz5Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Quiz5Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var nextButton: Button? = null
    private var previousButton: Button? = null
    private var toolBar: Toolbar? = null

    private var radioGroup: RadioGroup? = null
    private var radioButton1: RadioButton? = null
    private var radioButton2: RadioButton? = null
    private var radioButton3: RadioButton? = null
    private var radioButton4: RadioButton? = null
    private var radioButton5: RadioButton? = null

    private var quizViewModel: QuizViewModel? = null
    private var answers: Array<String>? = null

    interface Callbacks {
        fun onFragment5NextClick()
        fun onFragment5PreviousClick()
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel = ViewModelProvider(activity as MainActivity).get(QuizViewModel::class.java)
        answers = quizViewModel!!.answers

        nextButton = view.findViewById<Button>(R.id.next_button5)
        previousButton = view.findViewById<Button>(R.id.previous_button5)
        toolBar = view.findViewById<Toolbar>(R.id.toolbar5)

        radioGroup = view.findViewById<RadioGroup>(R.id.radio_group)

        radioButton1 = view.findViewById<RadioButton>(R.id.option_one)
        radioButton2 = view.findViewById<RadioButton>(R.id.option_two)
        radioButton3 = view.findViewById<RadioButton>(R.id.option_three)
        radioButton4 = view.findViewById<RadioButton>(R.id.option_four)
        radioButton5 = view.findViewById<RadioButton>(R.id.option_five)

        nextButton?.setOnClickListener{
            callbacks?.onFragment5NextClick()
        }

        previousButton?.setOnClickListener{
            callbacks?.onFragment5PreviousClick()
        }

        toolBar?.setNavigationOnClickListener {
            callbacks?.onFragment5PreviousClick()
        }

        radioButton1?.setOnClickListener(radioButtonClickListener)
        radioButton2?.setOnClickListener(radioButtonClickListener)
        radioButton3?.setOnClickListener(radioButtonClickListener)
        radioButton4?.setOnClickListener(radioButtonClickListener)
        radioButton5?.setOnClickListener(radioButtonClickListener)
    }

    var radioButtonClickListener =
        View.OnClickListener { view ->
            if (view is RadioButton) {
                answers?.set(4, view.text.toString())
            }
        }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Quiz5_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Quiz5Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}