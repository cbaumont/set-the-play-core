data class Playlist(
    val name: String,
    val tracks: List<SpotifyTrack>?,
    val description: String? = null,
    val spotifyUrl: String? = null,
)
