package tvrakyat.myflix;

import android.media.MediaPlayer;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;

public class VideoEnabledWebChromeClient extends WebChromeClient implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
    public interface ToggledFullscreenCallback
    {
        public void toggledFullscreen(boolean fullscreen);
    }

    private View activityNonVideoView;
    private ViewGroup activityVideoView;
    private View loadingView;
    private VideoEnabledWebView webView;

    private boolean isVideoFullscreen;
    private FrameLayout videoViewContainer;
    private CustomViewCallback videoViewCallback;

    private ToggledFullscreenCallback toggledFullscreenCallback;

    public VideoEnabledWebChromeClient()
    {
    }

    public VideoEnabledWebChromeClient(View activityNonVideoView, ViewGroup activityVideoView)
    {
        this.activityNonVideoView = activityNonVideoView;
        this.activityVideoView = activityVideoView;
        this.loadingView = null;
        this.webView = null;
        this.isVideoFullscreen = false;
    }

    public VideoEnabledWebChromeClient(View activityNonVideoView, ViewGroup activityVideoView, View loadingView)
    {
        this.activityNonVideoView = activityNonVideoView;
        this.activityVideoView = activityVideoView;
        this.loadingView = loadingView;
        this.webView = null;
        this.isVideoFullscreen = false;
    }

    public VideoEnabledWebChromeClient(View activityNonVideoView, ViewGroup activityVideoView, View loadingView, VideoEnabledWebView webView)
    {
        this.activityNonVideoView = activityNonVideoView;
        this.activityVideoView = activityVideoView;
        this.loadingView = loadingView;
        this.webView = webView;
        this.isVideoFullscreen = false;
    }

    public boolean isVideoFullscreen()
    {
        return isVideoFullscreen;
    }

    public void setOnToggledFullscreen(ToggledFullscreenCallback callback)
    {
        this.toggledFullscreenCallback = callback;
    }

    @Override
    public void onShowCustomView(View view, CustomViewCallback callback)
    {
        if (view instanceof FrameLayout)
        {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();

            this.isVideoFullscreen = true;
            this.videoViewContainer = frameLayout;
            this.videoViewCallback = callback;

            activityNonVideoView.setVisibility(View.INVISIBLE);
            activityVideoView.addView(videoViewContainer, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            activityVideoView.setVisibility(View.VISIBLE);

            if (focusedChild instanceof android.widget.VideoView)
            {
                android.widget.VideoView videoView = (android.widget.VideoView) focusedChild;

                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            }
            else
            {
                if (webView != null && webView.getSettings().getJavaScriptEnabled() && focusedChild instanceof SurfaceView)
                {
                    String js = "javascript:";
                    js += "var _ytrp_html5_video_last;";
                    js += "var _ytrp_html5_video = document.getElementsByTagName('video')[0];";
                    js += "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {";
                    {
                        js += "_ytrp_html5_video_last = _ytrp_html5_video;";
                        js += "function _ytrp_html5_video_ended() {";
                        {
                            js += "_VideoEnabledWebView.notifyVideoEnd();";
                        }
                        js += "}";
                        js += "_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);";
                    }
                    js += "}";
                    webView.loadUrl(js);
                }
            }

            if (toggledFullscreenCallback != null)
            {
                toggledFullscreenCallback.toggledFullscreen(true);
            }
        }
    }

    @Override
    public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) // Available in API level 14+, deprecated in API level 18+
    {
        onShowCustomView(view, callback);
    }

    @Override
    public void onHideCustomView()
    {
        if (isVideoFullscreen)
        {
            activityVideoView.setVisibility(View.INVISIBLE);
            activityVideoView.removeView(videoViewContainer);
            activityNonVideoView.setVisibility(View.VISIBLE);

            if (videoViewCallback != null && !videoViewCallback.getClass().getName().contains(".chromium."))
            {
                videoViewCallback.onCustomViewHidden();
            }

            isVideoFullscreen = false;
            videoViewContainer = null;
            videoViewCallback = null;

            if (toggledFullscreenCallback != null)
            {
                toggledFullscreenCallback.toggledFullscreen(false);
            }
        }
    }

    @Override
    public View getVideoLoadingProgressView()
    {
        if (loadingView != null)
        {
            loadingView.setVisibility(View.VISIBLE);
            return loadingView;
        }
        else
        {
            return super.getVideoLoadingProgressView();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp)
    {
        if (loadingView != null)
        {
            loadingView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp)
    {
        onHideCustomView();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra)
    {
        return false;
    }

    public boolean onBackPressed()
    {
        if (isVideoFullscreen)
        {
            onHideCustomView();
            return true;
        }
        else
        {
            return false;
        }
    }

}