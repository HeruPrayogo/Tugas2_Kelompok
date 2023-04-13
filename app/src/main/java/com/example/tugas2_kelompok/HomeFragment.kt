package com.example.tugas2_kelompok

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugas2_kelompok.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view()
        hapus()
    }
    fun view(){
        val sharedpref = context?.getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        val getNama = sharedpref?.getString("nama","")
        binding.tvHalloH.text = "Halo, $getNama"
    }
    fun hapus(){
        binding.button.setOnClickListener {
            val sharedpref = context?.getSharedPreferences("dataUser", Context.MODE_PRIVATE)
            val hapus = sharedpref?.edit()
            hapus?.clear()
            hapus?.apply()
            findNavController().navigate(R.id.action_homeFragment_to_splashFragment)
        }
    }
}