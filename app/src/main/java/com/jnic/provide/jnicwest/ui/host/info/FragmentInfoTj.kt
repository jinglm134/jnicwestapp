package com.jnic.provide.jnicwest.ui.host.info

import com.jnic.provide.jnicwest.R
import com.jnic.provide.jnicwest.base.BaseFragment
import com.jnic.provide.jnicwest.bean.Info_TjBean
import com.jnic.provide.jnicwest.constant.API
import com.jnic.provide.jnicwest.net.BaseCallback
import com.jnic.provide.jnicwest.net.WebList
import com.jnic.provide.jnicwest.util.GsonUtils
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_info_tongji.*

/**
 * Created by ${jaylm}
 * on 2018/1/16.
 */
class FragmentInfoTj : BaseFragment() {
    private var leagueId: Int = 0
    private var kind: Int = 0
    private lateinit var mData: Info_TjBean

    override fun bindLayout(): Int {
        return R.layout.fragment_info_tongji
    }

    override fun initView() {
        super.initView()
        leagueId = arguments!!.getInt("leagueId")
        kind = arguments!!.getInt("kind")
    }

    override fun setValue() {
        super.setValue()
        loadData()
    }

    fun loadData() {
        val url = API.Statics + "&type=" + kind + "&leagueId=" + leagueId
        WebList.base(url, object : BaseCallback(mActivity) {
            override fun onSuccess(response: Response<String>) {
                mData = GsonUtils.parseJsonWithGson(response.body(), Info_TjBean::class.java)
                invalidateView()
            }

            override fun onSuccess(jsonString: String) {
            }

        })
    }

    fun invalidateView() {
        val data = mData.statics
        tv_z_c_c.text = "总场次:" + data.matchCount
        tv_zhu_sheng.text = data.homeWinCount.toString() + "(" + data.homeWinPer + ")"
        tv_ping.text = data.equalCount.toString() + "(" + data.equalPer + ")"
        tv_ke_sheng.text = data.awayWinCount.toString() + "(" + data.awayWinPer + ")"

        tv_z_j_q.text = data.goalCount.toString()
        tv_y_s.text = data.matchCount.toString()
        tv_p_j_j_q.text = data.goalAvg.toString()

        tv_z_c_j_q.text = data.homeAvg.toString()
        tv_k_c_j_q.text = data.awayAvg.toString()

        tv_per_1.text = data.moreZeroPer
        tv_total_1.text = data.moreZero.toString()

        tv_per_2.text = data.moreOnePer
        tv_total_2.text = data.moreOne.toString()

        tv_per_3.text = data.moreTwoPer
        tv_total_3.text = data.moreTwo.toString()

        tv_per_4.text = data.moreThreePer
        tv_total_4.text = data.moreThree.toString()

    }
}