package com.example.tugas2_kelompok

import android.content.Context
import android.content.SharedPreferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tugas2_kelompok.databinding.FragmentLoginBinding




class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var sharedpref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedpref = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        val dataUserName = sharedpref.getString("userName", "")
        val dataPassword = sharedpref.getString("password", "")
        val userN = binding.etUsernamL.text.toString()
        val pass = binding.etPaswL.text.toString()
            binding.btnLogin.setOnClickListener {
                if(userN == dataUserName && pass == dataPassword){
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                }else{
                    Toast.makeText(context,"Password atau Username Salah", Toast.LENGTH_LONG).show()
                }
            }
    }

}