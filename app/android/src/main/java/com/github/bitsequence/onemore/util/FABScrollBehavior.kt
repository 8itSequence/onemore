package com.github.bitsequence.onemore.util

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.BounceInterpolator

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

import com.google.android.material.floatingactionbutton.FloatingActionButton

class FABScrollBehavior(
		private val context: Context,
		private val attributeSet: AttributeSet
) : CoordinatorLayout.Behavior<FloatingActionButton>() {

	companion object {
		const val FALLBACK_ACTIONBAR_SIZE: Float = 147F
		const val ANIMATION_START_DELAY: Long = 100L
	}

	private var isFABHidden = false

	private val typedValue = TypedValue()

	private val canResolve = context
			.theme
			.resolveAttribute(
					android.R.attr.actionBarSize,
					typedValue,
					true)

	private val actionBarSize: Float = if (canResolve) {
		TypedValue.complexToDimension(
				typedValue.data,
				context
						.resources
						.displayMetrics)
	} else {
		FALLBACK_ACTIONBAR_SIZE
	}


	override fun onNestedScroll(
			coordinatorLayout: CoordinatorLayout,
			child: FloatingActionButton,
			target: View,
			dxConsumed: Int,
			dyConsumed: Int,
			dxUnconsumed: Int,
			dyUnconsumed: Int,
			type: Int,
			consumed: IntArray) {
		super.onNestedScroll(
				coordinatorLayout,
				child,
				target,
				dxConsumed,
				dyConsumed,
				dxUnconsumed,
				dyUnconsumed,
				type,
				consumed)

		val scrollingUp = dyConsumed > 0
		if ((isFABHidden && scrollingUp)
				|| (!isFABHidden && !scrollingUp)
				|| dyConsumed == 0) {
			return
		}

		val offset = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
			actionBarSize/2F + child.paddingBottom + child.paddingTop
		} else {
			actionBarSize
		}
		if (scrollingUp) {
			child
					.animate()
					.translationY(child.height + offset)
					.setStartDelay(ANIMATION_START_DELAY)
					.setInterpolator(AnticipateInterpolator(context, attributeSet))
					.start()

			isFABHidden = true
		} else {
			child
					.animate()
					.translationY(child.height - offset)
					.setStartDelay(ANIMATION_START_DELAY)
					.setInterpolator(BounceInterpolator(context, attributeSet))
					.start()

			isFABHidden = false
		}
	}

	override fun onStartNestedScroll(
			coordinatorLayout: CoordinatorLayout,
			child: FloatingActionButton,
			directTargetChild: View,
			target: View,
			axes: Int,
			type: Int): Boolean = axes == ViewCompat.SCROLL_AXIS_VERTICAL

}