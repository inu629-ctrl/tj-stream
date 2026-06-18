# TJ Stream - Android Video Streaming App

A simple Android app that automatically streams and plays video using ExoPlayer with HLS support.

## Features

✅ **Auto-Play on Launch** - Video starts playing as soon as the app opens  
✅ **HLS Streaming** - Supports HTTP Live Streaming (HLS) format  
✅ **ExoPlayer Integration** - Uses Google's ExoPlayer for reliable playback  
✅ **Full Player Controls** - Play, pause, seek, and volume controls  
✅ **Landscape Orientation** - Optimized for full-screen video viewing  

## Stream Configuration

**Default Stream URL:**
```
https://fifaworldcup.cfd/api/stream?q=english
```

**Content-Type:** `application/vnd.apple.mpegurl` (HLS)

To change the stream URL, edit the `STREAM_URL` constant in `MainActivity.kt`:

```kotlin
private val STREAM_URL = "https://your-stream-url.com"
```

## Requirements

- Android 7.0 (API Level 24) or higher
- Internet connection
- INTERNET and ACCESS_NETWORK_STATE permissions

## Dependencies

- **ExoPlayer 2.19.0** - For HLS streaming and video playback
- **AndroidX Core & AppCompat** - For Android support libraries
- **Material Design** - For UI components

## Building & Running

1. Clone the repository:
   ```bash
   git clone https://github.com/inu629-ctrl/tj-stream.git
   cd tj-stream
   ```

2. Open in Android Studio

3. Build and run on an Android device or emulator:
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

## Architecture

- **MainActivity.kt** - Initializes ExoPlayer and handles streaming lifecycle
- **activity_main.xml** - Contains StyledPlayerView for video display
- **AndroidManifest.xml** - Configures app permissions and orientation

## Lifecycle Management

The app properly handles:
- ✅ Player initialization on app start
- ✅ Resume playback on app resume
- ✅ Pause on app pause
- ✅ Release resources on app stop

## Troubleshooting

**Issue: Video won't play**
- Check internet connection
- Verify stream URL is correct and accessible
- Check firewall/proxy settings

**Issue: Playback is buffering**
- Check network speed
- Try a different stream URL
- Reduce video quality if available

## License

MIT License

## Support

For issues or feature requests, please open a GitHub issue.
