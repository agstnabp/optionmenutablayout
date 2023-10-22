package com.example.optionmenutablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val fragmentRegister = inflater.inflate(R.layout.fragment_register, container, false)
        val buttonRegis = fragmentRegister.findViewById<Button>(R.id.buttonregis)
        val username_regis = fragmentRegister.findViewById<EditText>(R.id.title_username)
        val email_regis = fragmentRegister.findViewById<EditText>(R.id.title_email)
        val no_regis = fragmentRegister.findViewById<EditText>(R.id.title_phone)
        val password_regis = fragmentRegister.findViewById<EditText>(R.id.title_password)

        buttonRegis.setOnClickListener{
            MainActivity.username = username_regis.text.toString()
            MainActivity.email = email_regis.text.toString()
            MainActivity.no = no_regis.text.toString()
            MainActivity.password = password_regis.text.toString()

            if (username_regis.text.toString() != "" && password_regis.text.toString() != ""
                && email_regis.text.toString() != "" && no_regis.text.toString() != "") {
                Toast.makeText(activity,"Register successful",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(
                    activity,
                    "kolom tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        // Inflate the layout for this fragment
        return fragmentRegister
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}