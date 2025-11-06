import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class SetlistsResponse(@SerialName("setlist") val setlists: List<Setlist>)

@Serializable
data class Setlist(
    val artist: SetlistArtist,
    val venue: Venue,
    val eventDate: String,
    val tour: Tour? = null,
    val sets: Sets,
    val url: String,
) {
    val name: String
        get() = "${venue.name}, $eventDate"
}

@Serializable
data class Venue(val name: String, val location: String? = null)

@Serializable
data class Tour(val name: String)

@Serializable
data class Sets(@SerialName("set") val setItems: List<SetItem>)

@Serializable
data class SetItem(@SerialName("song") val setlistSongs: List<SetlistSong>)

@Serializable
data class SetlistSong(val name: String, @SerialName("cover") val coverArtist: SetlistArtist? = null)

private fun String.toLocalDate(): LocalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("dd-MM-yyyy"))

internal fun SetlistsResponse.getLatestAvailableSetlist(): Setlist? =
    this.setlists.firstOrNull { it.eventDate.toLocalDate() < LocalDate.now() && it.sets.setItems.isNotEmpty() }