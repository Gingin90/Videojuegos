package com.example.videojuegos.visualpresentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.videojuegos.databinding.FragmentDetalleBinding

class DetailFragment : Fragment() {
    private var videoJuegoId: String? = null
    lateinit var binding: FragmentDetalleBinding

    private val viewModel: VideojuegosViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            videoJuegoId = it.getString("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater)
        initComponents()
        initWspButton()
        return binding.root
    }

    private fun initComponents() {
        viewModel.superHeroDetailsViewModel(videoJuegoId.toString().toInt())

        viewModel.superHeroDetailLiveData(videoJuegoId.toString().toInt())
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.imageViewImageDetail.load(it.imageUrl){
                        placeholder(R.drawable.loading).error(R.drawable.image_not_available)
                    }
                    binding.tvNameDetail.text = it.name.uppercase()
                    binding.tvOriginDetail.text = it.origin
                    binding.tvYearDetail.text = it.year.toString()
                    binding.tvDetail.text = it.superPower
                    binding.tvDetail.text = it.color
                    if (!it.translate) {
                        binding.tvTranslateDetail.text = getString(R.string.translate_false)
                    } else {

                        binding.tvTranslateDetail.text = getString(R.string.translate_true)
                    }
                }
            }
    }

    private fun initWspButton() {
        viewModel.videoJuegosDetailLiveData(videoJuegoId.toString().toInt())
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    if (it != null) {

                        binding.floatingActionButtonemail.setOnClickListener {
                            val intent = Intent(Intent.ACTION_VIEW)
                            val uri = "whatsapp://send?phone=" + "+5697683223"+
                                    "&text=" + "Hola" +
                                    "Quisiera votar por el siguiente juego $it.name"
                            intent.data = Uri.parse(uri)
                            startActivity(intent)

                        }


                    }
                }
            }
    }
}