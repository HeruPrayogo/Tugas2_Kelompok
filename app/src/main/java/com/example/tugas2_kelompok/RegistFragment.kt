package com.example.tugas2_kelompok

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tugas2_kelompok.databinding.FragmentRegistBinding


class RegistFragment : Fragment() {
    lateinit var binding: FragmentRegistBinding
    lateinit var sharedpref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegistBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedpref = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
            val nama = binding.etNamaR.text.toString()
            val username = binding.etUsernameR.text.toString()
            val password = binding.etPaswR.text.toString()
            val uPassword = binding.etKonfPaswR.text.toString()
                if(password == uPassword){
                    val login = sharedpref.edit()
                    login.putString("nama", nama)
                    login.putString("userName", username)
                    login.putString("password", password)
                    login.apply()
                    findNavController().navigate(R.id.action_registFragment_to_loginFragment)
                    Toast.makeText(context,"Berhasil Regist", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Password harus sama", Toast.LENGTH_LONG).show()
                }
        }
        binding.tvREGIST.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registFragment)
        }
    }

}