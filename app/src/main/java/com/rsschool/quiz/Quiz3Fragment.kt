package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rsschool.quiz.databinding.FragmentQuiz3Binding

class Quiz3Fragment : Fragment() {
    private val INDEX_QUIZ_VIEW_MODEL = 2

    private var _binding: FragmentQuiz3Binding? = null
    private val binding get() = requireNotNull(_binding)

    private var quizViewModel: QuizViewModel? = null
    private var answers: Array<String>? = null

    interface Callbacks {
        fun onFragment3NextClick()
        fun onFragment3PreviousClick()
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ctx: Context = ContextThemeWrapper(activity, R.style.Theme_Quiz_Third)
        val layoutInflater = inflater.cloneInContext(ctx)
        _binding = FragmentQuiz3Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel = ViewModelProvider(activity as MainActivity).get(QuizViewModel::class.java)
        answers = quizViewModel!!.answers


        binding.nextButton3.setOnClickListener {
            callbacks?.onFragment3NextClick()
        }

        binding.previousButton3.setOnClickListener {
            callbacks?.onFragment3PreviousClick()
        }

        binding.toolbar3.setNavigationOnClickListener {
            callbacks?.onFragment3PreviousClick()
        }

        binding.optionOne.setOnClickListener(radioButtonClickListener)
        binding.optionTwo.setOnClickListener(radioButtonClickListener)
        binding.optionThree.setOnClickListener(radioButtonClickListener)
        binding.optionFour.setOnClickListener(radioButtonClickListener)
        binding.optionFive.setOnClickListener(radioButtonClickListener)
    }

    override fun onResume() {
        super.onResume()
        binding.radioGroup3.check(quizViewModel?.selectedOptions?.get(INDEX_QUIZ_VIEW_MODEL) ?: -1)
        if (binding.radioGroup3.checkedRadioButtonId != -1) {
            binding.nextButton3.isEnabled = true
        }
    }

    private var radioButtonClickListener =
        View.OnClickListener { view ->
            if (view is RadioButton) {
                answers?.set(INDEX_QUIZ_VIEW_MODEL, view.text.toString())
                binding.nextButton3.isEnabled = true
                quizViewModel?.selectedOptions?.set(INDEX_QUIZ_VIEW_MODEL, binding.radioGroup3.checkedRadioButtonId)
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