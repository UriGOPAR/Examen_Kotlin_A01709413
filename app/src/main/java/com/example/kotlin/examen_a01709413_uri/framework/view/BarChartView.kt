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
        val maxCases = Math.max(totalCases, newCases).toFloat()

        // Asegúrate de que maxCases no sea 0 para evitar dividir por cero
        if (maxCases > 0) {
            val totalBarWidth = Math.max(minBarWidth.toFloat(), maxBarWidth * (totalCases / maxCases))
            val totalRect = RectF(
                paddingLeft.toFloat(),
                paddingTop.toFloat(),
                paddingLeft + totalBarWidth,
                paddingTop + 50f // Altura arbitraria para la barra
            )
            canvas.drawRect(totalRect, totalPaint)

            val newBarWidth = Math.max(minBarWidth.toFloat(), maxBarWidth * (newCases / maxCases))
            val newRect = RectF(
                paddingLeft.toFloat(),
                paddingTop + 60f,
                paddingLeft + newBarWidth,
                paddingTop + 110f
            )
            canvas.drawRect(newRect, newPaint)
        } else {
            // Dibuja alguna representación para cuando no hay casos, como una línea o un texto
            // Por ejemplo, dibujar una línea que indique "No hay datos"
            val textPaint = Paint().apply {
                color = 0xFF000000.toInt() // Color negro
                textSize = 40f // Tamaño de texto arbitrario
                textAlign = Paint.Align.CENTER
            }
            canvas.drawText("No data", width / 2f, height / 2f, textPaint)
        }
    }
}