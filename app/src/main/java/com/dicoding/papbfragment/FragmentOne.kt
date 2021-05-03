package com.dicoding.papbfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dicoding.papbfragment.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOneBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments as Bundle
        binding.et.setText(bundle.getString("number"))
        binding.btnGo.setOnClickListener {
            val mBundle = Bundle()
            val fragmentTwo = FragmentTwo()
            mBundle.putString("number", binding.et.text.toString())
            fragmentTwo.arguments = mBundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fl, fragmentTwo, FragmentTwo::class.java.simpleName)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

}