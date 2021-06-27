package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rsschool.quiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    private var quizViewModel: QuizViewModel? = null
    private var answers: Array<String>? = null

    interface Callbacks {
        fun onFragmentNextClick()
        fun onFragmentPreviousClick()
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
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel = ViewModelProvider(activity as MainActivity).get(QuizViewModel::class.java)
        answers = quizViewModel!!.answers

        binding.nextButton?.setOnClickListener {
            callbacks?.onFragmentNextClick()
        }

        binding.previousButton?.setOnClickListener {
            callbacks?.onFragmentPreviousClick()
        }

        binding.radioGroup?.setOnClickListener {
            //nextButton?.isEnabled
        }

        binding.optionOne?.setOnClickListener(radioButtonClickListener)
        binding.optionTwo?.setOnClickListener(radioButtonClickListener)
        binding.optionThree?.setOnClickListener(radioButtonClickListener)
        binding.optionFour?.setOnClickListener(radioButtonClickListener)
        binding.optionFive?.setOnClickListener(radioButtonClickListener)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private var radioButtonClickListener =
        View.OnClickListener { view ->
            if (view is RadioButton) {
                answers?.set(0, view.text.toString())
                binding.nextButton?.isEnabled = true
                binding.nextButton?.isSaveEnabled = true
            }
        }
}

