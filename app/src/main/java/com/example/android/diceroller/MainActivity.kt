/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton:Button = findViewById(R.id.tirar_button)
        rollButton.setOnClickListener{TirarDado()}
        /*val countButton:Button = findViewById(R.id.contador_button)
        countButton.setOnClickListener{Contador()}*/
        val resetearButton:Button = findViewById(R.id.resetear_button)
        resetearButton.setOnClickListener{Resetear()}
    }

    private fun TirarDado()
    {
        val randomInt= (1..3).random()
        val randomInt2= (1..3).random()

        val diceImage: ImageView= findViewById(R.id.dice_image)
        val drawableResource= when(randomInt)
        {
            1 -> R.drawable.piedra
            2 -> R.drawable.papel
            else -> R.drawable.tijera
        }
        diceImage.setImageResource(drawableResource)


        val diceImage2: ImageView= findViewById(R.id.dice_image2)
        val drawableResource2= when(randomInt2)
        {
            1 -> R.drawable.piedra
            2 -> R.drawable.papel
            else -> R.drawable.tijera
        }
        diceImage2.setImageResource(drawableResource2)


        if(randomInt==1 && randomInt2==1 ||randomInt==2 && randomInt2==2 ||randomInt==3 && randomInt2==3)
        {
            val resultText2: TextView = findViewById(R.id.textView_resultado2)
            resultText2.text= "Empate"
            //Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()
        }
        else if(randomInt==1 && randomInt2==2 || randomInt==3 && randomInt2==1 || randomInt==2 && randomInt2==3 )
        {
            val resultText2: TextView = findViewById(R.id.textView_resultado2)
            resultText2.text= "El jugador dos gana"
            //Toast.makeText(this, "El jugador dos gana", Toast.LENGTH_SHORT).show()
        }else
        {
            val resultText2: TextView = findViewById(R.id.textView_resultado2)
            resultText2.text= "El jugador uno gana"
            //Toast.makeText(this, "El jugador uno gana", Toast.LENGTH_SHORT).show()

        }



    }

    
    private fun Resetear()
    {
        val resultText2: TextView=findViewById(R.id.textView_resultado2)
        resultText2.text=0.toString()
        val diceImage: ImageView=findViewById(R.id.dice_image)
        diceImage.setImageResource(R.drawable.empty_dice)
        val diceImage2: ImageView=findViewById(R.id.dice_image2)
        diceImage2.setImageResource(R.drawable.empty_dice)


    }



}
