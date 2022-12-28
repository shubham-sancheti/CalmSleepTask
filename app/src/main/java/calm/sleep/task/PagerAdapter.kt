package calm.sleep.task

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: FragmentActivity):FragmentStateAdapter(activity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return FragOne.newInstance(position)
    }

}