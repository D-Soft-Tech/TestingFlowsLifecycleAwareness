package com.example.testingflowlifecycleawareness.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.testingflowlifecycleawareness.R
import com.example.testingflowlifecycleawareness.data.MainViewModel
import com.example.testingflowlifecycleawareness.databinding.FragmentScreenOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScreenOne : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentScreenOneBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_screen_one, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            myViewModel = viewModel
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_screenOne_to_screenTwo)
        }

        return binding.root
    }
}
