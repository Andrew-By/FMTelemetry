package com.whlr.fmtelemetry.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.whlr.fmtelemetry.R
import com.whlr.fmtelemetry.adapters.AddressesAdapter
import com.whlr.fmtelemetry.viewmodels.ConnectionViewModel
import kotlinx.android.synthetic.main.activity_connection.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.InetAddress

class ConnectionActivity : AppCompatActivity() {

    lateinit var viewModel: ConnectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ConnectionViewModel::class.java)

        setContentView(R.layout.activity_connection)

        val addAdapter = AddressesAdapter(this)
        viewModel.interfaces.observe(this, Observer<List<InetAddress>> { addresses ->
            addAdapter.addresses = addresses
        })

        with(adaptersView) {
            adapter = addAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
