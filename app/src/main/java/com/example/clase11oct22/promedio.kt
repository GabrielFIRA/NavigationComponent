package com.example.clase11oct22

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clase11oct22.databinding.FragmentMenuBinding
import com.example.clase11oct22.databinding.FragmentPromedioBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [promedio.newInstance] factory method to
 * create an instance of this fragment.
 */
class promedio : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fbinding: FragmentPromedioBinding

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
        fbinding = FragmentPromedioBinding.inflate(layoutInflater)
        iniciar()
        return fbinding.root
    }

    private fun iniciar() {
        var numero: Int = 0
        var contador: Int = 0
        fbinding.btnAgregarComp.setOnClickListener {
            numero += fbinding.etNumero.text.toString().toInt()
            contador++
            fbinding.tvResultado.text = ""
            fbinding.etNumero.setText("")
        }
        fbinding.btnCalcularPromedio.setOnClickListener {
            calcularPromedio(numero, contador)
            contador = 0
            numero = 0
        }
    }

    private fun calcularPromedio(numero: Int, contador: Int) {

        var promedio: Int = 0
        promedio = numero / contador
        fbinding.tvResultado.text = promedio.toString()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment promedio.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            promedio().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}