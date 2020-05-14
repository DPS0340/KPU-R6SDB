package com.dps0340.R6SDB

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_gun.*
import kotlinx.android.synthetic.main.gun_item.view.*
import org.jetbrains.anko.startActivity
import org.json.JSONArray

class gunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gun)
        val actionBar = supportActionBar
        actionBar!!.title = "총"
        val arr = JSONArray(
            "[\"gun_l85a2\", \"gun_ar33\", \"gun_g36c\", \"gun_r4_c\", \"gun_556xi\", \"gun_f2\", \"gun_ak_12\", \"gun_aug_a2\", \"gun_552_commando\", \"gun_416_c_carbine\", \"gun_c8_sfw\", \"gun_mk17_cqb\", \"gun_para_308\", \"gun_type_89\", \"gun_c7e\", \"gun_m762\", \"gun_v308\", \"gun_spear_308\", \"gun_ar_1550\", \"gun_m4\", \"gun_ak_74m\", \"gun_arx200\", \"gun_f90\", \"gun_commando_9\", \"gun_fmg_9\", \"gun_mp5k\", \"gun_ump45\", \"gun_mp5\", \"gun_p90\", \"gun_9x19vsn\", \"gun_mp7\", \"gun_9mm_c1\", \"gun_mpx\", \"gun_m12\", \"gun_mp5sd\", \"gun_pdw9\", \"gun_vector_45_acp\", \"gun_t_5_smg\", \"gun_scorpion_evo_3_a1\", \"gun_k1a\", \"gun_mx4_storm\", \"gun_aug_a3\", \"gun_p10_roni\", \"gun_m590a1\", \"gun_m1014\", \"gun_sg_cqb\", \"gun_sasg_12\", \"gun_m870\", \"gun_super_90\", \"gun_spas_12\", \"gun_spas_15\", \"gun_supernova\", \"gun_ita12l\", \"gun_six12\", \"gun_six12_sd\", \"gun_fo_12\", \"gun_bosg122\", \"gun_acs12\", \"gun_tcsg12\", \"gun_417\", \"gun_ots_03\", \"gun_camrs\", \"gun_sr_25\", \"gun_mk_14_ebr\", \"gun_6p41\", \"gun_g8a1\", \"gun_m249\", \"gun_t_95_lsw\", \"gun_lmg_e\", \"gun_alda_556\", \"gun_m249_saw\", \"gun_p226_mk_25\", \"gun_m45_meusoc\", \"gun_57_usg\", \"gun_p9\", \"gun_lfp586\", \"gun_gsh_18\", \"gun_pmm\", \"gun_p12\", \"gun_mk1_9mm\", \"gun_d_50\", \"gun_prb92\", \"gun_p229\", \"gun_usp40\", \"gun_q_929\", \"gun_rg15\", \"gun_bailiff_410\", \"gun_keratos_357\", \"gun_1911_tacops\", \"gun_p_10c\", \"gun_44_mag_semi_auto\", \"gun_sdp_9mm\", \"gun_smg_11\", \"gun_bearing_9\", \"gun_c75_auto\", \"gun_smg_12\", \"gun_spsmg9\", \"gun_ita12s\", \"gun_super_shorty\"]\n"
        )
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val len = arr.length() - 1
        val res = resources
        for (i in 0..len) {
            val gun = inflater.inflate(R.layout.gun_item, null)
            val name = arr[i] as String
            val resID = res.getIdentifier(name, "drawable", packageName)
            gun.img.setImageResource(resID)
            gun.text.setText(name.replace("_", " ").replace("gun ", "").toUpperCase())
            gun.setOnClickListener {
                startActivity<describeActivity>(
                    "id" to arr[i].toString()
                )
            }
            gunroot.addView(gun)
            gunroot.invalidate()
        }
    }
}
