package calm.sleep.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import calm.sleep.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.adapter = PagerAdapter(this)
    }
    fun startToEnd() {
        binding.constraintLayout.transitionToEnd()
        binding.viewpager.isUserInputEnabled = false
    }
    fun endToStart(){
        binding.constraintLayout.transitionToStart()
        binding.viewpager.isUserInputEnabled = true
    }
}