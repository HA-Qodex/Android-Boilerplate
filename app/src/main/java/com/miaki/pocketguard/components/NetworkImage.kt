package com.miaki.pocketguard.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.miaki.pocketguard.R
import kotlinx.coroutines.Dispatchers

@Composable
fun NetworkImage(
    context: Context,
    modifier: Modifier,
    imageUrl: String,
    contentDescription: String,
    contentScale: ContentScale = ContentScale.Fit
) {

    // Cache clear:
    // context.imageLoader.diskCache?.clear()
    // context.imageLoader.memoryCache?.clear()

    // Build an ImageRequest with Coil
    val listener = object : ImageRequest.Listener {
        override fun onError(request: ImageRequest, result: ErrorResult) {
            super.onError(request, result)
        }

        override fun onSuccess(request: ImageRequest, result: SuccessResult) {
            super.onSuccess(request, result)
        }
    }
    val imageRequest = ImageRequest.Builder(context)
        .data(imageUrl)
        .listener(listener)
        .dispatcher(Dispatchers.IO)
        .memoryCacheKey(imageUrl)
        .diskCacheKey(imageUrl)
        .placeholder(R.drawable.image)
        .error(R.drawable.image_error)
        .fallback(R.drawable.mage_fallback)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .build()

    AsyncImage(
        model = imageRequest,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
    )
}