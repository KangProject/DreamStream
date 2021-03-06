package com.AridRayne.DreamStream;

import android.annotation.SuppressLint;
import android.service.dreams.DreamService;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class DreamStreamService extends DreamService {

	DreamStream dreamStream;
	ImageView iv;
//	DreamTarget target;
	
//	@Override
//	public boolean dispatchTouchEvent(MotionEvent event) {
//		return dreamStream.touchEvent(event) || super.dispatchTouchEvent(event);
//	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		
		setInteractive(true);
		setFullscreen(true);
		dreamStream = DreamStream.getInstance();
		dreamStream.initialize(this);
//		target = new DreamTarget();
//		iv = new ImageView(this);
//		pv = new PhotoView(this);
//		dpv = new DreamPhotoView(this, dreamStream);
//		setContentView(iv);
//		dreamStream.setTarget(target);
		setContentView(dreamStream.getViewPager());
	}

	@Override
	public void onDreamingStarted() {
		super.onDreamingStarted();
		dreamStream.start();
	}

	@Override
	public void onDreamingStopped() {
		super.onDreamingStopped();
		dreamStream.stop();
	}
//	
//	class DreamTarget extends ImageTarget {
//
//		@Override
//		public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from) {
//			super.onBitmapLoaded(bitmap, from);
//			iv.setImageBitmap(bitmap);
//		}
//		
//	}
}
