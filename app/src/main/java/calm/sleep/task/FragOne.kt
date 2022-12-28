package calm.sleep.task

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import calm.sleep.task.cardstackview.CardStackView
import calm.sleep.task.cardstackview.TestStackAdapter
import calm.sleep.task.databinding.FragmentFragOneBinding
import java.util.*


private const val ARG_PARAM1 = "param1"

class FragOne : Fragment(R.layout.fragment_frag_one) , CardStackView.ItemExpendListener {
    private var param1: Int = 0
    lateinit var binding: FragmentFragOneBinding
    var expended = false
    val  TEST_DATAS = arrayListOf<Int>(
        R.color.color_1,
        R.color.color_2,
        R.color.color_3,
        R.color.color_4,
        R.color.color_5,
        R.color.color_6,
        R.color.color_7,
        R.color.color_8,
        R.color.color_9,
        R.color.color_10,
        R.color.color_11,
        R.color.color_12,
        R.color.color_13,
        R.color.color_14,
        R.color.color_15,
        R.color.color_16,
        R.color.color_17,
        R.color.color_18,
        R.color.color_19,
        R.color.color_20,
        R.color.color_21,
        R.color.color_22,
        R.color.color_23,
        R.color.color_24,
        R.color.color_25,
        R.color.color_26
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFragOneBinding.bind(view)
        when (param1){
            0->{
                binding.main.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.image1))
            }
            1->{
                binding.main.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.image2))
            }
            2->{
                binding.main.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.image3))
            }
        }
        binding.ivBack.visibility = View.GONE
        binding.stackView.visibility = View.GONE
        binding.main.setOnClickListener {
            (activity as MainActivity).startToEnd()
            binding.ivBack.visibility = View.VISIBLE
            binding.stackView.visibility = View.VISIBLE
        }
        binding.ivBack.setOnClickListener {
            (activity as MainActivity).endToStart()
            binding.ivBack.visibility = View.GONE
            binding.stackView.visibility = View.GONE
        }

        binding.stackView.setItemExpendListener(this)
        val mTestStackAdapter = TestStackAdapter(requireContext())
        binding.stackView.setAdapter(mTestStackAdapter)
        mTestStackAdapter.updateData(TEST_DATAS)


    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            FragOne().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }

    override fun onItemExpend(expend: Boolean) {

    }
}