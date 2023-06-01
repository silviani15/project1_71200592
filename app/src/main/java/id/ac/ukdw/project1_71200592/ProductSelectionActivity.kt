package id.ac.ukdw.project1_71200592

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductSelectionActivity : AppCompatActivity() {

    private lateinit var product1QuantityEditText: EditText
    private lateinit var product2QuantityEditText: EditText
    private lateinit var product3QuantityEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_selection)

        product1QuantityEditText = findViewById(R.id.angkabrg1)
        product2QuantityEditText = findViewById(R.id.angkabrg2)
        product3QuantityEditText = findViewById(R.id.angkabrg3)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val product1Quantity = product1QuantityEditText.text.toString().toInt()
            val product2Quantity = product2QuantityEditText.text.toString().toInt()
            val product3Quantity = product3QuantityEditText.text.toString().toInt()

            // Validasi minimal pembelian untuk promo
            if (product1Quantity >= 5) {
                val discountedPrice = calculateDiscountedPrice(100, 20)
                Toast.makeText(this, "Promo: Diskon 20% (Harga Diskon: $discountedPrice)", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, ShippingSelectionActivity::class.java)
            intent.putExtra("product1Quantity", product1Quantity)
            intent.putExtra("product2Quantity", product2Quantity)
            intent.putExtra("product3Quantity", product3Quantity)
            startActivity(intent)
        }
    }

    private fun calculateDiscountedPrice(price: Int, discountPercentage: Int): Int {
        val discountAmount = (price * discountPercentage) / 100
        return price - discountAmount
    }
}
