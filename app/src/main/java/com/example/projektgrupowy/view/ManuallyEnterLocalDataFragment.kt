package com.example.projektgrupowy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.projektgrupowy.R
import com.example.projektgrupowy.viewmodel.MainViewModel
import com.example.projektgrupowy.viewmodel.ManuallyEnterLocalDataViewModel
import kotlinx.android.synthetic.main.fragment_load_data_game.*
import kotlinx.android.synthetic.main.fragment_manually_enter_local_data.*
import kotlinx.android.synthetic.main.fragment_manually_enter_local_data.buttonMakePhoto

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ManuallyEnterLocalDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ManuallyEnterLocalDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: ManuallyEnterLocalDataViewModel
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel= ViewModelProvider(requireActivity()).get(ManuallyEnterLocalDataViewModel::class.java)
        mainViewModel= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        return inflater.inflate(R.layout.fragment_manually_enter_local_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editTextRabbit.setText(mainViewModel.list[0].toString())
        editTextSheep.setText(mainViewModel.list[1].toString())
        editTextPig.setText(mainViewModel.list[2].toString())
        editTextCow.setText(mainViewModel.list[3].toString())
        editTextHorse.setText(mainViewModel.list[4].toString())
        editTextDog.setText(mainViewModel.list[5].toString())
        editTextBigDog.setText(mainViewModel.list[6].toString())


        buttonConfirmData.setOnClickListener{view -> run{
            viewModel.saveLocalPlayer(editTextRabbit.text.toString().toInt(),editTextPig.text.toString().toInt(),editTextSheep.text.toString().toInt(),editTextCow.text.toString().toInt(),editTextHorse.text.toString().toInt(),editTextDog.text.toString().toInt(),editTextBigDog.text.toString().toInt())
            mainViewModel.list= listOf(0,0,0,0,0,0,0)
            view.findNavController().navigate(R.id.action_manuallyEnterLocalDataFragment_to_localPlayerFragment)
        }}
        buttonMakePhoto.setOnClickListener { view->view.findNavController().navigate(R.id.action_manuallyEnterLocalDataFragment_to_enterDataFragment) }
        buttonBackToLocal.setOnClickListener { view-> run {
            mainViewModel.list= listOf(0,0,0,0,0,0,0)
            view.findNavController().navigate(R.id.action_manuallyEnterLocalDataFragment_to_localPlayerFragment) }  }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ManuallyEnterLocalDataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ManuallyEnterLocalDataFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}