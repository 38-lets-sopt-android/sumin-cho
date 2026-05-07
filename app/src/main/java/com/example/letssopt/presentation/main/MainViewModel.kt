package com.example.letssopt.presentation.main

import androidx.lifecycle.ViewModel
import com.example.letssopt.R

data class BannerItem(
    val image: Int
)

data class PartyItem(
    val image: Int,
    val startTime: String,
    val tag: String
)
class MainViewModel: ViewModel(){
   private val mainbannerList = listOf(
       BannerItem(R.drawable.img_mainbannerlist_1),
       BannerItem(R.drawable.img_mainbannerlist_2),
       BannerItem(R.drawable.img_mainbannerlist_3),
       BannerItem(R.drawable.img_mainbannerlist_4),
       BannerItem(R.drawable.img_mainbannerlist_5),
       BannerItem(R.drawable.img_mainbannerlist_6)
    )

    fun getMainBannerList() = mainbannerList

    private val whatgorithmeList = listOf(
        BannerItem(R.drawable.img_whatgorithmelist_1),
        BannerItem(R.drawable.img_whatgorithmelist_2),
        BannerItem(R.drawable.img_whatgorithmelist_3),
        BannerItem(R.drawable.img_whatgorithmelist_4),
        BannerItem(R.drawable.img_whatgorithmelist_5),
        BannerItem(R.drawable.img_whatgorithmelist_6),
        BannerItem(R.drawable.img_whatgorithmelist_7),
        BannerItem(R.drawable.img_whatgorithmelist_8),
        BannerItem(R.drawable.img_whatgorithmelist_9),
        BannerItem(R.drawable.img_whatgorithmelist_10)
    )

    fun getWhatgorithmeList() = whatgorithmeList

    private val releasedList = listOf(
        BannerItem(R.drawable.img_releasedlist_7),
        BannerItem(R.drawable.img_releasedlist_8),
        BannerItem(R.drawable.img_releasedlist_9),
        BannerItem(R.drawable.img_releasedlist_10),
        BannerItem(R.drawable.img_releasedlist_11),
        BannerItem(R.drawable.img_releasedlist_12),
        BannerItem(R.drawable.img_releasedlist_1),
        BannerItem(R.drawable.img_releasedlist_2),
        BannerItem(R.drawable.img_releasedlist_3),
        BannerItem(R.drawable.img_releasedlist_4),
        BannerItem(R.drawable.img_releasedlist_5),
        BannerItem(R.drawable.img_releasedlist_6)
    )

    fun getReleasedList() = releasedList

    private val watchaPartyList = listOf(
        PartyItem(
            image = R.drawable.img_watchaparty_1,
            startTime = "(일) 오후 03:20 시작",
            tag = "# SBS 인기가요"
        ),
        PartyItem(
            image = R.drawable.img_watchaparty_2,
            startTime = "(금) 오후 05:00 시작",
            tag = "# 뮤직뱅크"
        ),
        PartyItem(
            image = R.drawable.img_watchaparty_3,
            startTime = "(토) 오후 03:20 시작",
            tag = "# 쇼! 음악중심"
        ),
        PartyItem(
            image = R.drawable.img_watchaparty_4,
            startTime = "(목) 오후 06:00 시작",
            tag = "# 엠카운트다운"
        ),
        PartyItem(
            image = R.drawable.img_watchaparty_5,
            startTime = "(수) 오후 05:00 시작",
            tag = "# 쇼! 챔피언"
        )
    )

    fun getWatchaPartyList() = watchaPartyList
    }