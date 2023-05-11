package com.example.jsonfromnetpractice

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Complex1") val complex1:String,
    @SerializedName("ComplexName") val complexName:String,
    @SerializedName("FValue") val fValue:Int,
    @SerializedName("RptDeptName") val rptDeptName:String
)
