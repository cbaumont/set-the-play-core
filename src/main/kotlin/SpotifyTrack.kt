import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchTracksResponse(@SerialName("tracks") val trackItem: TrackItem)

@Serializable
data class TrackItem(@SerialName("items") val tracks: List<SpotifyTrack>)

@Serializable
data class SpotifyTrack(
    val name: String,
    val artists: List<SpotifyArtist>,
    val album: Album,
    val type: String,
    val uri: String? = null,
)

@Serializable
data class SpotifyArtist(val name: String, val uri: String)

@Serializable
data class Album(val name: String, val uri: String)
