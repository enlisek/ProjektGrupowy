package com.example.projektgrupowy.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.projektgrupowy.R
import com.example.projektgrupowy.viewmodel.LocalPlayerViewModel
import com.example.projektgrupowy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_enter_data.view.*
import kotlinx.android.synthetic.main.fragment_load_data_game.*
import kotlinx.android.synthetic.main.fragment_load_photo_game.*
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgproc.Imgproc
import kotlin.math.abs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val REQUEST_CODE = 42


/**
 * A simple [Fragment] subclass.
 * Use the [LoadPhotoGameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoadPhotoGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var krolikIm: Bitmap
    lateinit var owcaIm: Bitmap
    lateinit var swiniaIm: Bitmap
    lateinit var krowaIm: Bitmap
    lateinit var konIm: Bitmap
    lateinit var piesekIm: Bitmap
    lateinit var piesIm: Bitmap
    lateinit var imageView: ImageView
    lateinit var lista : List<Int>
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
        // Inflate the layout for this fragment
        mainViewModel= ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        var view = inflater.inflate(R.layout.fragment_load_photo_game, container, false)
//        imageView  = (view.findViewById(R.id.imageViewGame))
        return inflater.inflate(R.layout.fragment_load_photo_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCameraGame.setOnClickListener()
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
        buttonBackToEnterDataGame.setOnClickListener { view ->
            run {
                mainViewModel.list = listOf(0, 0, 0, 0, 0, 0, 0)
                view.findNavController().navigate(R.id.action_loadPhotoGameFragment_to_loadDataGameFragment)
            }
        }
        buttonConfirmPhotoGame.setOnClickListener { view -> run { view.findNavController().navigate(R.id.action_loadPhotoGameFragment_to_loadDataGameFragment) }}

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CODE && resultCode== Activity.RESULT_OK)
        {
            var takenImage = data?.extras?.get("data") as Bitmap
            krolikIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.krolik).toBitmap()), 35,28)
            owcaIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.owca).toBitmap()), 35,28)
            swiniaIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.swinia).toBitmap()), 35,28)
            krowaIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.krowa).toBitmap()), 35,28)
            konIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.kon).toBitmap()), 35,28)
            piesekIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.piesek).toBitmap()), 35,28)
            piesIm =ScaleBitmap(Edges(getResources().getDrawable(R.drawable.pies).toBitmap()), 35,28)


            var edged = Edges(takenImage)
            var ti = OpenCVTry(edged)
//            imageView.setImageResource(R.drawable.krolik)
//            imageView.setImageBitmap(ti)
            imageViewGame.setImageBitmap(ti)

        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }


    fun OpenCVTry(btm:Bitmap):Bitmap
    {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
//        var itkroliki:Int = FindAnimal(btm, krolikIm, 0.001, Scalar(150.0, 30.0,30.0), 100000.0)
//        var itowce:Int = FindAnimal(btm, owcaIm, 0.001, Scalar(0.0, 255.0,0.0), 1500000.0)
//        var itswinie:Int = FindAnimal(btm, swiniaIm, 0.97, Scalar(255.0, 0.0,255.0), 900000.0)
//        var itkrowy:Int = FindAnimal(btm, krowaIm, 0.99, Scalar(100.0, 100.0,100.0), 1000000.0)
//        var itkonie:Int = FindAnimal(btm, konIm, 0.97, Scalar(255.0, 100.0,100.0), 1300000.0)
//        var itpieski:Int = FindAnimal(btm, piesekIm, 0.97, Scalar(100.0, 100.0,255.0), 1500000.0)
//        var itpsy:Int = FindAnimal(btm, piesIm, 0.97, Scalar(255.0, 255.0,255.0), 1500000.0)
//
//
//        lista = listOf(itkroliki,itowce, itswinie,itkrowy,itkonie,itpieski,itpsy)
//        mainViewModel.list = lista

        var btm2:Bitmap = btm
        btm2 = FindAnimal(btm,krolikIm,0.99,Scalar(150.0,30.0,30.0), 25000000.0)

//        println(" ZWIERZATKA: ${lista[0]},${lista[1]},${lista[2]},${lista[3]},${lista[4]},${lista[5]},${lista[6]} ")
        return btm2
    }


    fun FindAnimal(btm:Bitmap, template:Bitmap, threshold:Double, kolor: Scalar, v:Double) : Bitmap
    {
        val machMethod = Imgproc.TM_CCOEFF_NORMED


        var finalbtm : Bitmap = Bitmap.createBitmap(btm,0,0,btm.width,btm.height)
        var mat : Mat = Mat() //mat dla zrodlowego
        var mattemplate: Mat = Mat(template.width, template.height, CvType.CV_8UC3, Scalar(0.0, 0.0, 255.0)) //mat dla templatki krolika
        var finalmat = Mat(btm.height, btm.width, CvType.CV_8UC1, Scalar(0.0, 0.0, 255.0))


        Utils.bitmapToMat(btm,mat) //zrodlo do mat
        Utils.bitmapToMat(template,mattemplate) //krolik do mat
        mat.convertTo(mat, CvType.CV_8UC1)
        mattemplate.convertTo(mattemplate, CvType.CV_8UC4)
        finalmat.convertTo(finalmat, CvType.CV_8UC4)
        var mat2=mat.clone()

        //zrodlo,templatka,wynik,metoda
        Imgproc.matchTemplate(mat, mattemplate, finalmat, machMethod)

        var maxval: Double = 1.0
        var dst: Mat
        var it =0

        val data: ArrayList<Array<Double>> = ArrayList()

//        while (maxval<=threshold) {
//            val maxr = Core.minMaxLoc(finalmat)
//            val maxp = maxr.maxLoc
//            maxval = maxr.maxVal /v
//           // val maxop = Point(maxp.x + mattemplate.width(), maxp.y + mattemplate.height())
//        //    dst = mat.clone()
//
//            var ar :Array<Double> = arrayOf(maxp.x, maxp.y)
//            data.add(ar)
//
//            println("maxval: $maxval")

        var found = false
            if(maxp.x>4 && maxp.y>4.0 && maxp.x<(mat.width()-mattemplate.width()-4) && maxp.y<(mat.height()-mattemplate.height() - 4)) {
//                found = false
//             for(d in data)
//             {
//                if(!(abs(d[0]- maxp.x) <= mattemplate.width() && abs(d[1] - maxp.y)<= mattemplate.height()) && !found)
//                {
                it++
//                    found=true
//                }
//             }
//


                Imgproc.rectangle(
                        mat, maxp, Point(
                        maxp.x + mattemplate.cols(),
                        maxp.y + mattemplate.rows()
                ), kolor, 1
                )
                Imgproc.rectangle(
                        finalmat, maxp, Point(
                        maxp.x + mattemplate.cols(),
                        maxp.y + mattemplate.rows()
                ), kolor, -1
                )

            }
  //          if(maxp.x>4 && maxp.y>4.0 && maxp.x<(mat.width()-mattemplate.width()-2) && maxp.y<(mat.height()-mattemplate.height() - 2))
   //             it++

        }
        finalmat.convertTo(finalmat, CvType.CV_8UC4)
        finalbtm = Bitmap.createBitmap(finalmat.width(), finalmat.height(),Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(finalmat, finalbtm)
        Utils.matToBitmap(mat, btm)

        return finalbtm
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun Edges(btm: Bitmap):Bitmap
    {
        val data1: IntArray = intArrayOf(1,1,1)
        val data2: IntArray = intArrayOf(1,-8,1)
        val data3: IntArray = intArrayOf(1,1,1)

        val data: Array<IntArray> = arrayOf(data1,data2,data3)

        var btm2:Bitmap = Bitmap.createBitmap(btm.width,btm.height,  Bitmap.Config.ARGB_8888);
        var btm3:Bitmap = btm
        var w = btm.width-3
        var h = btm.height-3
        // println(btm.width.toString() +" oraz "+btm.height.toString())

        for(i in 2..w)
        {
            for(j in 2..h)
            {
                var red = 0
                var green = 0
                var blue = 0
                for(k in 2 downTo 0)
                {
                    for(l in 2 downTo 0)
                    {
                        val p = btm.getPixel(i + 2 - k, j + 2 - l)
                        val redValue = Color.red(p);
                        val blueValue = Color.blue(p);
                        val greenValue = Color.green(p);
                        red+= data[k][l] * redValue;
                        green+= data[k][l] * greenValue;
                        blue += data[k][l]*blueValue
                    }
                }

                if(red<0) red=0
                if(red<255) red=255
                if(green<0) green=0
                if(green>255) green=255
                if(blue<0) blue=0
                if(blue>255) blue=255

                var treshold = 80
                if (red >= treshold && blue >= treshold)
                {
                    //        println("$i oraz $j: ${Color.red(btm2.getPixel(i,j))}, ${Color.green(btm2.getPixel(i,j))}, ${Color.blue(btm2.getPixel(i,j))}")
                    btm2.setPixel(i, j, Color.rgb(255, 0, 0))
                }
                else {
                    //     println("$i oraz $j: ${Color.red(btm2.getPixel(i,j))}, ${Color.green(btm2.getPixel(i,j))}, ${Color.blue(btm2.getPixel(i,j))}")
                    btm2.setPixel(i, j, Color.rgb(0, 0, 0))
                }
            }
        }
        return btm2
    }


    fun ScaleBitmap(btm:Bitmap, w:Int,h:Int):Bitmap
    {
        return Bitmap.createScaledBitmap(
                btm,
                w,
                h,
                false
        )
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoadPhotoGameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoadPhotoGameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}