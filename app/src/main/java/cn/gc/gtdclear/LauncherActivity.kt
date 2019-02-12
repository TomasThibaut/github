package cn.gc.gtdclear

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import cn.gc.gtdclear.databinding.ActivityLauncherBinding
import cn.gc.gtdclear.homepage.ArchiveFragment
import cn.gc.gtdclear.homepage.ProjectFragment
import cn.gc.gtdclear.homepage.TimeFragment

class LauncherActivity : AppCompatActivity() {

    lateinit var binding: ActivityLauncherBinding

    lateinit var fragmentArray: Array<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLauncherBinding>(this, R.layout.activity_launcher)
        initValues()
        initViewPager()
    }

    private fun initValues() {
        fragmentArray = arrayOf(ProjectFragment(), TimeFragment(), ArchiveFragment())
    }

    private fun initViewPager() {
        binding.viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragmentArray[position]
            }

            override fun getCount(): Int {
                return fragmentArray.size
            }
        }
    }
}
