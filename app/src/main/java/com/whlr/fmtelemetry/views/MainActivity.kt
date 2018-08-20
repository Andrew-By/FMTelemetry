package com.whlr.fmtelemetry.views

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.whlr.fmtelemetry.R
import com.whlr.fmtelemetry.adapters.AddressesAdapter
import com.whlr.fmtelemetry.adapters.InterfacesAdapter
import com.whlr.fmtelemetry.adapters.TelemetryPagerAdapter
import com.whlr.fmtelemetry.databinding.ActivityMainBinding
import com.whlr.fmtelemetry.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.net.InetAddress

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.vm = viewModel

//        val ifaceAdapter = InterfacesAdapter(this)
//        ifaceAdapter.interfaces = viewModel.interfaces.toList()

        val addAdapter = AddressesAdapter(this)
        viewModel.interfaces.observe(this, Observer<List<InetAddress>> { addresses ->
            addAdapter.addresses = addresses
        })

        with(interfacesView) {
            adapter = addAdapter
            layoutManager = LinearLayoutManager(context)
        }

        pager.adapter = TelemetryPagerAdapter(supportFragmentManager)
    }
}
