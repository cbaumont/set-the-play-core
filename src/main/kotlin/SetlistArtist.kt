import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchArtistResponse(
    @SerialName("artist")
    val artists: List<SetlistArtist>,
)

@Serializable
data class SetlistArtist(
    val name: String,
    @SerialName("mbid")
    val setlistFmReference: String,
)

internal fun SearchArtistResponse.findExactArtist(artistName: String): SetlistArtist? = artists.find { it.name == artistName }