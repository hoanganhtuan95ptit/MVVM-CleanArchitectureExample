package net.lab.myapplication.data.api.retrofit

import com.fasterxml.jackson.databind.ObjectMapper
import net.lab.myapplication.BuildConfig
import net.lab.myapplication.data.entities.Image
import okhttp3.*

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url().uri().toString()
            val responseString = when {
                uri.endsWith("image") -> {
                    val images = ArrayList<Image>()
                    for (x in 200..300) {
                        images.add(
                            (Image(
                                x.toString(),
                                "https://picsum.photos/id/$x/500/500"
                            ))
                        )
                    }
                    ObjectMapper().writeValueAsString(images)
                }
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                        responseString.toByteArray()
                    )
                )
                .addHeader("content-type", "application/json")
                .build()
        } else {
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and bound to be used only with DEBUG mode")
        }
    }

}