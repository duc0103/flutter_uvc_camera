package com.chenyeju

import android.content.Context
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory


class UVCCameraViewFactory(private val plugin: FlutterUVCCameraPlugin,private var channel: MethodChannel) : PlatformViewFactory(StandardMessageCodec.INSTANCE){
    private lateinit var cameraView : UVCCameraView

    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        cameraView = UVCCameraView(context, this.channel,args)
        plugin.setPermissionResultListener(cameraView)
        return cameraView
    }


    fun initCamera(){
        cameraView.initCamera();
    }

    fun openUVCCamera(){
        cameraView.openUVCCamera()
    }

    fun takePicture(callback: UVCStringCallback){
        cameraView.takePicture(callback)
    }
    fun captureVideo(callback: UVCStringCallback){
        cameraView.captureVideo(callback)
    }

    fun captureStreamStart(){
        cameraView.captureStreamStart()
    }
    fun captureStreamStop(){
        cameraView.captureStreamStop()
    }


    fun getAllPreviewSizes() = cameraView.getAllPreviewSizes();
    fun getCurrentCameraRequestParameters() = cameraView.getCurrentCameraRequestParameters();

    fun closeCamera() {
        cameraView.closeCamera()
    }

    fun updateResolution(arguments: Any?) {
        cameraView.updateResolution(arguments)
    }


}