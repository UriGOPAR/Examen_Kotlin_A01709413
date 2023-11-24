package com.example.kotlin.examen_a01709413_uri.framework.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class BarChartView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var totalCases = 0
    private var newCases = 0
    private val minBarWidth = 10

    private val totalPaint = Paint().apply {
        color = 0xFFEBC034.toInt() // Color amarillo para el total de casos
        style = Paint.Style.FILL
    }

    private val newPaint = Paint().apply {
        color = 0xFF34EB40.toInt() // Color verde para los nuevos casos
        style = Paint.Style.FILL
    }

    fun setValues(total: Int, new: Int) {
        totalCases = total
        newCases = new
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val maxBarWidth = width - paddingLeft - paddingRight
        val fullBarThreshold = 5000

        // Calcula la anchura de la barra para el total de casos
        val totalBarWidth = if (totalCases > fullBarThreshold) {
            maxBarWidth.toFloat() // Si es mayor a 5000, llena la barra completamente
        } else {
            maxBarWidth * (totalCases.toFloat() / fullBarThreshold) // De lo contrario, escala proporcionalmente
        }

        // Dibuja el rectángulo para el total de casos
        val totalRect = RectF(
            paddingLeft.toFloat(),
            paddingTop.toFloat(),
            paddingLeft + totalBarWidth,
            paddingTop + 50f
        )
        canvas.drawRect(totalRect, totalPaint)

        // Calcula la anchura de la barra para los nuevos casos
        val newBarWidth = if (newCases > fullBarThreshold) {
            maxBarWidth.toFloat() // Si es mayor a 5000, llena la barra completamente
        } else {
            maxBarWidth * (newCases.toFloat() / fullBarThreshold) // De lo contrario, escala proporcionalmente
        }

        // Dibuja el rectángulo para los nuevos casos
        val newRect = RectF(
            paddingLeft.toFloat(),
            paddingTop + 60f,
            paddingLeft + newBarWidth,
            paddingTop + 110f
        )
        canvas.drawRect(newRect, newPaint)
    }
}
