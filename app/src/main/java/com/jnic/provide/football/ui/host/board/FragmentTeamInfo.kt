package com.jnic.provide.football.ui.host.board

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jnic.provide.football.R
import com.jnic.provide.football.base.BaseFragment
import com.jnic.provide.football.bean.TeamInfoBean
import kotlinx.android.synthetic.main.fragment_team_info.*

/**
 * Created by ${jaylm}
 * on 2018/1/22.
 */
class FragmentTeamInfo : BaseFragment() {

    private lateinit var mData: TeamInfoBean
    override fun bindLayout(): Int {
        return R.layout.fragment_team_info
    }

    override fun initView() {
        super.initView()
        mData = Gson().fromJson<TeamInfoBean>(arguments!!.getString("data"), object : TypeToken<TeamInfoBean>() {}.type)


        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.setLoadingMoreEnabled(false)
        xRecyclerView.setPullRefreshEnabled(false)

        initData()
    }

    private fun initData() {
        val data = mData.base_info
        tv_name.text = data.team_name + "(" + data.team_en_name + ")"
        tv_date.text = data.founded + "年成立." + data.country + "." + data.city
        tv_chang.text = data.venue_name + ".容纳" + data.venue_capacity + "人"
        tv_phone.text = "电话" + data.telephone
        tv_email.text = "邮箱" + data.email
        tv_address.text = "地址" + data.address
    }
}