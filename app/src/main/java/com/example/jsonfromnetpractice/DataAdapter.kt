package com.example.jsonfromnetpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val dataList: List<Data>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recylcerview,parent,false)
        return DataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val tvComplex1 = holder.itemView.findViewById<TextView>(R.id.tvComplex1)
        val tvComplexName = holder.itemView.findViewById<TextView>(R.id.tvComplexName)
        val tvFValue = holder.itemView.findViewById<TextView>(R.id.tvFValue)
        val tvRptDeptName = holder.itemView.findViewById<TextView>(R.id.tvRptDeptName)
        tvComplex1.text = dataList[position].complex1
        tvComplexName.text = dataList[position].complexName
        tvFValue.text = dataList[position].fValue.toString()
        tvRptDeptName.text = dataList[position].rptDeptName
    }
}