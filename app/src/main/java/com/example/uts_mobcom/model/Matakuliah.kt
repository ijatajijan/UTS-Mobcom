package com.example.uts_mobcom.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes


data class Matakuliah(
    @StringRes val matkul: Int,
    @StringRes val sks: Int,
    @DrawableRes val image: Int
)
