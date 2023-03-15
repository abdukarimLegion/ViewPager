package com.naa.uz.viewpagerlearn.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.naa.uz.viewpagerlearn.SecondFragment
import com.naa.uz.viewpagerlearn.UserFragment
import com.naa.uz.viewpagerlearn.models.User


class UserPagerAdapter(
    val userList: List<User>,
    var titleList: List<String>,
    fragmentPagerAdapter: FragmentManager
) :
    FragmentStatePagerAdapter(fragmentPagerAdapter, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = userList.size

    override fun getItem(position: Int): Fragment {
//        if (position == 1) {
//            return SecondFragment()
//        }
        return UserFragment.newInstance(userList[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}