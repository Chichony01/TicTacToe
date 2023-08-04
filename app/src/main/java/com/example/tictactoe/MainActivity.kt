package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.tictactoe.databinding.ActivityMainBinding
import java.lang.System.exit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var flag=0
    var count1=0
    var count2=0
    var draw=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contGame.setOnClickListener {
            binding.btn1.setText("")
            binding.btn2.setText("")
            binding.btn3.setText("")
            binding.btn4.setText("")
            binding.btn5.setText("")
            binding.btn6.setText("")
            binding.btn7.setText("")
            binding.btn8.setText("")
            binding.btn9.setText("")
            flag=0
            draw=0
            enableBtn()
            binding.tvWon.setText("")
        }

        binding.newGame.setOnClickListener {
            binding.btn1.setText("")
            binding.btn2.setText("")
            binding.btn3.setText("")
            binding.btn4.setText("")
            binding.btn5.setText("")
            binding.btn6.setText("")
            binding.btn7.setText("")
            binding.btn8.setText("")
            binding.btn9.setText("")
            flag=0
            draw=0
            count1=0
            count2=0
            binding.tv1.setText("Player 1: $count1")
            binding.tv2.setText("Player 2: $count2")
            enableBtn()
            binding.tvWon.setText("")
        }

    }

    fun btnClick(view : View){
        val currentButton = view as Button

        if(currentButton.text=="") {
            draw++
            if (flag==0){
                currentButton.text="X"
                currentButton.setTextColor(getColor(R.color.X_color))
                flag =1
            }
            else{
                currentButton.text="0"
                currentButton.setTextColor(getColor(R.color.O_color))
                flag =0
            }

        }

        val b1= binding.btn1.text.toString()
        val b2= binding.btn2.text.toString()
        val b3= binding.btn3.text.toString()
        val b4= binding.btn4.text.toString()
        val b5= binding.btn5.text.toString()
        val b6= binding.btn6.text.toString()
        val b7= binding.btn7.text.toString()
        val b8= binding.btn8.text.toString()
        val b9= binding.btn9.text.toString()

        if(b1==b2 && b2==b3 && b3!= ""){
             if (currentButton.text=="X"){
                 p1Win()
                 count1++
            }
            else {
                p2Win()
                 count2++
             }

            winner(count1,count2)
            disableBtn()
        }

        else if(b4==b5 && b5==b6 && b6!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
            disableBtn()
        }

        else if(b7==b8 && b8==b9 && b9!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
            disableBtn()
        }

        else if(b1==b4 && b4==b7 && b7!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
            disableBtn()
        }

        else if(b2==b5 && b5==b8 && b8!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
            disableBtn()
        }

        else if(b3==b6 && b6==b9 && b9!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
//          disableBtn()
        }

        else if(b1==b5 && b5==b9 && b9!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
            disableBtn()
        }

        else if(b3==b5 && b5==b7 && b7!= ""){
            if (currentButton.text=="X"){
                p1Win()
                count1++
            }
            else{
                p2Win()
                count2++
            }

            winner(count1,count2)
            disableBtn()

        }
        else if(draw==9){
            makeToast("Match Draw")
        }


    }



    private fun makeToast(msg:String ){
        Toast.makeText(this@MainActivity,msg, Toast.LENGTH_SHORT).show()
    }

    fun winner(c1:Int , c2: Int){
        binding.tv1.setText("Player 1: $count1")
        binding.tv2.setText("Player 2: $count2")
    }

    fun disableBtn(){
        binding.btn1.isEnabled =false
        binding.btn2.isEnabled =false
        binding.btn3.isEnabled =false
        binding.btn4.isEnabled =false
        binding.btn5.isEnabled =false
        binding.btn6.isEnabled =false
        binding.btn7.isEnabled =false
        binding.btn8.isEnabled =false
        binding.btn9.isEnabled =false
    }
    fun enableBtn(){
        binding.btn1.isEnabled =true
        binding.btn2.isEnabled =true
        binding.btn3.isEnabled =true
        binding.btn4.isEnabled =true
        binding.btn5.isEnabled =true
        binding.btn6.isEnabled =true
        binding.btn7.isEnabled =true
        binding.btn8.isEnabled =true
        binding.btn9.isEnabled =true
    }
    fun p1Win(){
        binding.tvWon.setText("Player 1 won")

    }
    fun p2Win(){
        binding.tvWon.setText("Player 2 won")
    }
}