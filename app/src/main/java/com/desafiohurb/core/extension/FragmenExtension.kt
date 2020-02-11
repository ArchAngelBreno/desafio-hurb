package com.desafiohurb.core.extension

import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

inline fun <reified T : Fragment> FragmentManager.startFragment(
    @DrawableRes idContainer: Int, vararg params: Pair<String, Any?>
) {
    val fragment = T::class.java.newInstance() as Fragment
    val bundle = Bundle()

    params.forEach {
        bundle.addPut(it.first, it.second)
    }

    fragment.arguments = bundle

    this.beginTransaction()
        .replace(idContainer, fragment)
        .commit()
}

fun Bundle.addPut(key: String, value: Any?) {
    when (value) {
        is Long -> putLong(key, value)
        is String -> putString(key, value)
        is Boolean -> putBoolean(key, value)
        is Float -> putFloat(key, value)
        is Double -> putDouble(key, value)
        is Int -> putInt(key, value)
        is Parcelable -> putParcelable(key, value)
    }
}