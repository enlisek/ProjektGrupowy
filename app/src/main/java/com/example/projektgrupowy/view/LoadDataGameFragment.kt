package com.example.projektgrupowy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.projektgrupowy.R
import com.example.projektgrupowy.viewmodel.LoadDataGameViewModel
import com.example.projektgrupowy.viewmodel.LocalPlayerViewModel
import com.example.projektgrupowy.viewmodel.MainViewModel
import com.example.projektgrupowy.viewmodel.PlayerViewModel
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_load_data_game.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoadDataGameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoadDataGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var  loadDataGameViewModel:LoadDataGameViewModel
    private lateinit var  playerViewModel:PlayerViewModel
    private lateinit var mainViewModel: MainViewModel


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
        mainViewModel= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        playerViewModel= ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)
        loadDataGameViewModel = ViewModelProvider(requireActivity()).get(LoadDataGameViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_load_data_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextRabbitGame.setText(mainViewModel.list[0].toString())
        editTextSheepGame.setText(mainViewModel.list[1].toString())
        editTextPigGame.setText(mainViewModel.list[2].toString())
        editTextCowGame.setText(mainViewModel.list[3].toString())
        editTextHorseGame.setText(mainViewModel.list[4].toString())
        editTextDogGame.setText(mainViewModel.list[5].toString())
        editTextBigDogGame.setText(mainViewModel.list[6].toString())


        buttonConfirmDataGame.setOnClickListener{view -> run{
            loadDataGameViewModel.updatePlayerData(playerViewModel.currentPlayer.value!!.id,playerViewModel.currentPlayer.value!!.playerName,editTextRabbitGame.text.toString().toInt(),editTextPigGame.text.toString().toInt(),editTextSheepGame.text.toString().toInt(),editTextCowGame.text.toString().toInt(),editTextHorseGame.text.toString().toInt(),editTextDogGame.text.toString().toInt(),editTextBigDogGame.text.toString().toInt())
            mainViewModel.list= listOf(0,0,0,0,0,0,0)
            view.findNavController().navigate(R.id.action_loadDataGameFragment_to_gameFragment)
            }
        }
        buttonBackToGame.setOnClickListener { view->run {
            mainViewModel.list= listOf(0,0,0,0,0,0,0)
            view.findNavController().navigate(R.id.action_loadDataGameFragment_to_gameFragment) }}
        buttonMakePhotoGame.setOnClickListener { view->view.findNavController().navigate(R.id.action_loadDataGameFragment_to_loadPhotoGameFragment) }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoadDataGameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoadDataGameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}