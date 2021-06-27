package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProvider
import com.rsschool.quiz.databinding.FragmentQuiz4Binding

class Quiz4Fragment : Fragment() {

    private var _binding: FragmentQuiz4Binding? = null
    private val binding get() = _binding!!

    private var quizViewModel: QuizViewModel? = null
    private var answers: Array<String>? = null

    interface Callbacks {
        fun onFragment4NextClick()
        fun onFragment4PreviousClick()
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuiz4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel = ViewModelProvider(activity as MainActivity).get(QuizViewModel::class.java)
        answers = quizViewModel!!.answers

        binding.nextButton4?.setOnClickListener {
            callbacks?.onFragment4NextClick()
        }

        binding.previousButton4?.setOnClickListener {
            callbacks?.onFragment4PreviousClick()
        }

        binding.toolbar4?.setNavigationOnClickListener {
            callbacks?.onFragment4PreviousClick()
        }

        binding.optionOne?.setOnClickListener(radioButtonClickListener)
        binding.optionTwo?.setOnClickListener(radioButtonClickListener)
        binding.optionThree?.setOnClickListener(radioButtonClickListener)
        binding.optionFour?.setOnClickListener(radioButtonClickListener)
        binding.optionFive?.setOnClickListener(radioButtonClickListener)
    }

    override fun onResume() {
        super.onResume()
        binding.radioGroup4.check(quizViewModel?.selectedOptions?.get(3) ?: -1)
        if (binding.radioGroup4.checkedRadioButtonId != -1) {
            binding.nextButton4?.isEnabled = true
        }
    }

    private var radioButtonClickListener =
        View.OnClickListener { view ->
            if (view is RadioButton) {
                answers?.set(3, view.text.toString())
                binding.nextButton4?.isEnabled = true
                quizViewModel?.selectedOptions?.set(3, binding.radioGroup4.checkedRadioButtonId)
            }
        }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}