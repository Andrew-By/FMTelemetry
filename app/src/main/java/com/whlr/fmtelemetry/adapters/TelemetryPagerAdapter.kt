package com.whlr.fmtelemetry.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.whlr.fmtelemetry.views.AccelerationFragment
import com.whlr.fmtelemetry.views.FrictionFragment
import com.whlr.fmtelemetry.views.GeneralFragment

class TelemetryPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            1 -> return AccelerationFragment()
            2 -> return FrictionFragment()
        }
        return GeneralFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}