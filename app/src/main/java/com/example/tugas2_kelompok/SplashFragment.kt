package com.example.tugas2_kelompok

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.tugas2_kelompok.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            if (context?.getSharedPreferences("dataregist", Context.MODE_PRIVATE)!!.contains("username")){
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment)
            }else{
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_registFragment)
            }

        },3000)


    }}