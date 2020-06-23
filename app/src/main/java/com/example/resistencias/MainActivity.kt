package com.example.resistencias

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var resultado: Float
        var salida: String
        var c1 = 10
        var c2 = 0
        var c3 = 2
        var c4 = 2
        val colores:Array<String> = arrayOf("#000000","#8b4513","#ff0000","#ff8c00","#ffff00","#00ff00","#00008b","#8a2be2","#696969","#ffffff","#ffd700","#c0c0c0")
        val colores2:Array<String> = arrayOf("#8b4513","#ff0000","#ffd700","#c0c0c0","#d2b48c")
        val tolerancias:Array<String> = arrayOf("±1%","±2%","±5%","±10%","±20%")
        val multi= floatArrayOf(1F, 10F,100F,1000F,10000F,100000F,1000000F,0F,0F,0F,0.1F,0.01F)
        color_1.setBackgroundColor(Color.parseColor(colores[c1/10]))
        color_2.setBackgroundColor(Color.parseColor(colores[c2]))
        color_3.setBackgroundColor(Color.parseColor(colores[c3]))
        color_4.setBackgroundColor(Color.parseColor(colores2[c4]))
        bt_1mas.setOnClickListener {
            if(c1 == 90) c1 = 0
            else c1 += 10
            color_1.setBackgroundColor(Color.parseColor(colores[c1/10]))

        }
        bt_1menos.setOnClickListener {
            if(c1==0) c1 =90
            else c1 -= 10
            color_1.setBackgroundColor(Color.parseColor(colores[c1/10]))
        }
        bt_2mas.setOnClickListener {
            if(c2 == 9) c2 = 0
            else c2 += 1
            color_2.setBackgroundColor(Color.parseColor(colores[c2]))

        }
        bt_2menos.setOnClickListener {
            if(c2==0) c2 =9
            else c2 -= 1
            color_2.setBackgroundColor(Color.parseColor(colores[c2]))
        }
        bt_3mas.setOnClickListener {
            if(c3 == 11) c3 = 0
            else if(c3==6) c3 =10
            else c3 += 1
            color_3.setBackgroundColor(Color.parseColor(colores[c3]))

        }
        bt_3menos.setOnClickListener(){
            if(c3==0) c3 =11
            else if(c3==10) c3=6
            else c3 -= 1
            color_3.setBackgroundColor(Color.parseColor(colores[c3]))
        }
        bt_4mas.setOnClickListener {
            if(c4 ==4 ) c4 = 0
            else c4 += 1
            color_4.setBackgroundColor(Color.parseColor(colores2[c4]))

        }

        bt_4menos.setOnClickListener {
            if(c4==0) c4 =4
            else c4 -= 1
            color_4.setBackgroundColor(Color.parseColor(colores2[c4]))
        }
        bt_calcular.setOnClickListener {
            resultado = ((c1 +c2)*multi[c3])
            if(resultado >= 1000000F)
                salida = (resultado/1000000).toString() + "MΩ"
            else if(resultado >=1000F)
                salida = (resultado/1000).toString() + "KΩ"
            else
                salida = resultado.toString() +"Ω"
            tv_res.text = "$salida\nTolerancia: "+tolerancias[c4]


        }
    }
}