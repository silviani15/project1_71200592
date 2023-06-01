package id.ac.ukdw.project1_71200592

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    private lateinit var purchaseDetailsTextView: TextView
    private lateinit var shippingOptionTextView: TextView
    private lateinit var totalCostTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        purchaseDetailsTextView = findViewById(R.id.purchaseDetailsTextView)
        shippingOptionTextView = findViewById(R.id.shippingOptionTextView)
        totalCostTextView = findViewById(R.id.totalCostTextView)

        val purchaseDetails = "Detail Pembelian:\n" +
                "- Produk 1: 5\n" +
                "- Produk 2: 3\n" +
                "- Produk 3: 2"
        purchaseDetailsTextView.text = purchaseDetails

        val shippingOption = intent.getStringExtra("shippingOption")
        shippingOptionTextView.text = "Opsi Pengiriman: $shippingOption"

        val totalCost = 150000 // contoh total biaya
        totalCostTextView.text = "Total Biaya: $totalCost"
    }
}
