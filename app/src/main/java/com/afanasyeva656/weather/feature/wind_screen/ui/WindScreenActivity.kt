package com.afanasyeva656.weather.feature.wind_screen.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afanasyeva656.weather.R
import org.koin.android.viewmodel.ext.android.viewModel


class WindScreenActivity : AppCompatActivity() {
    val windScreenViewModel by viewModel<WindScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)
        windScreenViewModel.viewState.observe(this, Observer(::render))
    }

    private fun render(state: ViewState) {
        val speed = state.windDomainModel.speed.toString()
        val degree = state.windDomainModel.degree.toString()

        findViewById<TextView>(R.id.tvWindSpeed).text =
            getString(R.string.wind_speed, speed)
        findViewById<TextView>(R.id.tvWindDegree).text =
            getString(R.string.wind_degree, degree)
    }
}