package com.example.optionmenutablayout

import android.content.Intent
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
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
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
        val fragmentLogin = inflater.inflate(R.layout.fragment_login, container, false)
        val buttonLogin = fragmentLogin.findViewById<Button>(R.id.buttonlogin)
        val username_login = fragmentLogin.findViewById<EditText>(R.id.usernamelogin)
        val password_login = fragmentLogin.findViewById<EditText>(R.id.passwordlogin)

        buttonLogin.setOnClickListener{
            if (username_login.text.toString() != "" && password_login.text.toString() != "") {
                if (MainActivity.username == username_login.text.toString() && MainActivity.password == password_login.text.toString()) {
                    val intentLogin = Intent(activity, HomeActivity::class.java)
                    intentLogin.putExtra("USERNAME", MainActivity.username)
                    startActivity(intentLogin)
                } else {
                    Toast.makeText(
                        activity,
                        "Username atau password salah",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    activity,
                    "kolom tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        // Inflate the layout for this fragment
        return fragmentLogin
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}