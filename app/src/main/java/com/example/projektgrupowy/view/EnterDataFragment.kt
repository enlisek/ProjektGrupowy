package com.example.projektgrupowy.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import com.example.projektgrupowy.R
import kotlinx.android.synthetic.main.fragment_enter_data.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val REQUEST_CODE = 42


class EnterDataFragment : Fragment() {
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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCameraLocal.setOnClickListener()
        {
            Log.d("XX", "probuje otworzyc")
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            Log.d("XX", "otworzylem ")
            if (takePictureIntent.resolveActivity((requireContext().packageManager)) != null) {
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            } else {
                Toast.makeText(context, "Nie moge otworzyc kamery", Toast.LENGTH_SHORT).show()
            }

        }
        buttonBackToEnterManually.setOnClickListener{ view->view.findNavController().navigate(R.id.action_enterDataFragment_to_manuallyEnterLocalDataFragment)}
        buttonConfirmPhotoLocal.setOnClickListener { view->view.findNavController().navigate(R.id.action_enterDataFragment_to_manuallyEnterLocalDataFragment) }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK)
        {
            val takenImage = data?.extras?.get("data") as Bitmap
//            var cyaned = ImageManagement.ImageToCyan(takenImage)
//            var cutted = ImageManagement.FindOneSector(cyaned)
            imageViewLocal.setImageBitmap(takenImage)

        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChooseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterDataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}