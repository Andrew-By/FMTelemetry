package com.whlr.fmtelemetry.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.whlr.fmtelemetry.R
import com.whlr.fmtelemetry.adapters.TelemetryPagerAdapter
import com.whlr.fmtelemetry.databinding.ActivityMainBinding
import com.whlr.fmtelemetry.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.vm = viewModel

        pager.adapter = TelemetryPagerAdapter(supportFragmentManager)
    }
}
