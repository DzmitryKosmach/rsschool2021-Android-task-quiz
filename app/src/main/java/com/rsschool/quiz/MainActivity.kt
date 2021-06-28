package com.rsschool.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity(),
    QuizFragment.Callbacks, Quiz2Fragment.Callbacks, Quiz3Fragment.Callbacks,
    Quiz4Fragment.Callbacks, Quiz5Fragment.Callbacks, Result_Fragment.Callbacks {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onFragmentNextClick() {
        navController.navigate(R.id.action_quizFragment_to_quiz2Fragment)
    }

    override fun onFragmentPreviousClick() {
        navController.popBackStack()
    }

    override fun onFragment2NextClick() {
        navController.navigate(R.id.action_quiz2Fragment_to_quiz3Fragment)
    }

    override fun onFragment2PreviousClick() {
        navController.popBackStack()
    }

    override fun onFragment3NextClick() {
        navController.navigate(R.id.action_quiz3Fragment_to_quiz4Fragment)
    }

    override fun onFragment3PreviousClick() {
        navController.popBackStack()
    }

    override fun onFragment4NextClick() {
        navController.navigate(R.id.action_quiz4Fragment_to_quiz5Fragment)
    }

    override fun onFragment4PreviousClick() {
        navController.popBackStack()
    }

    override fun onFragment5NextClick() {
        navController.navigate(R.id.action_quiz5Fragment_to_result_Fragment)
    }

    override fun onFragment5PreviousClick() {
        navController.popBackStack()
    }

    override fun onFragmentResultBackClick() {
        navController.navigate(R.id.action_result_Fragment_to_quizFragment)
    }

    override fun onFragmentResultExit() {
        this.finishAffinity()
    }
}