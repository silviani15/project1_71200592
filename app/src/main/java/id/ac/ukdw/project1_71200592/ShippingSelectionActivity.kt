package id.ac.ukdw.project1_71200592

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class ShippingSelectionActivity : AppCompatActivity() {

    private lateinit var shippingOptionRadioGroup: RadioGroup
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping_selection)

        shippingOptionRadioGroup = findViewById(R.id.shippingOptionRadioGroup)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val selectedOptionId = shippingOptionRadioGroup.checkedRadioButtonId
            val selectedOption = findViewById<RadioButton>(selectedOptionId).text.toString()

            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("shippingOption", selectedOption)
            startActivity(intent)
        }
    }
}
