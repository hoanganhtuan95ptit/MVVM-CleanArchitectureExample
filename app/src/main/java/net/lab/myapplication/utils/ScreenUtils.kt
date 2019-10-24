package citigo.core.util


import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import androidx.annotation.DimenRes
import androidx.annotation.NonNull

class ScreenUtils {
    companion object {

        @JvmStatic
        fun getScreenHeight(@NonNull context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.y
        }

        @JvmStatic
        fun getScreenWidth(@NonNull context: Context): Int {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.x
        }

        @JvmStatic
        fun spFromRes(@NonNull context: Context, @DimenRes res: Int): Float {
            return context.resources.getDimension(res)
        }

        @JvmStatic
        fun dpFromRes(@NonNull context: Context, @DimenRes res: Int): Float {
            return context.resources.getDimension(res) / context.resources.displayMetrics.density
        }

        @JvmStatic
        fun pxFromRes(context: Context, @DimenRes dpRes: Int): Int {
            return context.resources.getDimensionPixelSize(dpRes)
        }

        @JvmStatic
        fun dp2px(@NonNull context: Context, dp: Float): Float {
            val scale = context.resources.displayMetrics.density
            return dp * scale + 0.5f
        }

        @JvmStatic
        fun sp2px(@NonNull context: Context, sp: Float): Float {
            val scale = context.resources.displayMetrics.scaledDensity
            return sp * scale
        }
    }
}
