package com.example.letssopt

import androidx.lifecycle.ViewModel

data class BannerItem(
    val image: Int
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
}