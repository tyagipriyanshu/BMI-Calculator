package com.nadjemni.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.advice1IMG
import kotlinx.android.synthetic.main.activity_result.advice1TV
import kotlinx.android.synthetic.main.activity_result.advice2IMG
import kotlinx.android.synthetic.main.activity_result.advice3IMG
import kotlinx.android.synthetic.main.activity_result.advice3TV
import kotlinx.android.synthetic.main.activity_result.bmiFlagImgView
import kotlinx.android.synthetic.main.activity_result.bmiLabelTV
import kotlinx.android.synthetic.main.activity_result.bmiValueTV
import kotlinx.android.synthetic.main.activity_result.commentTV
import kotlinx.android.synthetic.main.activity_result.containerL
import kotlinx.android.synthetic.main.activity_result.skipResultBTN
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        skipResultBTN.setOnClickListener {
            startActivity( Intent(this@ResultActivity,  MainActivity::class.java))
        }
        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if (bmi == -1.0) {
            containerL.visibility= View.GONE
        } else {
            bmiValueTV.text=bmi.toString()
                if (bmi < 18.5) {
                    containerL.setBackgroundResource(R.color.colorYellow)
                    bmiFlagImgView.setImageResource(R.drawable.exclamationMark)
                    IMG.setImageResource(R.drawable.under)
                    bmiLabelTV.text="UnderWeight!"
                    commentTV.text="Tips For You :"
                    advice1IMG.setImageResource(R.drawable.nowater)
                    advice1TV.text="Don't Drink Water Before Meals"
                    advice2IMG.setImageResource(R.drawable.bigmeal)
                    advice2TV.text="Eat Calorie Surplus Food "
                    advice3TV.text="Get Quality Sleep"

                } else {
                    if (bmi > 25) {
                        containerL.setBackgroundResource(R.color.colorRed)
                        bmiFlagImgView.setImageResource(R.drawable.warning)
                        IMG.setImageResource(R.drawable.over)
                        bmiLabelTV.text="OverWeight!"
                        commentTV.text="Tips For You :"
                        advice1IMG.setImageResource(R.drawable.water)
                        advice1TV.text="Drink Water, Especially Before Meals"
                        advice2IMG.setImageResource(R.drawable.twoeggs)
                        advice2TV.text="Eat Eggs For Breakfast"
                        advice3IMG.setImageResource(R.drawable.nosugar)
                        advice3TV.text="Drink Green Tea & Avoid Sugary food"
                    }
                }
            }
        }
}
