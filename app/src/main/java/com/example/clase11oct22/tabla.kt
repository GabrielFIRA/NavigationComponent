package com.example.clase11oct22

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.clase11oct22.databinding.FragmentTablaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [tabla.newInstance] factory method to
 * create an instance of this fragment.
 */
class tabla : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fbinding: FragmentTablaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentTablaBinding.inflate(layoutInflater)
        inciar()
        return fbinding.root
    }

    private fun inciar() {
        fbinding.btnObtenerTabla.setOnClickListener {
            Toast.makeText(activity,"hola",Toast.LENGTH_SHORT).show()
            val numero: Int = fbinding.etNumeroTabla.text.toString().toInt()
            var tabla = ""
            try {
                for(i in 1..10){
                    val cadena: Int = numero * i
                    tabla += "$cadena\n"
                }
                println("aAAAAAAAAAaaaaaaaaaaaaaaaaaaaaa$tabla")
                fbinding.tvTablaNumero.text = tabla
            }catch(ex: Exception){
                Log.wtf("TABLAAAA", tabla)
            }

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment tabla.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tabla().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}