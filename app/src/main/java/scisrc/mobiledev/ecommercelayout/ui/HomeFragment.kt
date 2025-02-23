package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var promoAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()
    private val promoList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        // 🔹 ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        binding.recyclerViewPromos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        promoAdapter = ProductAdapter(promoList)
        binding.recyclerViewPromos.adapter = promoAdapter

        // 🔹 โหลดข้อมูล
        loadProducts()
        loadPromotions()
    }

    private fun loadProducts() {
        productList.add(Product("Nike Zoom Vomero 5", "6000 บาท", R.drawable.zoom5,"รองเท้า"))
        productList.add(Product("Nike Killshot 2 Leather", "3600 บาท", R.drawable.killshot2,"รองเท้า"))
        productList.add(Product("Nike Calm", "1800 บาท", R.drawable.airmax,"รองเท้า"))
        productList.add(Product("Nike Air Max 1 '86 OG G", "6000 บาท", R.drawable.nikecalm,"รองเท้า"))
        productList.add(Product("USAB Limited Home", "3100 บาท", R.drawable.usa,"เสื้อผ้า"))
        productList.add(Product("Jordan Brooklyn Fleece", "2500 บาท", R.drawable.jacket,"เสื้อผ้า"))
        productAdapter.notifyDataSetChanged()
    }

    private fun loadPromotions() {
        promoList.add(Product("Nike Zoom Vomero 5", "ลดเหลือ 5000 บาท", R.drawable.zoom5,"รองเท้า"))
        promoList.add(Product("Nike Killshot 2 Leather", "ลดเหลือ 2900 บาท", R.drawable.killshot2,"รองเท้า"))
        promoList.add(Product("Nike Calm", "ลดเหลือ 1500 บาท", R.drawable.airmax,"รองเท้า"))
        promoList.add(Product("Nike Air Max 1 '86 OG G", "ลดเหลือ 5400 บาท", R.drawable.nikecalm,"รองเท้า"))
        promoAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}