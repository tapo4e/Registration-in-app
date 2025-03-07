package com.example.registration.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Flag_of_Russia: ImageVector
    get() {
        if (_Flag_of_Russia != null) {
            return _Flag_of_Russia!!
        }
        _Flag_of_Russia = ImageVector.Builder(
            name = "Flag_of_Russia",
            defaultWidth = 900.dp,
            defaultHeight = 600.dp,
            viewportWidth = 9f,
            viewportHeight = 6f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 0f)
                horizontalLineTo(9f)
                verticalLineTo(3f)
                horizontalLineTo(0f)
                verticalLineTo(0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFD52B1E)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 3f)
                horizontalLineTo(9f)
                verticalLineTo(6f)
                horizontalLineTo(0f)
                verticalLineTo(3f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF0039A6)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 2f)
                horizontalLineTo(9f)
                verticalLineTo(4f)
                horizontalLineTo(0f)
                verticalLineTo(2f)
                close()
            }
        }.build()
        return _Flag_of_Russia!!
    }

private var _Flag_of_Russia: ImageVector? = null


